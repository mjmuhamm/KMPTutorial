package com.example.kmptutorial.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class TodoScreenState {
    data object Nothing : TodoScreenState()
    data object Loading : TodoScreenState()
    data class Error(val msg: String) : TodoScreenState()
    data class Success(val todos: List<ToDoDTO>) : TodoScreenState()
}

class ToDoViewModel : ViewModel() {

    private val apiService = ToDoApiServiceImpl(ToDoNetwork.networkClient)

    private val _state = MutableStateFlow<TodoScreenState>(TodoScreenState.Nothing)
    val state = _state.asStateFlow()

    fun loadTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                TodoScreenState.Loading

            }
            when(val response = apiService.getTodos()) {
                is Response.Error<*> -> {
                    TodoScreenState.Error(response.msg)

                }
                is Response.Success<*> -> {
                    _state.update {
                        TodoScreenState.Success(response.result as List<ToDoDTO>)
                    }
                }
            }
        }
    }
}

val toDoModelFactory = viewModelFactory {
    initializer {
        ToDoViewModel()
    }
}
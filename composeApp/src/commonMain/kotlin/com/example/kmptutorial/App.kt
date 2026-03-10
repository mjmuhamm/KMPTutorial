package com.example.kmptutorial

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kmptutorial.db.ToDoDB
import com.example.kmptutorial.network.ToDoViewModel
import com.example.kmptutorial.network.TodoScreenState
import com.example.kmptutorial.network.toDoModelFactory

@Composable

fun App(toDoDB: ToDoDB) {
    MaterialTheme {
        var showContent by remember { mutableStateOf(true) }
        val todoViewModel = viewModel<ToDoViewModel>(factory = toDoModelFactory)
        val screenState by todoViewModel.state.collectAsStateWithLifecycle()
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
//                    Text(getPlatformName())
                    Button(onClick = {todoViewModel.loadTodos()}) {
                        Text("Click Me")
                    }
                    when(val state = screenState) {
                        is TodoScreenState.Error -> {
                            Text("Error Occurred : ${(screenState as TodoScreenState.Error).msg}")
                        }
                        TodoScreenState.Loading -> {
                            Text("Fetching todos...")
                        }
                        TodoScreenState.Nothing -> {
                            Text("Click on load to fetch todos")
                        }
                        is TodoScreenState.Success -> {
                            LazyColumn() {
                                items(state.todos) { todo ->
                                    Card(Modifier.fillMaxWidth()) {
                                        Column(Modifier.padding(16.dp)) {
                                            Text("Title: ${todo.title}")
                                            Text("Id: ${todo.id}")
                                            Text("UserId: ${todo.userId}")
                                            Text("isCompleted: ${todo.completed}")
                                        }
                                    }
                                }
                            }
                        }
                    }
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
                }
            }
        }
    }
}
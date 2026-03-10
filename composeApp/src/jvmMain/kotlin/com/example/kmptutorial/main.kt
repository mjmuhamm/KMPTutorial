package com.example.kmptutorial

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.kmptutorial.network.getDatabaseBuilder

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPTutorial",
    ) {
        App(getDatabaseBuilder().build())
    }
}
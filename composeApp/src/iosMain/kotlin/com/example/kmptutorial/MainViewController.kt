package com.example.kmptutorial

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmptutorial.network.getDatabaseBuilder

fun MainViewController() = ComposeUIViewController { App(getDatabaseBuilder().build()) }
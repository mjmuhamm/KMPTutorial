package com.example.kmptutorial

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package com.example.composetask.domain.usecase

import java.util.Calendar

class GreetingsUseCase {

    operator fun invoke(): String {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        return when (hour) {
            in 5..11 -> "Good Morning"
            in 12..17 -> "Good Afternoon"
            in 18..21 -> "Good Evening"
            else -> "Welcome"
        }
    }

}
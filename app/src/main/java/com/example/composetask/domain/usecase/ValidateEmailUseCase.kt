package com.example.composetask.domain.usecase

class ValidateEmailUseCase {

    operator fun invoke(email: String): Boolean {
        return isValidEmail(email)
    }

    private fun isValidEmail(email: String): Boolean {
        // Regex for validating email
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return email.matches(emailRegex.toRegex())
    }
}
package com.example.composetask

import com.example.composetask.domain.usecase.ValidateEmailUseCase
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class EmailValidationTest {

    private lateinit var validateEmailUseCase: ValidateEmailUseCase

    @Before
    fun setUp() {
        validateEmailUseCase = ValidateEmailUseCase()
    }

    @Test
    fun `return true for correct email`() {

        val validEmail = "test@example.com"
        val result = validateEmailUseCase(validEmail)

        assertTrue(result)
    }

    @Test
    fun `check email without symbol should return false`() {

        val invalidEmail = "testexample.com"
        val result = validateEmailUseCase(invalidEmail)
        assertFalse(result)
    }

    @Test
    fun `check email without domain must return false`() {

        val invalidEmail = "test@"
        val result = validateEmailUseCase(invalidEmail)
        assertFalse(result)
    }

}
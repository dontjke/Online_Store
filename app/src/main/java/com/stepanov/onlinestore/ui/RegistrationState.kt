package com.stepanov.onlinestore.ui

data class RegistrationState(
    val firstNameUntouched: Boolean = true,
    val lastNameUntouched: Boolean = true,
    val firstNameValidationError: String? = null,
    val lastNameValidationError: String? = null,
    val phoneValidationError: String? = null
)
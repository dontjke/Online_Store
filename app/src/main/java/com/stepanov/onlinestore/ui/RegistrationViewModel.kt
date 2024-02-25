package com.stepanov.onlinestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stepanov.onlinestore.utils.isStringContainCyrillic

class RegistrationViewModel(
    private val stateLiveData: MutableLiveData<RegistrationState> = MutableLiveData(
        RegistrationState()
    )
) : ViewModel() {

    fun getStateLiveData(): LiveData<RegistrationState> = stateLiveData

    fun onFirstNameChanged(firstName: String) {
        validateFirstName(firstName)
    }

    fun onLastNameChanged(lastName: String) {
        validateLastName(lastName)
    }

    private fun validateFirstName(firstName: String) {
        var errorMessage: String? = null
        if (firstName.isBlank()) errorMessage = "Required Field!"
        if (!firstName.isStringContainCyrillic()) errorMessage = "Cyrillic only"
        stateLiveData.postValue(
            stateLiveData.value?.copy(
                firstNameValidationError = errorMessage,
                firstNameUntouched = false

            )
        )
    }

    private fun validateLastName(lastName: String) {
        var errorMessage: String? = null
        if (lastName.isBlank()) errorMessage = "Required Field!"
        if (!lastName.isStringContainCyrillic()) errorMessage = "Cyrillic only"
        stateLiveData.postValue(
            stateLiveData.value?.copy(
                lastNameValidationError = errorMessage,
                lastNameUntouched = false
            )
        )
    }


}
package com.stepanov.onlinestore.ui

import android.text.Editable
import android.text.TextWatcher

interface TextFieldValidation : TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    override fun afterTextChanged(p0: Editable?) {}
}
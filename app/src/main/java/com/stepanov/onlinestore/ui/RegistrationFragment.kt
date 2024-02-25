package com.stepanov.onlinestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stepanov.onlinestore.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding: FragmentRegistrationBinding
        get() {
            return _binding!!
        }
    private val registrationViewModel: RegistrationViewModel by lazy {
        ViewModelProvider(this)[RegistrationViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registrationViewModel.getStateLiveData().observe(viewLifecycleOwner) {
            with(binding) {
                firstNameTextInputLayout.error = it.firstNameValidationError
                firstNameTextInputLayout.isErrorEnabled = it.firstNameValidationError != null
                lastNameTextInputLayout.error = it.lastNameValidationError
                lastNameTextInputLayout.isErrorEnabled = it.lastNameValidationError != null
                button.isEnabled =
                    it.firstNameValidationError == null && it.lastNameValidationError == null
                            && !it.firstNameUntouched && !it.lastNameUntouched

            }
        }
        setupListener()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RegistrationFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupListener() {
        binding.firstNameEditText.addTextChangedListener(object : TextFieldValidation {
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                registrationViewModel.onFirstNameChanged(text.toString())
            }
        })
        binding.lastNameEditText.addTextChangedListener(object : TextFieldValidation {
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                registrationViewModel.onLastNameChanged(text.toString())
            }
        })
    }
}
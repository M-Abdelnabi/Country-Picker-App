package com.example.countrypickerapp.presentation.countryPickerScreen

interface CountryPickerInteractionListener {
    fun onDropDownClicked()
    fun onCountrySelected(country: CountryUIState)
    fun onDismissClicked()
    fun onEnterPhoneNumber(phoneNumber: String)
    fun onCheckBoxClicked(isChecked: Boolean)
    fun onContinueButtonClicked()
}
package com.example.countrypickerapp.presentation.countryPickerScreen

data class CountryPickerUIState(
    val countries: List<CountryUIState> = emptyList(),
    val selectedCountry: CountryUIState = CountryUIState(),
    val isDropDownMenuExpanded: Boolean = false ,
    val isCheckedBox : Boolean = false ,
    val phoneNumber: String = "",
    val isButtonEnabled: Boolean = false
)
data class CountryUIState (
    val countryName: String = "",
    val countryCode: String = "",
    val countryFlag: Int = 0
)
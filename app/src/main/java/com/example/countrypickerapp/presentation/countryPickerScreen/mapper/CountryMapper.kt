package com.example.countrypickerapp.presentation.countryPickerScreen.mapper


import com.example.countrypickerapp.domain.entity.Country
import com.example.countrypickerapp.presentation.countryPickerScreen.CountryUIState

fun Country.toCountryUIState(): CountryUIState {
    return CountryUIState(
        countryName = this.countryName,
        countryCode = this.countryCode,
        countryFlag = this.countryFlag
    )
}

fun List<Country>.toCountryUIStateList(): List<CountryUIState> {
    return this.map { it.toCountryUIState() }
}
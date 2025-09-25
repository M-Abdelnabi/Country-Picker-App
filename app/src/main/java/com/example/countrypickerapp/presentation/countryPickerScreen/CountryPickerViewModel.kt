package com.example.countrypickerapp.presentation.countryPickerScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrypickerapp.domain.usecase.GetCountriesUseCase
import com.example.countrypickerapp.presentation.countryPickerScreen.mapper.toCountryUIStateList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountryPickerViewModel(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel(), CountryPickerInteractionListener {
    private val _state = MutableStateFlow(CountryPickerUIState())
    val state = _state.asStateFlow()

    init {
        loadCountries()
    }

    private fun loadCountries() {
        viewModelScope.launch {
            val countries = getCountriesUseCase.invoke().toCountryUIStateList()
            _state.value = _state.value.copy(
                countries = countries,
                selectedCountry = countries.first()
            )
        }
    }

    override fun onDropDownClicked() {
        _state.value =
            _state.value.copy(isDropDownMenuExpanded = !_state.value.isDropDownMenuExpanded)
    }

    override fun onCountrySelected(country: CountryUIState) {
        _state.value = _state.value.copy(selectedCountry = country)
    }

    override fun onDismissClicked() {
        _state.value = _state.value.copy(isDropDownMenuExpanded = false)
    }

    override fun onEnterPhoneNumber(phoneNumber: String) {
        _state.value = _state.value.copy(phoneNumber = phoneNumber)

    }

    override fun onCheckBoxClicked(isChecked: Boolean) {
        _state.value = _state.value.copy(isCheckedBox = isChecked, isButtonEnabled = isChecked)
    }

    override fun onContinueButtonClicked() {
    }

}


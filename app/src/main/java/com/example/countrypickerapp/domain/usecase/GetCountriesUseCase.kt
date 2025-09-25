package com.example.countrypickerapp.domain.usecase

import com.example.countrypickerapp.domain.repository.CountryPickerRepository

class GetCountriesUseCase(
    private val countryPickerRepository: CountryPickerRepository
) {
    suspend operator fun invoke() = countryPickerRepository.getCountries()
}
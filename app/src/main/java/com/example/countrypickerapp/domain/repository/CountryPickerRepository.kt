package com.example.countrypickerapp.domain.repository

import com.example.countrypickerapp.domain.entity.Country

interface CountryPickerRepository {
    suspend fun getCountries(): List<Country>
}
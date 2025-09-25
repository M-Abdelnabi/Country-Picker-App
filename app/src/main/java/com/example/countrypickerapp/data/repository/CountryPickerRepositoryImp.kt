package com.example.countrypickerapp.data.repository

import com.example.countrypickerapp.data.mapper.toCountryList
import com.example.countrypickerapp.data.source.remote.CountryRemoteDataSource
import com.example.countrypickerapp.domain.entity.Country
import com.example.countrypickerapp.domain.repository.CountryPickerRepository

class CountryPickerRepositoryImp(
    private val countryRemoteDataSource: CountryRemoteDataSource
) : CountryPickerRepository {
    override suspend fun getCountries(): List<Country> {
        return countryRemoteDataSource.getCountries().toCountryList()
    }
}
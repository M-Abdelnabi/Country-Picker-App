package com.example.countrypickerapp.data.source.remote

import com.example.countrypickerapp.data.source.remote.dto.CountryDto

interface CountryRemoteDataSource {
    suspend fun getCountries(): List<CountryDto>
}
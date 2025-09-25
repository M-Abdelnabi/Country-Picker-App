package com.example.countrypickerapp.data.mapper

import com.example.countrypickerapp.data.source.remote.dto.CountryDto
import com.example.countrypickerapp.domain.entity.Country


fun CountryDto.toCountry(): Country {
    return Country(
        countryName = this.countryName,
        countryCode = this.countryCode,
        countryFlag = this.countryFlag
    )
}

fun List<CountryDto>.toCountryList(): List<Country> {
    return this.map { it.toCountry() }
}
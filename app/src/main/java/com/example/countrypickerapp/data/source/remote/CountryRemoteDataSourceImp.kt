package com.example.countrypickerapp.data.source.remote

import com.example.countrypickerapp.R
import com.example.countrypickerapp.data.source.remote.dto.CountryDto

class CountryRemoteDataSourceImp : CountryRemoteDataSource {
    override suspend fun getCountries(): List<CountryDto> {
        return listOf(
            CountryDto("Egypt", "+20", R.drawable.ic_egypt_flag),
            CountryDto("Afghanistan", "+93", R.drawable.ic_afghanistan_flag),
            CountryDto("Argentina", "+54", R.drawable.ic_argentina_flag),
            CountryDto("Australia", "+61", R.drawable.ic_australia_flag),
            CountryDto("Austria", "+43", R.drawable.ic_austria_flag),
            CountryDto("Bangladesh", "+880", R.drawable.ic_bangladesh_flag),
            CountryDto("Belgium", "+32", R.drawable.ic_belgium_flag),
            CountryDto("Brazil", "+55", R.drawable.ic_brazil_flag),
            CountryDto("Canada", "+1", R.drawable.ic_canada_flag),
            CountryDto("Chile", "+56", R.drawable.ic_chile_flag),
            CountryDto("China", "+86", R.drawable.ic_china_flag),
            CountryDto("Colombia", "+57", R.drawable.ic_colombia_flag),
            CountryDto("Denmark", "+45", R.drawable.ic_denmark_flag),
            CountryDto("Finland", "+358", R.drawable.ic_finland_flag),
            CountryDto("France", "+33", R.drawable.ic_france_flag),
            CountryDto("Germany", "+49", R.drawable.ic_germany_flag),
            CountryDto("Greece", "+30", R.drawable.ic_greece_flag),
            CountryDto("Hong Kong", "+852", R.drawable.ic_hongkong_flag),
            CountryDto("India", "+91", R.drawable.ic_india_flag),
            CountryDto("Iraq", "+964", R.drawable.ic_iraq_flag),
            CountryDto("Italy", "+39", R.drawable.ic_italy_flag),
            CountryDto("Japan", "+81", R.drawable.ic_japan_flag),
            CountryDto("Jordan", "+962", R.drawable.ic_jordan_flag),
            CountryDto("Kuwait", "+965", R.drawable.ic_kuwait_flag),
            CountryDto("Lebanon", "+961", R.drawable.ic_lebanon_flag),
            CountryDto("Qatar", "+974", R.drawable.ic_qatar_flag),
            CountryDto("Russia", "+7", R.drawable.ic_russia_flag),
            CountryDto("Saudi Arabia", "+966", R.drawable.ic_saudiarabia_flag),
            CountryDto("Singapore", "+65", R.drawable.ic_singapore_flag),
            CountryDto("South Africa", "+27", R.drawable.ic_southafrica_flag),
            CountryDto("Spain", "+34", R.drawable.ic_spain_flag),
            CountryDto("Syria", "+963", R.drawable.ic_syria_flag),
            CountryDto("Turkey", "+90", R.drawable.ic_turkey_flag),
            CountryDto("Yemen", "+967", R.drawable.ic_yemen_flag)
        )
    }
}

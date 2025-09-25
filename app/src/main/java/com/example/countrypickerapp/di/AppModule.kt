package com.example.countrypickerapp.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countrypickerapp.MyApplication
import com.example.countrypickerapp.data.repository.CountryPickerRepositoryImp
import com.example.countrypickerapp.data.source.remote.CountryRemoteDataSource
import com.example.countrypickerapp.data.source.remote.CountryRemoteDataSourceImp
import com.example.countrypickerapp.domain.repository.CountryPickerRepository
import com.example.countrypickerapp.domain.usecase.GetCountriesUseCase
import com.example.countrypickerapp.presentation.countryPickerScreen.CountryPickerViewModel

interface AppModule {
    val remoteDataSource: CountryRemoteDataSource
    val repository: CountryPickerRepository
    val useCase: GetCountriesUseCase
}

class AppModuleImpl(
    private val context: Context
) : AppModule {
    override val remoteDataSource: CountryRemoteDataSource by lazy {
        CountryRemoteDataSourceImp()
    }
    override val repository: CountryPickerRepository by lazy {
        CountryPickerRepositoryImp(remoteDataSource)
    }
    override val useCase: GetCountriesUseCase by lazy {
        GetCountriesUseCase(repository)
    }
}

object ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            CountryPickerViewModel::class.java -> {
                CountryPickerViewModel(MyApplication.appModule.useCase) as T
            }

            else -> throw kotlin.IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
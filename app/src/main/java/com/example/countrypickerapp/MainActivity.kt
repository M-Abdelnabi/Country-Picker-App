package com.example.countrypickerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.countrypickerapp.di.ViewModelFactory
import com.example.countrypickerapp.presentation.countryPickerScreen.CountryPickerScreen
import com.example.countrypickerapp.presentation.countryPickerScreen.CountryPickerViewModel
import com.example.countrypickerapp.presentation.theme.CountryPickerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: CountryPickerViewModel = ViewModelProvider(
            this,
            ViewModelFactory
        )[CountryPickerViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            CountryPickerAppTheme {
                CountryPickerScreen(viewModel = viewModel)
            }
        }
    }
}
package com.example.countrypickerapp.presentation.countryPickerScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countrypickerapp.R
import com.example.countrypickerapp.presentation.countryPickerScreen.component.AppHeader
import com.example.countrypickerapp.presentation.countryPickerScreen.component.CountryPickerSection
import com.example.countrypickerapp.presentation.countryPickerScreen.component.GuideLineCheckBox
import com.example.countrypickerapp.presentation.countryPickerScreen.component.MyCustomButton
import com.example.countrypickerapp.presentation.theme.White
import com.example.countrypickerapp.presentation.theme.gray

@Composable
fun CountryPickerScreen(viewModel: CountryPickerViewModel) {
    val state by viewModel.state.collectAsState()
    CountryPickerContent(
        state = state,
        action = viewModel
    )
}

@Composable
fun CountryPickerContent(
    state: CountryPickerUIState,
    action: CountryPickerInteractionListener
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
            .padding(top = 36.dp),
    ) {
        AppHeader(
            modifier = Modifier
                .padding(bottom = 24.dp)
        )

        CountryPickerSection(
            selectedCountry = state.selectedCountry,
            onSelectedCountry = action::onCountrySelected,
            onDismiss = action::onDismissClicked,
            modifier = Modifier.padding(bottom = 2.dp, top = 4.dp),
            isExpanded = state.isDropDownMenuExpanded,
            countries = state.countries,
            value = state.phoneNumber,
            onValueChange = action::onEnterPhoneNumber,
            placeholder = stringResource(R.string._7xxxxxxxx),
            onDropDownClicked = action::onDropDownClicked
        )
        Text(
            text = stringResource(R.string.we_will_use_this_to_verify_your_account),
            fontSize = 12.sp,
            color = gray
        )

        GuideLineCheckBox(
            isChecked = state.isCheckedBox,
            onCheckedChange = action::onCheckBoxClicked,
            modifier = Modifier.padding(top = 18.dp, bottom = 24.dp)
        )

        MyCustomButton(
            onClick = action::onContinueButtonClicked,
            text = stringResource(R.string.continue_button),
            isEnabled = state.isButtonEnabled,
            icon = painterResource(R.drawable.ic_arrow_right)
        )
    }
}
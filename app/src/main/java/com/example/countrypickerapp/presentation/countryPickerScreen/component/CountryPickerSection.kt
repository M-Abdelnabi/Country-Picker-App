package com.example.countrypickerapp.presentation.countryPickerScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countrypickerapp.R
import com.example.countrypickerapp.presentation.theme.Black
import com.example.countrypickerapp.presentation.theme.White
import com.example.countrypickerapp.presentation.theme.gray
import com.example.countrypickerapp.presentation.theme.lightGray
import com.example.countrypickerapp.presentation.countryPickerScreen.CountryUIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPickerSection(
    selectedCountry: CountryUIState,
    onSelectedCountry: (CountryUIState) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    countries: List<CountryUIState>,
    value: String = "",
    maxLength : Int = 11,
    placeholder: String,
    onValueChange: (String) -> Unit,
    onDropDownClicked: () -> Unit = {}
) {
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { onDropDownClicked() },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { newValue ->
                val digitsOnly = newValue.filter { it.isDigit() }.take(maxLength)
                onValueChange(digitsOnly)
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White),
            singleLine = true,
            leadingIcon = {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .menuAnchor(MenuAnchorType.SecondaryEditable, true),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = selectedCountry.countryFlag),
                        contentDescription = stringResource(R.string.flag),
                        modifier = Modifier.size(32.dp)
                    )

                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_down),
                        contentDescription = stringResource(R.string.drop_down_icon),
                        tint = Black,
                    )

                    Text(
                        text = selectedCountry.countryCode,
                        color = Black,
                        maxLines = 1,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            },
            placeholder = {
                Text(
                    text = placeholder,
                    color = gray,
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = lightGray,
                unfocusedBorderColor = lightGray,
                focusedTextColor = Black,
                unfocusedTextColor = Black,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = onDismiss,
            modifier = Modifier.background(White)
        ) {
            countries.forEach { country ->
                DropdownMenuItem(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = country.countryFlag),
                                contentDescription = country.countryName,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(country.countryName + "   " + country.countryCode)
                        }
                    },
                    onClick = {
                        onSelectedCountry(country)
                        onDismiss()
                    },
                    colors = MenuDefaults.itemColors(
                        textColor = Black,
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
fun CountryCodePickerPreview() {
    CountryPickerSection(
        countries = listOf(
            CountryUIState(
                countryName = "United States",
                countryCode = "+1",
                countryFlag = R.drawable.ic_china_flag
            ),
            CountryUIState(
                countryName = "Canada",
                countryCode = "+1",
                countryFlag = R.drawable.ic_austria_flag
            )
        ),
        selectedCountry = CountryUIState(
            countryName = "United States",
            countryCode = "+112",
            countryFlag = R.drawable.ic_egypt_flag
        ),
        onSelectedCountry = {
            CountryUIState(
                countryName = "United States",
                countryCode = "+112",
                countryFlag = R.drawable.ic_china_flag
            )
        },
        onDismiss = { },
        isExpanded = false,
        value = "",
        placeholder = "xxxxxxx",
        onValueChange = {},
        onDropDownClicked = {}
    )
}

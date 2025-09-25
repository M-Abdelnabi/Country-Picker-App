package com.example.countrypickerapp.presentation.countryPickerScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countrypickerapp.R
import com.example.countrypickerapp.presentation.theme.Black

@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.one_last_step),
            color = Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.please_login_or_signup_for_a))
                withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                    append(stringResource(R.string.free))
                }
                append(stringResource(R.string.account_to_continue))
            },
            fontSize = 16.sp,
            color = Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Preview
@Composable
fun AppHeaderPreview() {
    AppHeader()
}
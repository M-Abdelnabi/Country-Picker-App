package com.example.countrypickerapp.presentation.countryPickerScreen.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.countrypickerapp.R
import com.example.countrypickerapp.presentation.theme.Purple40
import com.example.countrypickerapp.presentation.theme.White
import com.example.countrypickerapp.presentation.theme.lightBlue

@Composable
fun GuideLineCheckBox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Purple40,
                checkmarkColor = White,
            )
        )

        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.i_agree_and_comply_to_the))
                withStyle(style = SpanStyle(color = lightBlue)) {
                    append(stringResource(R.string.community_guidelines))
                }
            },
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )
    }

}

@Preview
@Composable
fun GuideLineCheckBoxPreview() {
    GuideLineCheckBox(isChecked = true, onCheckedChange = {})
}
package com.example.countrypickerapp.presentation.countryPickerScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.countrypickerapp.R
import com.example.countrypickerapp.presentation.theme.Purple40
import com.example.countrypickerapp.presentation.theme.White
import com.example.countrypickerapp.presentation.theme.lightGray

@Composable
fun MyCustomButton(
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    icon: Painter? = null
) {
    Button(
        onClick = onClick,
        modifier = Modifier,
        enabled = isEnabled,
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple40,
            contentColor = White,
            disabledContainerColor = lightGray,
            disabledContentColor = White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
            )
            if (icon != null) {
                Icon(
                    painter = icon,
                    tint = White,
                    contentDescription = stringResource(R.string.right_arrow),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun MyCustomButtonPreview() {
    MyCustomButton(
        onClick = {},
        text = "Continue",
        isEnabled = true,
        icon = painterResource(R.drawable.ic_arrow_right)
    )
}



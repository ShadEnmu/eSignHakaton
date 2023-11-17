package com.xaelence.esignhakaton.presentation.screen.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xaelence.esignhakaton.R
import com.xaelence.esignhakaton.ui.theme.DeepBlue
import com.xaelence.esignhakaton.ui.theme.LightPurple

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = Color.DarkGray),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = LightPurple,
            contentColor = Color.White,
        ),
    )
    {
        Text(
            text = stringResource(id = R.string.login),
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}
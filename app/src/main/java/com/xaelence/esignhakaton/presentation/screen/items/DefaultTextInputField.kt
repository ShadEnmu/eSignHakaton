package com.xaelence.esignhakaton.presentation.screen.items

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun DefaultTextInputField(
    modifier: Modifier = Modifier,
    text: MutableState<String>,
    isError: MutableState<Boolean>,
    isSingleLine: Boolean = true,
    labelText: Int
) {
    OutlinedTextField(
        value = text.value,
        onValueChange = { message ->
            text.value = message
            isError.value = message.isEmpty()
        },
        isError = isError.value,
        singleLine = true,
        label = {
            Text(text = stringResource(id = labelText))
        }
    )
}
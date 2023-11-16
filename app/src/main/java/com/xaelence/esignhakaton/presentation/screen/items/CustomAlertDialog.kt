package com.xaelence.esignhakaton.presentation.screen.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.xaelence.esignhakaton.R
import com.xaelence.esignhakaton.ui.theme.LightGray
import com.xaelence.esignhakaton.ui.theme.LightPurple

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomAlertDialog(
    onClickGenerate: () -> Unit = {},
    isKeysGenerated: Boolean = false,
    publicKey: String = "",
    privateKey: String = ""
) {
    val isSingleLinePublicKey = remember {
        mutableStateOf(true)
    }
    val isSingleLinePrivateKey = remember {
        mutableStateOf(true)
    }
    Dialog(
        onDismissRequest = { /*TODO*/ },
        properties = DialogProperties(dismissOnBackPress = true, usePlatformDefaultWidth = false)
    ) {

        Card(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 96.dp)
                .fillMaxWidth(0.9f),
            backgroundColor = LightGray,
            shape = RoundedCornerShape(16.dp)
        ) {
            if (!isKeysGenerated) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = publicKey,
                        onValueChange = {},
                        modifier = Modifier.padding(horizontal = 16.dp),
                        readOnly = true,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_certificate_key),
                                contentDescription = "",
                                modifier = Modifier.clickable {
                                    isSingleLinePublicKey.value = false
                                })

                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = LightPurple,
                            leadingIconColor = LightPurple
                        ),
                        singleLine = isSingleLinePublicKey.value
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = privateKey,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        onValueChange = {},
                        readOnly = true,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_private_key),
                                contentDescription = "",
                                modifier = Modifier.clickable {
                                    isSingleLinePrivateKey.value = false
                                }
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = LightPurple,
                            leadingIconColor = LightPurple
                        ),
                        singleLine = isSingleLinePrivateKey.value
                    )
                }
            } else {
                Column(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Сертификат и секретный ключ не были сгенерированы.",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedButton(
                        onClick = onClickGenerate,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightPurple,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Сгенерировать",
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogPreview() {
    CustomAlertDialog(
        publicKey = "asdlasdlaskdpqkpqdfpkonspocasasc;q,ww;dqw,m;lfq;sm;almf;aslfnqpo",
        privateKey = "asldla;sldma;lsmf;almwf;lam;lsfma;fm;lamq;fl"
    )
}
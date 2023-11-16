package com.xaelence.esignhakaton.presentation.screen.local_cabinet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xaelence.esignhakaton.R
import com.xaelence.esignhakaton.ui.theme.DeepBlue
import com.xaelence.esignhakaton.ui.theme.LightGray
import com.xaelence.esignhakaton.ui.theme.LightPurple
import com.xaelence.esignhakaton.ui.theme.White

@Composable
fun LocalCabinetScreen() {
    val isDialogShowed = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(start = 16.dp),
                backgroundColor = DeepBlue,
                shape = RoundedCornerShape(16.dp, 16.dp, 16.dp, 32.dp),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_user_icon),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(Color.DarkGray),
                            modifier = Modifier
                                .background(color = White, shape = CircleShape)
                                .border(1.dp, color = Color.Black, shape = CircleShape)
                                .size(64.dp),
                            contentScale = ContentScale.Inside
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "Иванов Иван Иванович",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "Факультет: ПИиИИ",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Группа: Б721",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            Column(
                modifier = Modifier.padding(4.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    backgroundColor = LightPurple,
                    modifier = Modifier
                        .size(80.dp)
                        .clickable { isDialogShowed.value = true },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_certificate_key),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    backgroundColor = LightPurple,
                    modifier = Modifier
                        .size(80.dp)
                        .clickable { isDialogShowed.value = true },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_private_key),
                            contentDescription = ""
                        )
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn() {
            item {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_history_24),
                        modifier = Modifier.size(48.dp),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(Color.DarkGray)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Иcтория",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun LocalCabinetScreenPreview() {
    LocalCabinetScreen()
}
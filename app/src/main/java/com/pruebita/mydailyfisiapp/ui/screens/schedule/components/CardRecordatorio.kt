package com.pruebita.mydailyfisiapp.ui.screens.schedule.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pruebita.mydailyfisiapp.R
import com.pruebita.mydailyfisiapp.ui.theme.poppins


@Composable
fun CardRecordatorio(showMyDialog: MutableState<Boolean>) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, end = 20.dp, start = 20.dp)
            .fillMaxWidth()
            .height(105.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_evento_home),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Spacer(modifier = Modifier.padding(10.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .weight(0.2f)
                    .height(70.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.calendario_horario),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(35.dp)
                )

            }
            Spacer(modifier = Modifier.padding(10.dp))
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Reunion de Gestion de Proyectos",
                    fontFamily = poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.baseline_access_time_filled_24),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(

                        text = "20:00 - 21:00",
                        fontFamily = poppins,
                        color = Color.White,
                        modifier = Modifier.wrapContentHeight()
                    )
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.1f)
                    .padding(top = 4.dp),
            ){
                IconButton(onClick = { expanded = true })
                {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null, // Puedes proporcionar una descripción opcional
                        tint = Color.White, // Color del icono
                    )

                }


                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    offset = DpOffset(x = 0.dp, y = -60.dp),
                    modifier = Modifier
                        .background(Color.White)
                        .height(80.dp),
                ){
                    DropdownMenuItem(
                        modifier = Modifier.weight(0.5f),
                        text = {
                            Text(
                                text = "Editar recordatorio",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xFF000000),
                                )
                            )

                        },
                        onClick = {  },
                    )
                    DropdownMenuItem(
                        modifier = Modifier.weight(0.5f),
                        text = {
                            Text(
                                text = "Marcar como hecho",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xFF000000),
                                )
                            )
                        },
                        onClick = {expanded = false;showMyDialog.value = true},
                    )
                }

            }
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }

}
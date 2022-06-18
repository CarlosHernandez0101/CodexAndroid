package com.example.codexbettingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGray

@Composable
fun RequestGameView() {
    var gameText = remember { mutableStateOf("") }
    var minOdds = remember { mutableStateOf("") }
    var maxOdds = remember { mutableStateOf("") }
    var sporbook = remember { mutableStateOf("") }
    var anyGameSelected = remember { mutableStateOf(true) }
    var matchSelected = remember { mutableStateOf(false) }
    var leagueSelected = remember { mutableStateOf(false) }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(CodexBlack)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(CodexBlack),
            horizontalAlignment = Alignment.Start,
        ) {
            CodexNavigationBar()

            Text(
                "Solicitar partido",
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier.padding(15.dp)
            )

            Divider(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(15.dp),
                color = CodexGray
            )

            Text(
                "Solicitar",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 15.dp)
            )

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .padding(top = 20.dp)
                .padding(start = 15.dp)
            ) {
                MultiSelectorOption(selected = anyGameSelected) {
                    anyGameSelected.value = true
                    matchSelected.value = false
                    leagueSelected.value = false
                }

                Text("Cualquier evento", color = Color.White,  fontSize = 20.sp, modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .padding(top = 20.dp)
                .padding(start = 15.dp)
            ) {
                MultiSelectorOption(selected = matchSelected) {
                    anyGameSelected.value = false
                    matchSelected.value = true
                    leagueSelected.value = false
                }


                Text("Partido", color = Color.White,  fontSize = 20.sp, modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .padding(top = 20.dp)
                .padding(start = 15.dp)
            ) {
                MultiSelectorOption(selected = leagueSelected) {
                    anyGameSelected.value = false
                    matchSelected.value = false
                    leagueSelected.value = true
                }


                Text("Liga/Competición", color = Color.White,  fontSize = 20.sp, modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            }

            Column(modifier = Modifier.padding(start = 15.dp)) {
                if (!anyGameSelected.value) {
                    GenericCodexTextField(gameText, KeyboardType.Text, {

                    })
                }
            }

            Divider(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(15.dp),
                color = CodexGray
            )

            Text(
                "Cuotas",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 15.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .padding(horizontal = 15.dp)
            ) {

                Text("Cuota mínima", color = Color.White,  fontSize = 20.sp)

                Text("Cuota máxima", color = Color.White,  fontSize = 20.sp)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                    .padding(horizontal = 15.dp)
            ) {

                GenericCodexTextField(minOdds, KeyboardType.Number, {

                })

                GenericCodexTextField(maxOdds, KeyboardType.Number, {

                })

            }

            Divider(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(15.dp),
                color = CodexGray
            )

            Text(
                "Fechas",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 15.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .padding(horizontal = 15.dp)
            ) {

                Text("Desde", color = Color.White,  fontSize = 20.sp)

                Text("Fecha", color = Color.White,  fontSize = 20.sp)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .padding(horizontal = 15.dp)
            ) {

                Text("Hasta", color = Color.White,  fontSize = 20.sp)

                Text("Fecha", color = Color.White,  fontSize = 20.sp)
            }

            Divider(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(15.dp),
                color = CodexGray
            )

            Column(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .fillMaxWidth()
            ) {
                Text("Casa de apuestas", color = Color.White,  fontSize = 20.sp)

                GenericCodexTextField(sporbook, KeyboardType.Text, {

                })
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 240.dp)
                    .fillMaxWidth()
            ) {
                ContinueButton(text = "Solicitar partido", onClick = {

                })
            }
            
        }
    }
}



@Preview(showBackground = true)
@Composable
fun RequestGameViewPreview() {
    CodexBettingTheme {
        RequestGameView()
    }
}
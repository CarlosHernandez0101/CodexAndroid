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
    var layOdds = remember { mutableStateOf("") }

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
                //MultiSelectorOption(true)

                Text("Cualquier evento", color = Color.White,  fontSize = 20.sp, modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .padding(top = 20.dp)
                .padding(start = 15.dp)
            ) {
                //MultiSelectorOption(false)

                Text("Partido", color = Color.White,  fontSize = 20.sp, modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .padding(top = 20.dp)
                .padding(start = 15.dp)
            ) {
                //MultiSelectorOption(false)

                Text("Liga/Competición", color = Color.White,  fontSize = 20.sp, modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            }

            Column(modifier = Modifier.padding(start = 15.dp)) {
                CodexTextField("Liga")
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

                CodexCalculatorTextField(layOdds, KeyboardType.Number, {

                })

                CodexCalculatorTextField(layOdds, KeyboardType.Number, {

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

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(start = 15.dp)) {
                Text("Casa de apuestas", color = Color.White,  fontSize = 20.sp)

                CodexTextField("Casa")

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp)
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
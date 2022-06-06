package com.example.codexbettingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGolden
import com.example.codexbettingapp.ui.theme.CodexGray

@Composable
fun CalculatorView() {
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

            Column(modifier = Modifier.padding(15.dp)) {

                Text("Tipo de apuesta", color = Color.White,  fontSize = 20.sp)

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 20.dp)) {
                    MultiSelectorOption()

                    Text("Dinero Real", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(horizontal = 10.dp))

                }

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 5.dp)) {
                    MultiSelectorOption()

                    Text("Apuesta gratis", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(10.dp))
                }
                
                Card(
                    backgroundColor = CodexGolden,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .padding(bottom = 10.dp)
                        .fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .background(CodexGolden)
                            .padding(horizontal = 15.dp)
                    ) {

                        Text("Importe de apuesta (Bookie)", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(vertical = 10.dp))

                        CodexCalculatorBackStakeTextField()

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        ) {

                            Text("Cuota a favor", color = Color.White,  fontSize = 20.sp)

                            Text("Comisión %", color = Color.White,  fontSize = 20.sp)
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp)
                        ) {

                            CodexCalculatorTextField()


                            CodexCalculatorTextField()

                        }

                    }    
                }

                Card(
                    backgroundColor = CodexGolden,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .background(CodexGray)
                            .padding(horizontal = 15.dp)
                    ) {

                        Text("Apuesta en contra (Exchange)", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(10.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        ) {

                            Text("Cuota en contra", color = Color.White,  fontSize = 20.sp)

                            Text("Comisión %", color = Color.White,  fontSize = 20.sp)
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp)
                        ) {

                            CodexCalculatorTextField()


                            CodexCalculatorTextField()

                        }
                    }
                }

                Card(
                    backgroundColor = CodexGray,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text("Dinero por apostar", color = Color.White,  fontSize = 20.sp)
                        
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("$0.0", color = Color.White,  fontSize = 20.sp)

                            //TODO: ADD COPY TO CLIPBOARD ICON
                        }
                    }
                }

                Card(
                    backgroundColor = CodexGray,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text("Riesgo requerido", color = Color.White,  fontSize = 20.sp)

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("$0.0", color = Color.White,  fontSize = 20.sp)

                            //TODO: ADD COPY TO CLIPBOARD ICON
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Text("Bookie", color = Color.White,  fontSize = 20.sp)

                    Text("Exchange", color = Color.White,  fontSize = 20.sp)

                    Text("Total", color = Color.White,  fontSize = 20.sp)
                }

                Card(
                    backgroundColor = CodexGolden,
                    modifier = Modifier
                        .height(70.dp)
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text("Si el sportbook gana", color = Color.White,  fontSize = 20.sp)
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Text("$0.0", color = Color.White,  fontSize = 20.sp)

                    Text("$0.0", color = Color.White,  fontSize = 20.sp)

                    Text("$0.0", color = Color.White,  fontSize = 20.sp)
                }

                Card(
                    backgroundColor = CodexGray,
                    modifier = Modifier
                        .height(70.dp)
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text("Si el Exchange gana", color = Color.White,  fontSize = 20.sp)
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Text("$0.0", color = Color.White,  fontSize = 20.sp)

                    Text("$0.0", color = Color.White,  fontSize = 20.sp)

                    Text("$0.0", color = Color.White,  fontSize = 20.sp)
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text("Ganarás", color = Color.White,  fontSize = 28.sp, modifier = Modifier.padding(end = 15.dp))

                        Text("$0.0", color = Color.White,  fontSize = 28.sp)

                    }
                }

                Text(
                    "Verificar apuesta",
                    color = Color.White,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .padding(top = 40.dp)
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    VerifyBetRequirement(text = "El resultado a favor y en contra es el mismo en ambas casas de apuestas ", isDone = false)

                    VerifyBetRequirement(text = "El resultado a favor y en contra es el mismo en ambas casas de apuestas ", isDone = false)

                    VerifyBetRequirement(text = "El resultado a favor y en contra es el mismo en ambas casas de apuestas ", isDone = false)

                    VerifyBetRequirement(text = "El resultado a favor y en contra es el mismo en ambas casas de apuestas ", isDone = false)
                }
            }
        }
    }
}

@Composable
fun CodexCalculatorBackStakeTextField() {
    TextField(
        value = "",
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(Color.White)
            .padding(top = 15.dp),
        onValueChange = {

        })
}

@Composable
fun CodexCalculatorTextField() {
    TextField(
        value = "",
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        modifier = Modifier
            .height(30.dp)
            .width(130.dp)
            .background(Color.White)
            .padding(top = 15.dp),
        onValueChange = {

        })
}

@Composable
fun MultiSelectorOption() {

    RadioButton(
        selected = true,
        onClick = { /*TODO*/ },
        colors = RadioButtonDefaults.colors(
            selectedColor = CodexGolden,
            unselectedColor = Color.White
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CalculatorViewPreview() {

    CodexBettingTheme {
        CalculatorView()
    }
}
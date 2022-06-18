package com.example.codexbettingapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGray

@Composable
fun VerifyBetView() {

    var checkedValue = remember { mutableStateOf(false) }

    val list = listOf(
        "El partido elegido está disponible para la promoción",
        "La cuota de la apuesta es mayor a la cuota miníma",
        "El partido está dentro de las fechas de vigencia",
        "Los partidos coinciden en fecha y en hora",
        "El resultado a favor y en contra es el mismo en ambas casas de apuestas",
        "El monto por apostar está dentro del rango permitido",
        "Las ganancias y riesgo coinciden con los de la calculadora",
        "El resultado por apostar tiene dinero suficiente en la bolsa",
        "En caso de existir, la apuesta no excede el límite de ganancia"
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(CodexBlack)
    ) {

            var requirements by remember {
                mutableStateOf(
                    list.map {
                        RequirementItem(
                            title = "$it",
                            isSelected = false
                        )
                    }
                )
            }

        Column(Modifier.background(CodexBlack)) {

            CodexNavigationBar()

            LazyColumn() {

                items(requirements.size) { i ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable {
                                requirements = requirements.mapIndexed { j, requirement ->
                                    if (i == j) {
                                        requirement.copy(isSelected = !requirement.isSelected)
                                    } else requirement
                                }
                                checkedValue.value = requirements.all {
                                    it.isSelected
                                }
                            }
                            .fillMaxWidth()
                            .background(CodexBlack)
                            .padding(horizontal = 20.dp)
                    ) {

                        Text(
                            requirements[i].title,
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 15.dp)
                                .padding(top = 15.dp)
                        )

                        if (requirements[i].isSelected) {

                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Selected",
                                tint = Color.Green,
                                modifier = Modifier
                                    .size(20.dp)
                                    .border(BorderStroke(2.dp, Color.White))

                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(RectangleShape)
                                    .background(CodexBlack)
                                    .border(BorderStroke(2.dp, Color.White))
                            )
                        }
                    }
                }
            }

            SucessDialog(showDialog = checkedValue.value) {
                checkedValue.value = false
            }
        }
    }
}

@Composable
fun SucessDialog(
    showDialog: Boolean,
    dismissDialog: () -> Unit
) {
    if(showDialog) {
        AlertDialog(

            onDismissRequest = {
                dismissDialog()
            },
            title = {
                Text(text = "Éxito", style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ))
            },
            text = {
                Text("Es seguro hacer su apuesta")
            },
            confirmButton = {
                ContinueButton(text = "OK", onClick = {
                    dismissDialog()
                })
            },
            dismissButton = {

            },
            backgroundColor = CodexGray,
            contentColor = Color.White
        )
    }
}

fun checkRequirementes(checked: MutableState<Boolean>, list: List<RequirementItem>) {
    checked.value = list.all {
        it.isSelected
    }
}


@Preview(showBackground = true)
@Composable
fun VerifyBetViewPreview() {
    CodexBettingTheme {
        VerifyBetView()
    }
}
package com.example.codexbettingapp

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGray
import java.util.*

@Composable
fun RequestGameView() {
    var gameText = remember { mutableStateOf("") }
    var minOdds = remember { mutableStateOf("") }
    var maxOdds = remember { mutableStateOf("") }
    var sporbook = remember { mutableStateOf("") }
    var anyGameSelected = remember { mutableStateOf(true) }
    var matchSelected = remember { mutableStateOf(false) }
    var leagueSelected = remember { mutableStateOf(false) }
    var messageText = remember { mutableStateOf("") }

    val context = LocalContext.current

    val fromYear: Int
    val fromMonth: Int
    val fromDay: Int
    val toYear: Int
    val toMonth: Int
    val toDay: Int

    val calendar = Calendar.getInstance()
    fromYear = calendar.get(Calendar.YEAR)
    fromMonth = calendar.get(Calendar.MONTH)
    fromDay = calendar.get(Calendar.DAY_OF_MONTH)
    toYear = calendar.get(Calendar.YEAR)
    toMonth = calendar.get(Calendar.MONTH)
    toDay = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()
    val fromDate = remember { mutableStateOf("Seleccionar fecha") }
    val toDate = remember { mutableStateOf("Seleccionar fecha") }

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

                val fromDatePickerDialog = DatePickerDialog(
                    context,
                    {_: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                        fromDate.value = "$dayOfMonth/$month/$year"
                    }, fromYear, fromMonth, fromDay
                )

                Button(
                    onClick = { fromDatePickerDialog.show() },
                    colors = ButtonDefaults.buttonColors(CodexGray)
                ) {
                    Text("${fromDate.value}", color = Color.White,  fontSize = 20.sp)
                }
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

                val toDatePickerDialog = DatePickerDialog(
                    context,
                    {_: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                        toDate.value = "$dayOfMonth/$month/$year"
                    }, toYear, toMonth, toDay
                )

                Button(
                    onClick = { toDatePickerDialog.show() },
                    colors = ButtonDefaults.buttonColors(CodexGray)
                ) {
                    Text("${toDate.value}", color = Color.White,  fontSize = 20.sp)
                }
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

                    if (matchSelected.value || leagueSelected.value) {
                        if (gameText.value.isNullOrEmpty()) {
                            Log.i("CAMPO VACIO", "Escriba el nombre del evento a elegir")
                            return@ContinueButton
                        }
                    }

                    if (minOdds.value.isNullOrEmpty() || maxOdds.value.isNullOrEmpty()) {
                        Log.i("CAMPO VACIO", "Escriba las cuota miníma y máxima")
                        return@ContinueButton
                    }

                    if (fromDate.value.isLettersOnly()) {
                        Log.i("CAMPO VACIO", "Escriba las fechas del evento")
                        return@ContinueButton
                    }

                    if (toDate.value.isLettersOnly()) {
                        Log.i("CAMPO VACIO", "Escriba las fechas del evento")
                        return@ContinueButton
                    }

                    if (sporbook.value.isNullOrEmpty()) {
                        Log.i("CAMPO VACIO", "Escriba la casa de apuestas")
                        return@ContinueButton
                    }

                    messageText.value = ""
                    messageText.value  += "Hola, soy el cliente y quiero solicitar: "

                    if(anyGameSelected.value) {
                        messageText.value += "Cualquier evento"
                    }

                    if(matchSelected.value) {
                        messageText.value += "El partido: ${gameText}"
                    }

                    if(leagueSelected.value) {
                        messageText.value += "Un partido para la liga o competición: ${gameText}"
                    }

                    messageText.value += "" +
                            "\n" +

                            "Cuota mínima: ${minOdds.value}\n" +
                            "\n" +
                            "Cuota máxima: ${maxOdds.value}\n" +
                            "\n" +
                            "Desde: ${fromDate.value}\n"
                            "\n" +
                            "Hasta: ${toDate.value}\n" +
                            "\n" +
                            "Casa de apuestas: ${sporbook.value}"

                    Log.i("Mensaje", "${messageText.value}")

                })
            }
            
        }
    }
}

fun String.isLettersOnly(): Boolean {
    val len = this.length
    for (i in 0 until len) {
        if (!this[i].isLetter()) {
            return false
        }
    }
    return true
}

@Composable
fun GameDatePicker(context: Context) {

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }


}

@Preview(showBackground = true)
@Composable
fun RequestGameViewPreview() {
    CodexBettingTheme {
        RequestGameView()
    }
}
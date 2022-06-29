package com.example.codexbettingapp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.example.codexbettingapp.ui.theme.CodexGolden
import com.example.codexbettingapp.ui.theme.CodexGray

@Composable
fun CalculatorView() {

    var realMoneySelected = remember { mutableStateOf(true) }
    var freeBetSelected = remember { mutableStateOf(false) }
    var backStake = remember { mutableStateOf("") }
    var backOdds = remember { mutableStateOf("") }
    var backCommission = remember { mutableStateOf("") }
    var layOdds = remember { mutableStateOf("") }
    var layComission = remember { mutableStateOf("") }
    var moneyToBet = remember { mutableStateOf(0.0) }
    var liability = remember { mutableStateOf(0.0) }
    var leftSideSportbook = remember { mutableStateOf(0.0) }
    var leftSideExchange = remember { mutableStateOf(0.0) }
    var rightSideSportbook = remember { mutableStateOf(0.0) }
    var rightSideExchange = remember { mutableStateOf(0.0) }
    var totalProfitSportbook = remember { mutableStateOf(0.0) }
    var totalProfitExchange = remember { mutableStateOf(0.0) }
    var totalProfit = remember { mutableStateOf(0.0) }
    var profitText = remember { mutableStateOf("") }
    var profitColor = remember { mutableStateOf(Color.White) }

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
                    MultiSelectorOption(realMoneySelected, action = {
                        realMoneySelected.value = true
                        freeBetSelected.value = false
                        calculate(
                            freeBetMode = freeBetSelected.value,
                            backStake = backStake.value,
                            backOdds = backOdds.value,
                            backCommission = backCommission.value,
                            layOdds = layOdds.value,
                            layCommission = layComission.value,
                            moneyToBet = moneyToBet,
                            liability = liability,
                            leftSideSportbook = leftSideSportbook,
                            leftSideExchange = leftSideExchange,
                            rightSideSportbook = rightSideSportbook,
                            rightSideExchange = rightSideExchange,
                            totalProfitSportbook = totalProfitSportbook,
                            totalProfitExchange = totalProfitExchange,
                            totalProfit = totalProfit,
                            profitText = profitText,
                            profitColor = profitColor
                        )
                    })

                    Text("Dinero Real", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(horizontal = 10.dp))

                }

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 5.dp)) {
                    MultiSelectorOption(freeBetSelected, action = {
                        realMoneySelected.value = false
                        freeBetSelected.value = true
                        calculate(
                            freeBetMode = freeBetSelected.value,
                            backStake = backStake.value,
                            backOdds = backOdds.value,
                            backCommission = backCommission.value,
                            layOdds = layOdds.value,
                            layCommission = layComission.value,
                            moneyToBet = moneyToBet,
                            liability = liability,
                            leftSideSportbook = leftSideSportbook,
                            leftSideExchange = leftSideExchange,
                            rightSideSportbook = rightSideSportbook,
                            rightSideExchange = rightSideExchange,
                            totalProfitSportbook = totalProfitSportbook,
                            totalProfitExchange = totalProfitExchange,
                            totalProfit = totalProfit,
                            profitText = profitText,
                            profitColor = profitColor
                        )
                    })

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

                        CodexLargeTextField(backStake, KeyboardType.Number) {
                            calculate(
                                freeBetMode = freeBetSelected.value,
                                backStake = backStake.value,
                                backOdds = backOdds.value,
                                backCommission = backCommission.value,
                                layOdds = layOdds.value,
                                layCommission = layComission.value,
                                moneyToBet = moneyToBet,
                                liability = liability,
                                leftSideSportbook = leftSideSportbook,
                                leftSideExchange = leftSideExchange,
                                rightSideSportbook = rightSideSportbook,
                                rightSideExchange = rightSideExchange,
                                totalProfitSportbook = totalProfitSportbook,
                                totalProfitExchange = totalProfitExchange,
                                totalProfit = totalProfit,
                                profitText = profitText,
                                profitColor = profitColor
                            )
                        }

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

                            GenericCodexTextField(backOdds, KeyboardType.Number, {
                                calculate(
                                    freeBetMode = freeBetSelected.value,
                                    backStake = backStake.value,
                                    backOdds = backOdds.value,
                                    backCommission = backCommission.value,
                                    layOdds = layOdds.value,
                                    layCommission = layComission.value,
                                    moneyToBet = moneyToBet,
                                    liability = liability,
                                    leftSideSportbook = leftSideSportbook,
                                    leftSideExchange = leftSideExchange,
                                    rightSideSportbook = rightSideSportbook,
                                    rightSideExchange = rightSideExchange,
                                    totalProfitSportbook = totalProfitSportbook,
                                    totalProfitExchange = totalProfitExchange,
                                    totalProfit = totalProfit,
                                    profitText = profitText,
                                    profitColor = profitColor
                                )
                            })


                            GenericCodexTextField(backCommission, KeyboardType.Number, {
                                calculate(
                                    freeBetMode = freeBetSelected.value,
                                    backStake = backStake.value,
                                    backOdds = backOdds.value,
                                    backCommission = backCommission.value,
                                    layOdds = layOdds.value,
                                    layCommission = layComission.value,
                                    moneyToBet = moneyToBet,
                                    liability = liability,
                                    leftSideSportbook = leftSideSportbook,
                                    leftSideExchange = leftSideExchange,
                                    rightSideSportbook = rightSideSportbook,
                                    rightSideExchange = rightSideExchange,
                                    totalProfitSportbook = totalProfitSportbook,
                                    totalProfitExchange = totalProfitExchange,
                                    totalProfit = totalProfit,
                                    profitText = profitText,
                                    profitColor = profitColor
                                )
                            })
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

                            GenericCodexTextField(layOdds, KeyboardType.Number, {
                                calculate(
                                    freeBetMode = freeBetSelected.value,
                                    backStake = backStake.value,
                                    backOdds = backOdds.value,
                                    backCommission = backCommission.value,
                                    layOdds = layOdds.value,
                                    layCommission = layComission.value,
                                    moneyToBet = moneyToBet,
                                    liability = liability,
                                    leftSideSportbook = leftSideSportbook,
                                    leftSideExchange = leftSideExchange,
                                    rightSideSportbook = rightSideSportbook,
                                    rightSideExchange = rightSideExchange,
                                    totalProfitSportbook = totalProfitSportbook,
                                    totalProfitExchange = totalProfitExchange,
                                    totalProfit = totalProfit,
                                    profitText = profitText,
                                    profitColor = profitColor
                                )
                            })


                            GenericCodexTextField(layComission, KeyboardType.Number, {
                                calculate(
                                    freeBetMode = freeBetSelected.value,
                                    backStake = backStake.value,
                                    backOdds = backOdds.value,
                                    backCommission = backCommission.value,
                                    layOdds = layOdds.value,
                                    layCommission = layComission.value,
                                    moneyToBet = moneyToBet,
                                    liability = liability,
                                    leftSideSportbook = leftSideSportbook,
                                    leftSideExchange = leftSideExchange,
                                    rightSideSportbook = rightSideSportbook,
                                    rightSideExchange = rightSideExchange,
                                    totalProfitSportbook = totalProfitSportbook,
                                    totalProfitExchange = totalProfitExchange,
                                    totalProfit = totalProfit,
                                    profitText = profitText,
                                    profitColor = profitColor
                                )
                            })
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
                            Text("$" + String.format("%.2f", moneyToBet.value), color = Color.White,  fontSize = 20.sp)

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
                            Text("$" + String.format("%.2f", liability.value), color = Color.White,  fontSize = 20.sp)

                            //TODO: ADD COPY TO CLIPBOARD ICON
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
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
                    Text("$" + String.format("%.2f", leftSideSportbook.value), color = Color.White,  fontSize = 20.sp)

                    Text("$" + String.format("%.2f", rightSideSportbook.value), color = Color.White,  fontSize = 20.sp)

                    Text("$" + String.format("%.2f", totalProfitSportbook.value), color = Color.White,  fontSize = 20.sp)
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
                    Text("$" + String.format("%.2f", leftSideExchange.value), color = Color.White,  fontSize = 20.sp)

                    Text("$" + String.format("%.2f", rightSideExchange.value), color = Color.White,  fontSize = 20.sp)

                    Text("$" + String.format("%.2f", totalProfitExchange.value), color = Color.White,  fontSize = 20.sp)
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

                        Text("${profitText.value}", color = Color.White,  fontSize = 28.sp, modifier = Modifier.padding(end = 15.dp))

                        Text("$" + String.format("%.2f", totalProfit.value), color = profitColor.value,  fontSize = 28.sp)

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

                }
            }
        }
    }
}

@Composable
fun CodexLargeTextField(text: MutableState<String>, keyboardType: KeyboardType, onChangeAction: () -> Unit) {
    TextField(
        value = text.value,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(top = 15.dp),
        onValueChange = {
            text.value = it
            onChangeAction()
        })
}

@Composable
fun GenericCodexTextField(text: MutableState<String>, keyboardType: KeyboardType, onChangeAction: () -> Unit) {
    TextField(
        value = text.value,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        modifier = Modifier
            .height(65.dp)
            .width(130.dp)
            .padding(top = 15.dp),
        onValueChange = {
            text.value = it
            onChangeAction()
        })
}

@Composable
fun MultiSelectorOption(selected: MutableState<Boolean>, action: () -> Unit) {

    RadioButton(
        selected = selected.value,
        onClick = {
            action()
        },
        colors = RadioButtonDefaults.colors(
            selectedColor = CodexGolden,
            unselectedColor = Color.White
        )
    )
}

fun calculate(
    freeBetMode: Boolean,
    backStake: String,
    backOdds: String,
    backCommission: String,
    layOdds: String,
    layCommission: String,
    moneyToBet: MutableState<Double>,
    liability: MutableState<Double>,
    leftSideSportbook: MutableState<Double>,
    leftSideExchange: MutableState<Double>,
    rightSideSportbook: MutableState<Double>,
    rightSideExchange: MutableState<Double>,
    totalProfitSportbook: MutableState<Double>,
    totalProfitExchange: MutableState<Double>,
    totalProfit: MutableState<Double>,
    profitText: MutableState<String>,
    profitColor: MutableState<Color>
) {


    if (backStake.isEmpty()) {
        Log.i("EMPTY VALUE", "Back stake.")
        return
    }

    var backStakeDouble = backStake.toDoubleOrNull() ?: return

    if (backOdds.isEmpty()) {
        Log.i("EMPTY VALUE", "Back odds.")
        return
    }

    val backOddsDouble = backOdds.toDoubleOrNull() ?: return

    if (backCommission.isEmpty()) {
        Log.i("EMPTY VALUE", "Back commission.")
        return
    }

    val backCommission = backCommission.toDoubleOrNull() ?: return

    if (layOdds.isEmpty()) {
        Log.i("EMPTY VALUE", "Lay odds.")
        return
    }

    val layOddsDouble = layOdds.toDoubleOrNull() ?: return

    if (layCommission.isEmpty()) {
        Log.i("EMPTY VALUE", "Lay commission.")
        return
    }

    val layCommissionDouble = layCommission.toDoubleOrNull() ?: return

    if (freeBetMode) {

        moneyToBet.value = getMoneyToBetForFreebet(
            backStakeDouble,
            backOddsDouble,
            backCommission,
            layOddsDouble,
            layCommissionDouble
        )

        liability.value = getLiability(moneyToBet.value, layOddsDouble)

        leftSideSportbook.value = getLeftSideSportbookForFreebet(backStakeDouble, backOddsDouble, backCommission)

        leftSideExchange.value = getLeftSideExchangeForFreebet()

        rightSideSportbook.value = getRightSideSportbookForFreebet(liability.value)

        rightSideExchange.value = getRightSideExchangeForFreebet(moneyToBet.value, layCommissionDouble)

        totalProfitSportbook.value = getTotalProfitSportbook(
            leftSideSportbook.value,
            rightSideSportbook.value
        )

        totalProfitExchange.value = getTotalProfitExchange(
            rightSideExchange.value,
            leftSideExchange.value
        )

        totalProfit.value = getTotalProfit(totalProfitSportbook.value, totalProfitExchange.value)

        profitText.value = getProfitText(totalProfit.value)

        profitColor.value = getProfitColor(totalProfit.value)

    } else {
        moneyToBet.value = getMoneyToBet(
            backStake = backStakeDouble,
            backOdds = backOddsDouble,
            backCommission = backCommission,
            layOdds =  layOddsDouble,
            layCommission = layCommissionDouble
        )

        liability.value = getLiability(moneyToBet.value, layOddsDouble)

        leftSideSportbook.value = getLeftSideSportbook(
            backStakeDouble,
            backOddsDouble,
            backCommission
        )

        leftSideExchange.value = getLeftSideExchange(backStakeDouble)

        rightSideSportbook.value = getRightSideSportbook(liability.value)

        rightSideExchange.value = getRightSideExchange(moneyToBet.value, layCommissionDouble)

        totalProfitSportbook.value = getTotalProfitSportbook(
            leftSideSportbook.value,
            rightSideSportbook.value
        )

        totalProfitExchange.value = getTotalProfitExchange(
            rightSideExchange.value,
            leftSideExchange.value
        )

        totalProfit.value = getTotalProfit(totalProfitSportbook.value, totalProfitExchange.value)

        profitText.value = getProfitText(totalProfit.value)

        profitColor.value = getProfitColor(totalProfit.value)
    }
}

//REAL MONEY
fun getMoneyToBet(
    backStake: Double,
    backOdds: Double,
    backCommission: Double,
    layOdds: Double,
    layCommission: Double
): Double {

    val result = getMatchedBettingOperation(
        backStake = backStake,
        backOdds = backOdds,
        layOdds = layOdds,
        layCommission = layCommission
    )

    return result-(result*backCommission/100)
}

fun getLiability(moneyToBet: Double, layOdds: Double):Double {
    return (moneyToBet*layOdds)-moneyToBet
}

fun getMatchedBettingOperation(
    backStake: Double,
    backOdds: Double,
    layOdds: Double,
    layCommission: Double
):Double {
    return (backOdds*backStake-(0*((backOdds-1)*backStake)/100)-0)/(layOdds-layCommission/100)
}

fun getLeftSideSportbook(
    backStake: Double,
    backOdds: Double,
    backCommission: Double
):Double {
    val result = (backStake*backOdds)-backStake

    return result-(result*backCommission/100)
}

fun getLeftSideExchange(backStake: Double): Double {
    return -backStake
}

fun getRightSideSportbook(liability: Double): Double {
    return -liability
}

fun getRightSideExchange(moneyToBet: Double, layCommission: Double): Double {
    return moneyToBet-(moneyToBet*layCommission/100)
}

fun getTotalProfitSportbook(leftSideSportbook: Double, rightSideSportbook: Double): Double {
    return leftSideSportbook + rightSideSportbook
}

fun getTotalProfitExchange(rightSideExchange: Double, leftSideExchange: Double): Double {
    return rightSideExchange + leftSideExchange
}

//FREEBET
fun getMoneyToBetForFreebet(
    backStake: Double,
    backOdds: Double,
    backCommission: Double,
    layOdds: Double,
    layCommission: Double
): Double {
    val result = (backOdds*backStake-(0*((backOdds-1)*backStake)/100)-backStake)/(layOdds-layCommission/100)

    return result-(result*backCommission/100)
}

fun getLeftSideSportbookForFreebet(backStake: Double, backOdds: Double, backCommission: Double): Double {
    val benefit = (backStake * backOdds)-backStake

    return benefit-(benefit*backCommission/100)
}

fun getLeftSideExchangeForFreebet(): Double {
    return 0.0
}

fun getRightSideSportbookForFreebet(liability: Double): Double {
    return -liability
}

fun getRightSideExchangeForFreebet(moneyToBet: Double, layCommission: Double): Double {
    return moneyToBet-(moneyToBet*layCommission/100)
}

//PROFIT
fun getTotalProfit(totalProfitSportbook: Double, totalProfitExchange: Double): Double {
    return if (totalProfitSportbook < totalProfitExchange) {
        totalProfitSportbook
    } else {
        totalProfitExchange
    }
}

fun getProfitText(profit: Double): String {
    return if (profit >= 0.0) {
        "Ganarás"
    } else {
        "Perderás"
    }
}

fun getProfitColor(profit: Double): Color {
    return if (profit >= 0.0) {
        Color.Green
    } else {
        Color.Red
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorViewPreview() {

    CodexBettingTheme {
        CalculatorView()
    }
}
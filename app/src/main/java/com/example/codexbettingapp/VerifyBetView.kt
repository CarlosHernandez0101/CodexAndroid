package com.example.codexbettingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
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

@Composable
fun VerifyBetView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(CodexBlack)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(CodexBlack),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            
            CodexNavigationBar()

            VerifyBetRequirement(text = "El resultado a favor y en contra es el mismo en ambas casas de apuestas ", isDone = false)

            VerifyBetRequirement(text = "El resultado a favor y en contra es el mismo en ambas casas de apuestas", isDone = false)

            VerifyBetRequirement(text = "El resultado a favor y en contra es el mismo en ambas casas de apuestas", isDone = false)

        }
    }
}

@Composable
fun VerifyBetRequirement(text: String, isDone: Boolean) {
    val checkedState = remember { mutableStateOf(true) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        Text(text, color = Color.White,  fontSize = 20.sp)

        Checkbox(
            modifier = Modifier.padding(end = 20.dp),
            checked = checkedState.value,
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.Green,
                uncheckedColor = Color.White,
                checkedColor = CodexBlack,
            ),
            onCheckedChange = { checkedState.value = it }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun VerifyBetViewPreview() {
    CodexBettingTheme {
        VerifyBetView()
    }
}
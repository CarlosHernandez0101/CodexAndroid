package com.example.codexbettingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack

@Composable
fun ToolsView() {
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
        ) {
            CodexNavigationBar()

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    "Herramientas",
                    color = Color.White,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .padding(bottom = 20.dp)
                )

                InformativeCardView(
                    title = "Calculadora",
                    description = "Realiza los procedimientos matématicos con ayuda de la calculadora",
                ) {

                }

                InformativeCardView(
                    title = "Verificador de apuesta",
                    description = "Verifica que tu apuesta no tenga nungún error"
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToolsViewPreview() {
    CodexBettingTheme {
        ToolsView()
    }
}
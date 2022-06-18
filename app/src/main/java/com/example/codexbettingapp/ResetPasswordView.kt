package com.example.codexbettingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
fun ResetPasswordView() {
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

            Column(horizontalAlignment = Alignment.Start) {
                Text("Restablecer contraseña", color = Color.White,  fontSize = 28.sp, modifier = Modifier.padding(horizontal = 15.dp))

                Text(
                    "Escribe la dirección de correo eléctronico relacionada con tu cuenta y nosotros enviaremos un enlace para que restablezcas tu contraseña",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .padding(horizontal = 15.dp)
                )
            }

            CodexTextField("Resetear")
            
            ContinueButton(text = "Enviar", onClick = {

            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordViewPreview() {
    CodexBettingTheme {
        ResetPasswordView()
    }
}


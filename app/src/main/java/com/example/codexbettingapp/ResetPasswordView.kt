package com.example.codexbettingapp

import android.text.TextUtils
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

@Composable
fun ResetPasswordView() {

    var emailText = remember { mutableStateOf("") }
    var emailError = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(CodexBlack)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(CodexBlack)
                .padding(horizontal = 30.dp),
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

            CodexLargeTextField(text = emailText, keyboardType = KeyboardType.Text) {
                
            }

            if (!emailError.value.isEmpty()) {
                TextError(text = emailError.value)
            }
            
            ContinueButton(text = "Enviar", onClick = {
                if (isValidEmail(emailText.value)) {
                    emailError.value = ""
                } else {
                    emailError.value = "Ingrese un correo válido"
                }
            })
        }
    }
}

@Composable
fun TextError(text: String) {
    Text(text = text, color = Color.Red, modifier = Modifier.padding(top = 7.dp))
}

fun isValidEmail(email: String): Boolean {
    return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordViewPreview() {
    CodexBettingTheme {
        ResetPasswordView()
    }
}


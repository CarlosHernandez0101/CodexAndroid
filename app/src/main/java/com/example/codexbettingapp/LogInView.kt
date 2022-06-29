package com.example.codexbettingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGolden

@Composable
fun LogInView() {

    var emailText = remember { mutableStateOf("") }
    var passwordText = remember { mutableStateOf("") }
    var emailError = remember { mutableStateOf("") }
    var passwordError = remember { mutableStateOf("") }

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
            CodexLogo()

            Text("Iniciar sesión", color = Color.White,  fontSize = 28.sp)

            Text("Correo eléctronico", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 40.dp))

            CodexLargeTextField(text = emailText, keyboardType = KeyboardType.Text) {

            }

            if (!emailError.value.isEmpty()) {
                TextError(text = emailError.value)
            }

            Text("Contraseña", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 15.dp))

            Column(horizontalAlignment = Alignment.End) {

                CodexLargeTextField(text = passwordText, keyboardType = KeyboardType.Text) {

                }

                UnderlinedButton("¿Olvidaste tu contraseña?", color = Color.White)

                if (!passwordError.value.isEmpty()) {
                    TextError(text = passwordError.value)
                }
            }

            ContinueButton("Iniciar sesión", onClick = {

                if (!isValidEmail(emailText.value)) {
                    emailError.value = "Ingrese un correo válido"
                }

                if (!isValidPassword(passwordText.value)) {
                    passwordError.value = "Debe contener al menos 6 caracteres"
                }

                if (isValidEmail(emailText.value) && isValidPassword(passwordText.value)) {
                    emailError.value = ""
                    passwordError.value = ""
                }

            })

            Text("O ingresa con", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 15.dp))

            GoogleButton("Iniciar sesión con Google")

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .padding(bottom = 35.dp)
            ){
                Text("¿Aún no tienes cuenta?", color = Color.White,  fontSize = 20.sp)

                UnderlinedButton("Registrate", color = Color.White)
            }
        }
    }
}

@Composable
fun CodexTextField(value: String) {
    TextField(
        value = value,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        modifier = Modifier
            .background(Color.Black)
            .height(70.dp)
            .padding(top = 15.dp),
        onValueChange = {

        })
}

@Composable
fun UnderlinedButton(text: String, color: Color) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = CodexBlack),
        onClick = {

        }) {
        Text(
            text,
            color = color,
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
    }
}

@Composable
fun ContinueButton(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(60.dp)
            .width(200.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = CodexGolden),
        onClick = {
            onClick()
        }) {
        Text(text, color = Color.White, fontSize = 20.sp)
    }
}

@Composable
fun GoogleButton(text: String) {
    Button(
        modifier = Modifier
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(65.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        onClick = {

        }) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text, color = Color.Black, fontSize = 20.sp)

            GoogleIcon()
        }
    }
}

@Composable
fun GoogleIcon() {
    Image(
        painter = painterResource(R.drawable.google_icon),
        contentDescription = "Google Icon",
        modifier = Modifier.size(50.dp)
    )
}

@Composable
fun CodexPasswordLargeTextField(text: MutableState<String>, keyboardType: KeyboardType, onChangeAction: () -> Unit) {
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
        },
        trailingIcon = {
            IconButton(onClick = { }) {

            }
        }
    )
}

fun isValidPassword(password: String): Boolean {
    return password.length >= 6
}

@Preview(showBackground = true)
@Composable
fun LogInViewPreview() {
    CodexBettingTheme {
        LogInView()
    }
}
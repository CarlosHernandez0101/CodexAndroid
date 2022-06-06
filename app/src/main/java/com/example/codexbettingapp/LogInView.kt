package com.example.codexbettingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGolden

@Composable
fun LogInView() {
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
            CodexLogo()

            Text("Iniciar sesión", color = Color.White,  fontSize = 28.sp)

            Text("Correo eléctronico", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 40.dp))

            CodexTextField()

            Text("Contraseña", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 15.dp))

            Column(horizontalAlignment = Alignment.End) {

                CodexTextField()

                UnderlinedButton("¿Olvidaste tu contraseña?", color = Color.White)
            }

            ContinueButton("Iniciar sesión")

            Text("O ingresa con", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 15.dp))

            GoogleButton("Iniciar sesión con Google")

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 15.dp)){
                Text("¿Aún no tienes cuenta?", color = Color.White,  fontSize = 20.sp)

                UnderlinedButton("Registrate", color = Color.White)
            }
        }
    }
}

@Composable
fun CodexTextField() {
    TextField(
        value = "",
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        modifier = Modifier
            .background(Color.Black)
            .height(40.dp)
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
fun ContinueButton(text: String) {
    Button(
        modifier = Modifier
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(60.dp)
            .width(200.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = CodexGolden),
        onClick = {

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

@Preview(showBackground = true)
@Composable
fun LogInViewPreview() {
    CodexBettingTheme {
        LogInView()
    }
}
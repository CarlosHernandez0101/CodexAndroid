package com.example.codexbettingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGolden

@Composable
fun RegisterView() {
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

            Text("Crear cuenta", color = Color.White,  fontSize = 28.sp)

            Column(horizontalAlignment = Alignment.Start) {
                Text("Correo eléctronico", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp))

                CodexTextField()

                Text("Contraseña", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp))

                CodexTextField()

                Text("Confirmar contraseña", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp))

                CodexTextField()
            }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)) {
                Text("Aceptar", color = Color.White,  fontSize = 20.sp)

                UnderlinedButton(text = "Política de privacidad y T&C", color = CodexGolden)
            }
            
            ContinueButton(text = "Crear cuenta")

            Text("O resgitrate con:", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(20.dp))
            
            GoogleButton(text = "Registrarse con Google")

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)) {
                Text("¿Ya tienes cuenta?", color = Color.White,  fontSize = 20.sp)

                UnderlinedButton(text = "Iniciar sesión", color = Color.White)
            }
        }
    }
}

@Composable
fun CodexNavigationBar() {
    TopAppBar(
        backgroundColor = CodexBlack,
        title = {   Text(
            text = "",
            textAlign = TextAlign.Center,

        )},
        navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Flecha de regreso", tint = Color.White)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RegisterViewPreview() {
    CodexBettingTheme {
        RegisterView()
    }
}


package com.example.codexbettingapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGolden

@Composable
fun RegisterView() {

    var emailText = remember { mutableStateOf("") }
    var passwordText = remember { mutableStateOf("") }
    var passwordConfirmationText = remember { mutableStateOf("") }
    var hasAcceptedTerms = remember { mutableStateOf(false) }
    var emailError = remember { mutableStateOf("") }
    var passwordError = remember { mutableStateOf("") }
    var passwordConfirmationError = remember { mutableStateOf("") }
    var termsError = remember { mutableStateOf("") }
    
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

            Text("Crear cuenta", color = Color.White,  fontSize = 28.sp)

            Column(horizontalAlignment = Alignment.Start) {
                Text("Correo eléctronico", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp))

                CodexLargeTextField(text = emailText, keyboardType = KeyboardType.Text) {
                    
                }

                Text("Contraseña", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp))

                CodexLargeTextField(text = passwordText, keyboardType = KeyboardType.Text) {
                    
                }

                Text("Confirmar contraseña", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp))

                CodexLargeTextField(text = passwordConfirmationText, keyboardType = KeyboardType.Text) {
                    
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 20.dp)
            ) {

                if (hasAcceptedTerms.value) {

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

                Text("Aceptar", color = Color.White,  fontSize = 20.sp)

                UnderlinedButton(text = "Política de privacidad y T&C", color = CodexGolden)
            }
            
            ContinueButton(text = "Crear cuenta", onClick = {

            })

            Text("O resgitrate con:", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(20.dp))
            
            GoogleButton(text = "Registrarse con Google")

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .padding(top = 15.dp)
                .padding(bottom = 35.dp)) {
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


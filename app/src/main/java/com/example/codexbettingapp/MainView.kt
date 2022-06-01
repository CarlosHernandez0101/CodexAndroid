package com.example.codexbettingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import com.example.codexbettingapp.ui.theme.CodexGolden
import com.example.codexbettingapp.ui.theme.CodexGray

@Composable
fun MainView() {
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

            MainTopAppBar()

            CodexLogo()

            InformativeCardView(title = "Lecciones", description = "Aquí encontrarás todo el contenido del curso") {
                
            }

            InformativeCardView(title = "Herramientas", description = "Encuentra las herramientas necesarias para aplicar la estrategia del curso") {

            }

            InformativeCardView(title = "Solicitar un partido", description = "Encuentra las herramientas necesarias para aplicar la estrategia del curso") {

            }
        }
    }
}

@Composable
fun CodexLogo() {
    Image(painter = painterResource(
        R.drawable.codex_betting_logo),
        contentDescription = "Codex Betting Logo",
        modifier = Modifier
            .width(250.dp)
            .height(250.dp)
    )
}

@Composable
fun InformativeCardView(title: String, description: String, action: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = CodexBlack),
        onClick = {

    }) {
        Column(
            Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(20.dp))
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Card {
                Column(
                    Modifier
                        .background(CodexGray)
                        .padding(32.dp)
                ) {
                    Text(title, color = Color.White, fontWeight = FontWeight.W700, fontSize = 25.sp)

                    Divider(modifier = Modifier.padding(top = 20.dp), color = CodexGolden)

                    Text(description, modifier = Modifier.padding(top = 20.dp), color = Color.White, fontSize = 13.sp)
                }
            }
        }
    }
}

@Composable
fun MainTopAppBar() {
    TopAppBar(
        backgroundColor = CodexBlack,
        title = { Text(text = "") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Ver más", tint = Color.Black, modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(30.dp)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    CodexBettingTheme {
        MainView()
    }
}
package com.example.codexbettingapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.MainView

@Composable
fun MenuView() {
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
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(15.dp)) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Menú", color = Color.White,  fontSize = 35.sp)

                    IconButton(
                        onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "Cerrar menús", tint = Color.White, modifier = Modifier
                            .size(28.dp)
                        )
                    }
                }

                Text("Usuario", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 40.dp))

                Text("chedezv@gmail.como", color = Color.White,  fontSize = 20.sp, modifier = Modifier.padding(top = 40.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                ) {
                    Text("Miembro premium", color = Color.White,  fontSize = 20.sp)

                    Icon(imageVector = Icons.Filled.Done, contentDescription = "Cerrar menús", tint = CodexGolden, modifier = Modifier
                        .size(28.dp)
                    )
                }

                Divider(modifier = Modifier.padding(top = 100.dp), color = Color.Gray)
                
                MenuAction(text = "Byscar ayuda")

                Divider(modifier = Modifier.padding(top = 20.dp), color = Color.Gray)

                MenuAction(text = "Política de privacidad ")

                Divider(modifier = Modifier.padding(top = 20.dp), color = Color.Gray)

                MenuAction(text = "Cerrar sesión")

                Divider(modifier = Modifier.padding(top = 20.dp), color = Color.Gray)
            }
        }

    }
}

@Composable
fun MenuAction(text: String) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = CodexBlack),
        onClick = {
            
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(CodexBlack)
        ) {
            Text(text, color = Color.White, fontSize = 20.sp, modifier = Modifier.background(CodexBlack))

            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "Menu action", tint = Color.White, modifier = Modifier
                .size(28.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuViewPreview() {
    CodexBettingTheme {
        MenuView()
    }
}
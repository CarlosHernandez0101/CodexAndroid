package com.example.codexbettingapp

import android.widget.HorizontalScrollView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack
import org.intellij.lang.annotations.JdkConstants

@Composable
fun LessonsView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(CodexBlack)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(CodexBlack),
            horizontalAlignment = Alignment.Start,
        ) {
            CodexNavigationBar()

            Text(
                "Lecciones",
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(bottom = 20.dp)
            )

            //LessonRow(title = "Bienvenida",  description = "Bienvenida alcurso de Codex Betting Bienvenida al curso", duration = "00:43")

            //LessonRow(title = "Bienvenida",  description = "Bienvenida alcurso de Codex Betting Bienvenida al curso", duration = "01:43")

            //LessonRow(title = "Bienvenida",  description = "Bienvenida alcurso de Codex Betting Bienvenida al curso", duration = "20:43")

            NetworkErrorView()
        }
    }
}

@Composable
fun LessonRow(title: String, description: String, duration: String) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = CodexBlack),
        onClick = {

    }) {
        Column() {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()) {
                Text(text = title, maxLines = 2, color = Color.White, fontSize = 15.sp)

                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "Play Icon", tint = Color.Black, modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(15.dp)
                )
            }

            Text(text = description, maxLines = 3, overflow = TextOverflow.Ellipsis, color = Color.Gray, fontSize = 15.sp, modifier = Modifier.padding(top = 8.dp))

            Text(text = duration, maxLines = 2, color = Color.White, fontSize = 15.sp)

            Divider(color = Color.Gray, modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
fun NetworkErrorView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Icon(imageVector = Icons.Filled.Warning, contentDescription = "Warning icon", tint = Color.White, modifier = Modifier
            .clip(CircleShape)
            .background(Color.Black)
            .size(35.dp)
        )

        Text(text = "Ocurrió un error inesperado", maxLines = 2, color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(top = 15.dp))

        Text(text = "Verifique su conexión a internet o intente más tarde", maxLines = 2, color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(top = 15.dp))
        
        ContinueButton(text = "Reintentar") {
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LessonsViewPreview() {
    CodexBettingTheme {
        LessonsView()
    }
}
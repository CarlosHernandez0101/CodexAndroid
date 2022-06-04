package com.example.codexbettingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
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

            LessonRow(title = "Bienvenida",  description = "Bienvenida alcurso de Codex Betting Bienvenida al curso")

            LessonRow(title = "Bienvenida",  description = "Bienvenida alcurso de Codex Betting Bienvenida al curso")

            LessonRow(title = "Bienvenida",  description = "Bienvenida alcurso de Codex Betting Bienvenida al curso")
        }
    }
}

@Composable
fun LessonRow(title: String, description: String) {
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

            Divider(color = Color.Gray, modifier = Modifier.padding(top = 16.dp))
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
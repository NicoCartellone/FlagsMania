package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.theme.AppFont

@Composable
fun ScoreCard(
    counter: Int?,
    correctAnswers: Int?,
) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(20.dp),
    ) {
        // Círculo flotante
        Column(modifier = Modifier.zIndex(1f)) {
            Avatar()
        }

        // Tarjeta

        ElevatedCard(
            elevation =
                CardDefaults.cardElevation(
                    defaultElevation = 6.dp,
                ),
            colors =
                CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF),
                ),
            shape = RoundedCornerShape(16.dp),
            modifier =
                Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.TopCenter),
        ) {
            CardContent(counter, correctAnswers)
        }
    }
}

@Composable
fun CardContent(
    counter: Int?,
    correctAnswers: Int?,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(30.dp, 60.dp, 30.dp, 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = "Banderas correctas",
                    style =
                        TextStyle(
                            fontSize = 16.sp,
                            fontFamily = AppFont.Quicksand,
                            fontWeight = FontWeight.Bold,
                        ),
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Banderas incorrectas",
                    style =
                        TextStyle(
                            fontSize = 16.sp,
                            fontFamily = AppFont.Quicksand,
                            fontWeight = FontWeight.Bold,
                        ),
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Puntos totales",
                    style =
                        TextStyle(
                            fontSize = 16.sp,
                            fontFamily = AppFont.Quicksand,
                            fontWeight = FontWeight.Bold,
                        ),
                )
            }
            Column {
                Text(
                    text = "${correctAnswers ?: 0}/10",
                    style =
                        TextStyle(
                            fontSize = 16.sp,
                            fontFamily = AppFont.Quicksand,
                            fontWeight = FontWeight.Bold,
                        ),
                )
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "${10 - correctAnswers!!}/10",
                    style =
                        TextStyle(
                            fontSize = 16.sp,
                            fontFamily = AppFont.Quicksand,
                            fontWeight = FontWeight.Bold,
                        ),
                )

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "${counter ?: 0}pts",
                    style =
                        TextStyle(
                            fontSize = 16.sp,
                            fontFamily = AppFont.Quicksand,
                            fontWeight = FontWeight.Bold,
                        ),
                )
            }
        }
    }
}

@Composable
fun Avatar() {
    Box(
        modifier =
            Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(
                    brush =
                        Brush
                            .verticalGradient(
                                listOf(
                                    Color(0xFFE4A82B),
                                    Color(0xFFC4007A),
                                ),
                            ),
                ).zIndex(1f),
    ) {
        Box(
            modifier =
                Modifier
                    .size(100.dp)
                    .clip(CircleShape),
        ) {
            Box(
                modifier =
                    Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFFFFFF))
                        .align(Alignment.Center),
            )
            Image(
                painter = painterResource(id = R.drawable.avatar_1),
                contentDescription = "Avatar",
                modifier =
                    Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .align(Alignment.Center),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFE0E0E0)
@Composable
fun ScoreCardPreview() {
    ScoreCard(100, 10)
}

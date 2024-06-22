package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.theme.AppFont

@Composable
fun MenuOptionButton(
    onClick: () -> Unit,
    title: String,
    description: String,
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 8.dp),
        onClick = onClick,
    ) {
        Box(
            modifier =
                Modifier.background(
                    brush =
                        Brush.horizontalGradient(
                            colors =
                                listOf(
                                    colorResource(R.color.orange),
                                    colorResource(R.color.magenta),
                                ),
                        ),
                ),
        ) {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)) {
                Text(
                    text = title,
                    fontFamily = AppFont.Quicksand,
                    fontSize = 18.sp,
                    fontWeight =
                        FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    fontFamily = AppFont.Quicksand,
                    fontWeight =
                        FontWeight
                            .SemiBold,
                    color =
                        Color.White,
                )
            }
        }
    }
}

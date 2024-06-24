package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ar.edu.unlam.mobile.scaffolding.ui.theme.AppFont
import kotlinx.coroutines.delay

@Composable
fun CardCountryGame(
    pts: Int = 0,
    actualCard: Int = 0,
    counter: Int = 10,
    onDecrementCounter: () -> Unit,
    correctCountryName: String,
    modifier: Modifier,
) {
    Box {
        CounterFlagHolder(modifier, counter, onDecrementCounter)
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFECECEC)),
            modifier =
                modifier
                    .padding(horizontal = 36.dp, vertical = 10.dp)
                    .fillMaxWidth(),
        ) {
            Row(
                modifier =
                    modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "$actualCard/10",
                    color = Color(0xFFC4007A),
                    fontFamily = AppFont.Quicksand,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
            }
            Column(
                modifier =
                    modifier
                        .padding(16.dp)
                        .wrapContentHeight().fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = correctCountryName,
                    color = Color(0xFFC4007A),
                    fontFamily = AppFont.Quicksand,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
                Spacer(modifier = modifier.height(16.dp))

                // Points text
                Text(
                    text = "$pts pts.",
                    color = Color(0xFFC4007A),
                    fontSize = 16.sp,
                    fontFamily = AppFont.Quicksand,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.align(Alignment.CenterHorizontally),
                )
            }
        }
    }
}

@Composable
fun CounterFlagHolder(
    modifier: Modifier,
    counter: Int,
    onDecrementCounter: () -> Unit,
) {
    LaunchedEffect(counter) {
        while (counter >= 0) {
            delay(1000)
            onDecrementCounter()
        }
    }

    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .offset(y = (-30).dp)
                .zIndex(1f),
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier =
                Modifier
                    .height(85.dp)
                    .width(85.dp)
                    .padding(12.dp)
                    .background(Color.White, CircleShape)
                    .border(4.dp, Color(0xFFC4007A), CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "$counter",
                color = Color(0xFFC4007A),
                fontSize = 28.sp,
                fontFamily = AppFont.Quicksand,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

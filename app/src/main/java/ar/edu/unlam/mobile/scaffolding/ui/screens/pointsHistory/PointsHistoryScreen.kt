package ar.edu.unlam.mobile.scaffolding.ui.screens.pointsHistory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.domain.models.GameResult
import ar.edu.unlam.mobile.scaffolding.ui.navigation.NavHostRouterPaths
import ar.edu.unlam.mobile.scaffolding.ui.theme.AppFont

@Composable
fun PointsHistoryScreen(
    controller: NavController,
    viewModel: PointsHistoryViewModel = hiltViewModel(),
) {
    val uiState: PointsHistoryUIState by viewModel.uiState.collectAsState()

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        IconButton(onClick = { controller.navigate(NavHostRouterPaths.Home.route) }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back Honme")
        }
        Text(
            text = "Historial de puntos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(16.dp))
        when (val pointHistoryState = uiState.pointsHistoryState) {
            is PointsHistoryListUIState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(color = Color(0xFFC4007A))
                }
            }

            is PointsHistoryListUIState.Success -> {
                PointsHistoryList(pointHistoryState.historyPointsList)
            }

            is PointsHistoryListUIState.Error -> {
                // Error
            }
        }
    }
}

@Composable
fun PointsHistoryList(pointsHistory: List<GameResult>) {
    LazyColumn {
        items(pointsHistory.size) { pointsHistoryId ->
            PointsItem(
                gameType = pointsHistory[pointsHistoryId].gameType,
                gameDate = pointsHistory[pointsHistoryId].gameDate,
                points = pointsHistory[pointsHistoryId].points.toString(),
            )
        }
    }
}

@Composable
fun PointsItem(
    gameType: String,
    gameDate: String,
    points: String,
) {
    var gameTypeTraduced = ""
    when (gameType) {
        "Classic" -> gameTypeTraduced = "Clásico"
        "Advanced" -> gameTypeTraduced = "Avanzado"
    }
    ElevatedCard(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth().padding(8.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar_1),
                contentDescription = "User Avatar",
                modifier =
                    Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFF2A1FF)),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = "Juego $gameTypeTraduced",
                    fontWeight = FontWeight.Bold,
                    fontFamily = AppFont.Quicksand,
                )
                Text(text = gameDate, color = Color.Black, fontFamily = AppFont.Quicksand)
            }
            Text(
                text = "$points pts",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = AppFont.Quicksand,
            )
        }
    }
}

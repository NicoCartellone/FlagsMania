package ar.edu.unlam.mobile.scaffolding.ui.screens.onlineRanking

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
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
import ar.edu.unlam.mobile.scaffolding.data.models.Ranking
import ar.edu.unlam.mobile.scaffolding.ui.navigation.NavHostRouterPaths
import ar.edu.unlam.mobile.scaffolding.ui.theme.AppFont

@Composable
fun OnlineRankingScreen(
    controller: NavController,
    viewModel: RankingViewModel = hiltViewModel(),
) {
    val uiState: RankingUIState by viewModel.uiState.collectAsState()

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
            text = "Ranking online",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier =
                Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { controller.navigate(NavHostRouterPaths.LocalRanking.route) }) {
                Text(text = "Hisorial offline")
            }
            Button(onClick = { controller.navigate(NavHostRouterPaths.OnlineRanking.route) }) {
                Text(text = "Historial online")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        when (val rankingState = uiState.rankingState) {
            is RankingResponseUIState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(color = Color(0xFFC4007A))
                }
            }
            is RankingResponseUIState.Success -> {
                Ranking(rankingState.ranking)
            }
            is RankingResponseUIState.Error -> {
                // Error
            }
        }
    }
}

@Composable
fun Ranking(ranking: Ranking) {
    LazyColumn {
        items(ranking.players.size) { rankingId ->
            RankingItem(
                points = ranking.players[rankingId].points,
                gameType = ranking.players[rankingId].gameType,
                date = ranking.players[rankingId].date,
                playerName = ranking.players[rankingId].playerName,
            )
        }
    }
}

@Composable
fun RankingItem(
    points: String,
    gameType: String,
    date: String,
    playerName: String,
) {
    Surface(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        shadowElevation = 4.dp,
        tonalElevation = 2.dp,
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
                    text = playerName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    fontFamily = AppFont.Quicksand,
                )
                Text(
                    text = "Mode $gameType",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = AppFont.Quicksand,
                )
                Text(
                    text = date,
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = AppFont.Quicksand,
                )
            }
            Box(
                modifier =
                    Modifier
                        .background(
                            color = Color(0xFFD9D9D9),
                            shape = RoundedCornerShape(16.dp),
                        ).padding(horizontal = 8.dp, vertical = 4.dp),
            ) {
                Text(
                    text = "$points pts",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    fontFamily = AppFont.Quicksand,
                )
            }
        }
    }
}

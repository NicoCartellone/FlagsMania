package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.CustomButton
import ar.edu.unlam.mobile.scaffolding.ui.navigation.NavHostRouterPaths
import ar.edu.unlam.mobile.scaffolding.ui.theme.AppFont

@Composable
fun GameAdvancedRulesScreen(controller: NavHostController) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier =
                Modifier
                    .fillMaxWidth(),
            alignment = Alignment.Center,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            "- MODO AVANZADO -",
            fontSize = 16.sp,
            fontFamily = AppFont.Quicksand,
            fontWeight =
                FontWeight
                    .Bold,
        )
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Spacer(Modifier.height(48.dp))
            Text(
                "Reglas del juego:",
                fontSize = 16.sp,
                fontFamily = AppFont.Quicksand,
                fontWeight =
                    FontWeight
                        .Bold,
            )
            Spacer(Modifier.height(16.dp))
            Text(
                "• Se mostrará el nombre " +
                    "de un país y 4 banderas de todo el mundo, " +
                    "tendrás 10 segundos para seleccionar la " +
                    "bandera correcta," +
                    " ¿Lograrás acertar las 10 preguntas?",
                fontSize = 14.sp,
                fontFamily = AppFont.Quicksand,
                fontWeight =
                    FontWeight
                        .Normal,
            )
            Spacer(Modifier.height(16.dp))
            Text(
                "Obtené la mayor cantidad de puntos y " +
                    "demostrá cuánto sabes de países! ",
                fontSize = 14.sp,
                fontFamily = AppFont.Quicksand,
                fontWeight =
                    FontWeight
                        .Bold,
            )
            Spacer(Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.game_advanced_rules),
                contentDescription = "Logo",
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                alignment = Alignment.Center,
            )
            Spacer(Modifier.height(24.dp))
            CustomButton(text = "Jugar") {
                controller.navigate(
                    NavHostRouterPaths.GameAdvanced.route,
                )
            }
        }
    }
}

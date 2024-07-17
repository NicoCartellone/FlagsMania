package ar.edu.unlam.mobile.scaffolding.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme =
    darkColorScheme(
        primary = Purple80,
        secondary = PurpleGrey80,
        tertiary = Pink80,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Purple40,
        secondary = PurpleGrey40,
        tertiary = Pink40,
    )

@Composable
fun ScaffoldingV2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            when {
                darkTheme -> {
                    val window = (view.context as Activity).window
                    window.statusBarColor = colorScheme.background.toArgb()
                    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
                }
                else -> {
                    val window = (view.context as Activity).window
                    window.statusBarColor = colorScheme.background.toArgb()
                    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
                }
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}

package uk.ac.tees.mad.sharequick.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = VioletCore, onPrimary = OnSurfaceDark,
    primaryContainer = VioletDeep, onPrimaryContainer = VioletContainer,
    secondary = CyanAccent, onSecondary = SurfaceDark,
    secondaryContainer = CyanDim, onSecondaryContainer = SurfaceDark,
    background = SurfaceDark, onBackground = OnSurfaceDark,
    surface = SurfaceDarkMid, onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceDarkCard, onSurfaceVariant = OnSurfaceDarkMuted,
    error = ErrorRed, outline = OnSurfaceDarkMuted
)

private val LightColorScheme = lightColorScheme(
    primary = VioletCore, onPrimary = SurfaceLightCard,
    primaryContainer = VioletContainer, onPrimaryContainer = VioletDeep,
    secondary = CyanDim, onSecondary = SurfaceLightCard,
    secondaryContainer = SurfaceLightMid, onSecondaryContainer = VioletDeep,
    background = SurfaceLight, onBackground = OnSurfaceLight,
    surface = SurfaceLightCard, onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceLightMid, onSurfaceVariant = OnSurfaceLightMuted,
    error = ErrorRed, outline = OnSurfaceLightMuted
)

@Composable
fun ShareQuickTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = ShareQuickTypography,
        content = content
    )
}
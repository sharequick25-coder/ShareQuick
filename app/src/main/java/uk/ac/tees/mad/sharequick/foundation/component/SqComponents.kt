package uk.ac.tees.mad.sharequick.foundation.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.mad.sharequick.ui.theme.*

@Composable
fun SqPrimaryButton(label: String, onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true, loading: Boolean = false) {
    Button(
        onClick = onClick, enabled = enabled && !loading,
        modifier = modifier.fillMaxWidth().height(52.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary, contentColor = MaterialTheme.colorScheme.onPrimary)
    ) {
        if (loading) CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary, strokeWidth = 2.dp)
        else Text(text = label, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun ShimmerBox(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateX by transition.animateFloat(
        initialValue = 0f, targetValue = 1000f,
        animationSpec = infiniteRepeatable(animation = tween(1200, easing = LinearEasing), repeatMode = RepeatMode.Restart),
        label = "shimmer_x"
    )
    Box(modifier = modifier.clip(RoundedCornerShape(12.dp)).background(
        Brush.linearGradient(
            colors = listOf(VioletCore.copy(alpha = 0.08f), VioletSoft.copy(alpha = 0.18f), VioletCore.copy(alpha = 0.08f)),
            start = Offset(translateX - 300f, 0f), end = Offset(translateX, 0f)
        )
    ))
}

@Composable
fun SqErrorBanner(message: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).background(MaterialTheme.colorScheme.error.copy(alpha = 0.12f)), contentAlignment = Alignment.Center) {
        Text(text = message, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
private fun SqPrimaryButtonPreview() {
    ShareQuickTheme { SqPrimaryButton(label = "Send File", onClick = {}) }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F0D1A)
@Composable
private fun SqPrimaryButtonDarkPreview() {
    ShareQuickTheme(darkTheme = true) { SqPrimaryButton(label = "Send File", onClick = {}) }
}
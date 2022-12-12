package com.example.novimichigantour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.novimichigantour.ui.theme.NoviMichiganTourTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoviMichiganTourTheme {
                val windowSize = calculateWindowSizeClass(activity = this)
                NoviMichiganTourApp(
                    windowSize = windowSize.widthSizeClass
                )
            }
        }
    }
}

@Preview
@Composable
fun NoviMichiganTourAppCompactPreview() {
    NoviMichiganTourTheme() {
        NoviMichiganTourApp(windowSize = WindowWidthSizeClass.Compact)
    }
}

@Preview
@Composable
fun NoviMichiganTourAppMediumPreview() {
    NoviMichiganTourTheme() {
        NoviMichiganTourApp(windowSize = WindowWidthSizeClass.Medium)
    }
}

@Preview
@Composable
fun NoviMichiganTourAppExpandedPreview() {
    NoviMichiganTourTheme() {
        NoviMichiganTourApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}

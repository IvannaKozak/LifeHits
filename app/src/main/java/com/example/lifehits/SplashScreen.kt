package com.example.lifehits

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lifehits.ui.theme.MyFont
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(com.example.lifehits.navigation.Screen.Home.route)
    }
    Splash(alpha = alphaAnim.value)
}


@Composable
fun Splash(alpha: Float){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = if (isSystemInDarkTheme()) Color.Black else Color.White)){
        Column(
           // Modifier.background()
        ) {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.charac),
                        contentDescription = "Значок электронной почты",
                        modifier = Modifier
                            .size(200.dp)
                            .alpha(alpha = alpha)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Life Hits",
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier.alpha(alpha = alpha)
                    )
                }
            }

        }
    }
}


@Composable
@Preview
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}

//Image(painter = painterResource(R.drawable.second), contentDescription = "background", modifier = Modifier
//.fillMaxHeight()
//.fillMaxWidth(1f))
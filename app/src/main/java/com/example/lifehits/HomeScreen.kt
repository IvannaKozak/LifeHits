package com.example.lifehits


import com.example.lifehits.ui.theme.Purple200
import kotlinx.coroutines.delay

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lifehits.navigation.Screen
import com.example.lifehits.ui.theme.MyFont
import kotlinx.coroutines.delay
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.example.lifehits.ui.theme.DarkBlue
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight


@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
    //    .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.charac),
                contentDescription = "character",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Login", fontSize = 27.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                modifier = Modifier
                    .padding(start = 30.dp),
                fontFamily = MyFont
            )
            Spacer(modifier = Modifier.height(30.dp))

            var email by remember{ mutableStateOf("")}
            val maxChar = 36

            TextField(
                singleLine = true,
                value = email,
                onValueChange = {
                    if (it.length <= maxChar) email = it
                },
              modifier = Modifier.align(Alignment.CenterHorizontally),
                placeholder = {
                    Text(text = "Email", fontFamily = MyFont)
                },
                colors = textFieldColors(backgroundColor = Color.White)
            )
            Spacer(modifier = Modifier.height(15.dp))
            var password by rememberSaveable { mutableStateOf("") }
            var passwordVisibility by remember { mutableStateOf(false) }
            TextField(
                singleLine = true,
                value = password,
                onValueChange = {
                    if (it.length <= maxChar) password = it
                },
                placeholder = { Text("Password", fontFamily = MyFont) },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = textFieldColors(backgroundColor = Color.White),
                trailingIcon = {
                    val image = if (passwordVisibility)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(imageVector  = image, "")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Forgot password?", fontFamily = MyFont,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 50.dp)
                    .clickable(onClick = {}),
                color = DarkBlue,
                fontSize = 12.sp)
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DarkBlue,
                    contentColor = Color.White),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(255.dp)
                    .height(40.dp)
                   // .background(Image(painter = painterResource(R.drawable.butfirst), contentDescription = "image"))
            ){
                    Text(text = "Login", fontFamily = MyFont, fontSize = 16.sp)
                }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Or, login with...", fontFamily = MyFont,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.DarkGray,
                fontSize = 12.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedButton(onClick = { /*TODO*/ },
                    border = BorderStroke(1.dp, DarkBlue),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White)
                ) {
                    Image(painter = painterResource(R.drawable.ic_google),
                        contentDescription = "google",
                        modifier = Modifier.width(60.dp))
                }
                Spacer(modifier = Modifier.width(30.dp))
                OutlinedButton(onClick = { /*TODO*/ },
                    border = BorderStroke(1.dp, DarkBlue),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White)
                ) {
                    Image(painter = painterResource(R.drawable.ic_apple),
                        contentDescription = "google",
                        modifier = Modifier.width(60.dp))
                }
                Spacer(modifier = Modifier.width(30.dp))
                OutlinedButton(onClick = { /*TODO*/ },
                    border = BorderStroke(1.dp, DarkBlue),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White)
                ) {
                    Image(painter = painterResource(R.drawable.ic_facebook),
                        contentDescription = "google",
                        modifier = Modifier.width(60.dp))
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
                Text(text = "Create new account? ", fontFamily = MyFont)
                Text(text = "Register", color = DarkBlue,
                    modifier = Modifier.clickable(onClick = {}),
                    fontFamily = MyFont)
            }
        }
    }
}


@Composable
@Preview
fun SettingsScreenPreview() {
    HomeScreen()
}


@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SettingsScreenDarkPreview() {
    HomeScreen()
}
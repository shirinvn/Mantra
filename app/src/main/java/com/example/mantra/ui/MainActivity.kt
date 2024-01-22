package com.example.mantra.ui.theme

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.mantra.MyApp
import com.example.mantra.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MantraAppTheme {


                MyApp()



            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Splashscreen(img: Painter){

    val coorutineScope = rememberCoroutineScope()

    coorutineScope.launch {
        delay(1000)
        Log.e("LOG", "this is next screen")
    }
   Image(painter = img, contentDescription = "",
        modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
}


@Composable
fun MainScreen(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)) {
        Text(text = "this is Main Page")
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MantraAppTheme {
        Splashscreen(img = painterResource(id = R.drawable.splash))

    }

}
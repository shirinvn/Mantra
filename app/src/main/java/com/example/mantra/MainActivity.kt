package com.example.mantra

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.mantra.ui.theme.MantraAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MantraAppTheme {


                Scaffold(contentWindowInsets = WindowInsets(left = 0.dp,
                    top=0.dp, bottom = 0.dp, right = 0.dp),
                ) {paddingValues->

                    //your child views padding:

                    Box(modifier = Modifier
                        .padding(paddingValues)
                    ){
                    }
                    Splashscreen(img = painterResource(id =R.drawable.splash))
                    }



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
package com.example.mantra

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mantra.ui.theme.MantraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MantraTheme {

                Splashscreen(img = painterResource(id =R.drawable.splash))


            }
        }
    }
}

@Composable
fun Splashscreen(img: Painter){

   Image(painter = img, contentDescription = "",
        modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MantraTheme {
        Splashscreen(img = painterResource(id = R.drawable.splash))

    }

}
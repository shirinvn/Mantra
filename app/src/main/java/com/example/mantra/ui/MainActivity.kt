package com.example.mantra.ui.theme

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
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
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mantra.R
import com.example.mantra.viewmodel.MantraViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {


    private lateinit var mantraViewModel: MantraViewModel
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mantraViewModel= ViewModelProvider(this).get(mantraViewModel::class.java)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        mantraViewModel.getAllData().observe(this) {
            Toast.makeText(this, "Manta Items Changed", Toast.LENGTH_SHORT).show()
        }
        setContent {
            MantraAppTheme {

                MainScreen()

            }
        }
    }
}



@Composable
fun MainScreen(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)) {


            Text(text = "this is Main Page")
            Image(painter = painterResource(id = R.drawable.splash), contentDescription ="" )
        }

    }
}




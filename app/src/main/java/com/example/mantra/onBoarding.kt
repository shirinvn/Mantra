package com.example.mantra

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.log

enum class MantraCategory {
    LOVE,
    PEACE,
    HAPPINESS
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(onCategorySelected: (MantraCategory) -> Unit) {
    var selectedCategory by remember { mutableStateOf<MantraCategory?>(null) }

    Scaffold {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Select your preferred Mantra category")
            Spacer(modifier = Modifier.height(16.dp))

            MantraCategory.values().forEach { category ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .selectable(
                            selected = (selectedCategory == category),
                            onClick = {
                                selectedCategory = category
                                onCategorySelected(category)
                            }
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (selectedCategory == category),
                        onClick = {
                            selectedCategory = category
                            onCategorySelected(category)
                        },
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(text = category.name)
                }
            }
        }
    }
}

@Composable
fun AppContent(selectedCategory: MantraCategory) {
    // اینجا می‌تونید بر اساس selectedCategory تغییرات لازم رو در اپلیکیشن اعمال کنید
    // برای مثال، می‌تونید متدهای مرتبط با نمایش جملات مانترا بر اساس دسته‌بندی رو اینجا صدا بزنید یا کارهای دیگه انجام بدید.
    when (selectedCategory) {
        MantraCategory.LOVE -> {
            Log.e("ok", "love select")
            // اعمال تغییرات برای دسته مورد نظر
        }
        MantraCategory.PEACE -> {
            // اعمال تغییرات برای دسته مورد نظر
        }
        MantraCategory.HAPPINESS -> {
            // اعمال تغییرات برای دسته مورد نظر
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyApp() {
    var selectedCategory by remember { mutableStateOf<MantraCategory?>(null) }

    if (selectedCategory == null) {
        OnboardingScreen { category ->
            selectedCategory = category
        }
    } else {
        AppContent(selectedCategory!!)
    }
}

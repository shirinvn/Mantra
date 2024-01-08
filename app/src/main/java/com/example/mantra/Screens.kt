package com.example.mantra

sealed class Screens( val route: String){


    object Splash : Screens("splash_screen")
    object Quiz : Screens("quiz_screen")
    object Home : Screens("home_screen")


    fun withArgs(vararg  args: Any): String{

        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }

}


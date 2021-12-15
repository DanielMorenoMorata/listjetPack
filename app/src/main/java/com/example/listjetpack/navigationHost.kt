package com.example.listjetpack

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listjetpack.Destinations.*

@Composable
fun navitationHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PantallaInicio.route){
        composable(PantallaInicio.route){
            pantallaInicio(
                navegarPantallaInformacion ={ pasarNombre,pasarDetalle ->
                    navController.navigate(PantallaInformacion.createRoute(pasarNombre,pasarDetalle))
                }

            )


        }

        composable(PantallaInformacion.route){ navBackStackEntry ->
            var pasarNombre = navBackStackEntry.arguments?.getString("pasarNombre")
            var pasarDetalle = navBackStackEntry.arguments?.getString("pasarDetalle")
            pantallaInformacion(pasarNombre!!,pasarDetalle!!)
        }
    }
}


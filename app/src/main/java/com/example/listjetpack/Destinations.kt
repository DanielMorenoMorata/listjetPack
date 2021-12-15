package com.example.listjetpack

sealed class Destinations(
    val route:String
){
    object PantallaInicio:Destinations("pantallaInicio")
    object PantallaInformacion:Destinations("pantallaInformacion/{pasarNombre}/{pasarDetalle}"){
        fun createRoute(pasarNombre:String,pasarDetalle:String)="pantallaInformacion/$pasarNombre/$pasarDetalle"
    }
}

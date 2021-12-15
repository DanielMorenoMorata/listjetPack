package com.example.listjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.listjetpack.ui.theme.ListjetPackTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter


fun seleccionarImagen(Nombre:String):String{
    var urlImagen:String=""
    when(Nombre){
        "Dragonborn" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/6/340/420/618/636272677995471928.png"
        "Enano" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/6/254/420/618/636271781394265550.png"
        "Elfo" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/7/639/420/618/636287075350739045.png"
        "Gnomo" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/6/334/420/618/636272671553055253.png"
        "Semi-Elfo" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/6/481/420/618/636274618102950794.png"
        "Mediano" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/6/256/420/618/636271789409776659.png"
        "Semi-Orcos" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/6/466/420/618/636274570630462055.png"
        "Humano" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/6/258/420/618/636271801914013762.png"
        "Tiefling" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/7/641/420/618/636287076637981942.png"
        "Aarakocra" -> urlImagen="https://static.wikia.nocookie.net/dungeons202620dragons205c2aa20edicic3b3n/images/6/6d/Aarakocra.png/revision/latest?cb=20200506143901&path-prefix=es"
        "Genasi" -> urlImagen="https://static.wikia.nocookie.net/dungeons202620dragons205c2aa20edicic3b3n/images/f/f9/Genasi_fuego.png/revision/latest?cb=20200507133821&path-prefix=es"
        "Goliath" -> urlImagen="https://www.dndbeyond.com/avatars/thumbnails/7/620/420/618/636286749289682134.png"
    }
    return urlImagen
}

@Composable
fun pantallaInformacion(
    pasarNombre: String,
    pasarDetalle: String
){
    var enlaceFoto:String = seleccionarImagen(pasarNombre)
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = Color.White)
        ) {
            Image(
                painter = rememberImagePainter(enlaceFoto),
                contentDescription = "Imagen",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentScale = ContentScale.Fit
            )

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
        ){
            Text(text = pasarDetalle,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}




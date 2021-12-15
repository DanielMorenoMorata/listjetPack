package com.example.listjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.listjetpack.ui.theme.ListjetPackTheme

val listaRazas = mutableListOf<Raza>(
    Raza("Dragonborn", "https://www.dndbeyond.com/avatars/thumbnails/6/340/420/618/636272677995471928.png","Siendo DragonBorn obtendras un +2 a tu Fuerza y un +1 a tu Carisma." +
            "Obtendras un ataque de aliento elemental dependiendo del color de tus escamas, ademas de resistencia a dicho elemento" +
            "Laa clasea mas recomendablea para los DragonBorns son los paladines o los guerreros"),
    Raza("Enano", "https://www.dndbeyond.com/avatars/thumbnails/6/254/420/618/636271781394265550.png", "Como enano obtendras un +2 a tu Constitución, y, dependiendo de tu origen, un +1 a Sabiduria o un +2 a tu Fuerza" +
            "Tienes resistencia al daño de veneneno ademas de ser capaz de usar hachas y mazas a la perfección" +
            "Las clases mas recomendables para los Enanos son todas aquellas que vayan cuerpo a cuerpo"),
    Raza("Elfo", "https://www.dndbeyond.com/avatars/thumbnails/7/639/420/618/636287075350739045.png", "Como elfo obtendras un +2 a tu Destreza, y, dependiendo de tu orgien, un +1 a Carisma, Inteligencia o Sabiduria" +
            "Tu habilidad especial dependera de tu origen, haciendo que sea una clase bastante versatil" +
            "Los elfos pueden ser cualquier clase que dependa de destraza o estadisticas mágicas"),
    Raza("Gnomo", "https://www.dndbeyond.com/avatars/thumbnails/6/334/420/618/636272671553055253.png","Los gnomos obtienen un +2 a su Inteligencia, y, dependiendo de tu origen, un +1 a Destreza o Constitución" +
            "Los gnomos tienen resistencia a salvaciones por ataques mágicos, ademas de una habilidad extra por tu origen" +
            "Las mejores clases para los gnomos son el picaro, guerrero,  artificiero o mago"),
    Raza("Semi-Elfo", "https://www.dndbeyond.com/avatars/thumbnails/6/481/420/618/636274618102950794.png","Los semielfos obtienen un +2 a Carisma y un +1 a dos habilidades a tu elección" +
            "Obtienes ventaja para no ser encantado y no te pueden dormir usando mágia" +
            "Las mejores clases para los semi-elfos son Bardo, Hechicero, Paladin y Brujo"),
    Raza("Mediano", "https://www.dndbeyond.com/avatars/thumbnails/6/256/420/618/636271789409776659.png", "Los medianos obtienen un +2 a Destreza, y, dependiendo de tu origen, un +1 a Carisma o Constitución" +
            "Obtienes la habilidad 'Suertudo', si sacas un 1 en la tirada puedes volver a tirar" +
            "Las mejores clases para los medianos son Picaro, Bardo, Brujo o Hechicero"),
    Raza("Semi-Orcos","https://www.dndbeyond.com/avatars/thumbnails/6/466/420/618/636274570630462055.png","Los semi-orcos obtienen un +2 a Fuerza y un +1 a Constitución" +
            "Como Semi-Orco, si te quitan toda tu vida en vez de caer inconsciente puedes ponerte con un punto de vida de nuevo, aunque solo lo puedes hacer una vez por dia" +
            "Las mejores clases para los Semi-Orcos son Barbaro, Guerrero y Paladin"),
    Raza("Humano","https://www.dndbeyond.com/avatars/thumbnails/6/258/420/618/636271801914013762.png","Los humanos pueden obtener un +1 a todas sus habilidades o un +1 a dos y conseguir una hazaña de la lista de hazañas" +
            "Como humano no obtienes ninguna habilidad especial" +
            "Los humanos pueden ser cualquier clase gracias a su versatiliad"),
    Raza("Tiefling","https://www.dndbeyond.com/avatars/thumbnails/7/641/420/618/636287076637981942.png","Los tieflings obtienen un +2 a Carisma y un +1 a Inteligencia" +
            "Los Tieflings obtienen resistencia al fuego ademas de habilidades mágicas de fuego" +
            "Las mejores clases para el Tiefling son cualquiera que tenga aptitudes mágicas"),
    Raza("Aarakocra","https://static.wikia.nocookie.net/dungeons202620dragons205c2aa20edicic3b3n/images/6/6d/Aarakocra.png/revision/latest?cb=20200506143901&path-prefix=es", "Como Aarakocra obtienes un +2 a Destreza y un +1 a Sabiduria" +
            "Como Aarakocra obtendras la habilidad de volar" +
            "Las mejores clases para son Guerreros, Clerigos, Picaros o Druidas"),
    Raza("Genasi","https://static.wikia.nocookie.net/dungeons202620dragons205c2aa20edicic3b3n/images/f/f9/Genasi_fuego.png/revision/latest?cb=20200507133821&path-prefix=es","Los Genasi obtienen un +2 a su Constitución y, dependiendo de a que elemento seas afín, un +1 a Destreza,Fuerza,Inteligencia o Sabiduria" +
            "Las habilidades de los Genasi dependen de a que elemento seas afín" +
            "Las mejores clases para los Genasi son todas gracias a su versatilidad"),
    Raza("Goliath","https://www.dndbeyond.com/avatars/thumbnails/7/620/420/618/636286749289682134.png","Los Goliaths obtienen un +2 a Fuerza y un +1 a Constitución" +
            "Siendo un Golitah obtienes resistencia al daño de frio" +
            "Las mejores clases para los Goliaths son el Bárbaro y el Guerrero")
)

@Composable
fun pantallaInicio(
    navegarPantallaInformacion: (String,String) -> Unit
    ) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ){
        item{
            Text(
                text = "Razas de D&D",
                style = TextStyle(
                    color = Color.Red,
                    fontSize=40.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        items(listaRazas){ raza ->
            var pasarNombre:String = raza.nombre
            var pasarDetalles:String = raza.detalle
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {
                        navegarPantallaInformacion(pasarNombre,pasarDetalles)
                    }),

                ){
                Box(
                    modifier = Modifier
                        .height(400.dp)
                        .fillMaxWidth()
                ){
                    Image(
                        painter = rememberImagePainter(raza.imagen),
                        contentDescription = "Imagen",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        contentScale = ContentScale.Fit
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = raza.nombre,
                        modifier= Modifier
                            .align(Alignment.BottomCenter)
                        ,
                        style = TextStyle(
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Light,

                                )
                        )
                    }
            }
        }
    }
}


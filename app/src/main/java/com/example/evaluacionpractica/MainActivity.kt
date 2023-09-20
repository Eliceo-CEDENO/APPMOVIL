package com.example.evaluacionpractica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.evaluacionpractica.ui.theme.EvaluacionPracticaTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp




class Jugador(val nombre: String, val año: String,val goles:Int, val image: Int)


val jugadorList = listOf(
    Jugador("Cristiano Ronaldo ", "38", 851 ,R.drawable.ronaldo),
    Jugador("Lionel Messi", "36", 819, R.drawable.messi),
    Jugador("Erling Haaland", "23", 217, R.drawable.haland),
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                JugadorList(jugadorList)
            }
        }
    }
}
@Composable
fun JugadorList(jugadors: List<Jugador>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(jugadors) { jugador ->
            JugadorCard(jugador)
        }
    }
}

@Composable
fun JugadorCard(jugador: Jugador) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().background(Color.LightGray)) {
            Image(
                painter = painterResource(jugador.image),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,

            )
            Text(
                text = jugador.nombre,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(8.dp), color =Color.Blue
            )
            Text(
                text = "Años: ${jugador.año}",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(8.dp), color = Color.Black

            )
            Text(
                text = "Goles marcados:${jugador.goles.toString()}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp), color = Color.Black,
                fontSize = 20.sp
            )
        }
    }
}
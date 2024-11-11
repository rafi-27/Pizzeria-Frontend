package com.example.pizzeriathiar.ui.home

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzeriathiar.R
import com.example.pizzeriathiar.data.Ingrediente
import com.example.pizzeriathiar.data.PizzaDTO
import com.example.pizzeriathiar.data.ProductoDTO
import com.example.pizzeriathiar.data.SIZE
import com.example.pizzeriathiar.data.TipoProducto
import com.example.pizzeriathiar.ui.login.LoginViewModel
import com.example.pizzeriathiar.ui.registro.PantallaRegistro
import com.example.pizzeriathiar.ui.registro.RegistroViewModel


@Composable
fun PantallaProducto(homeViewModel: HomeViewModel) {
    val listaProductos: List<ProductoDTO> by homeViewModel.productosDTO.observeAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = (MaterialTheme.colorScheme.background))
    ) {
        item {
            //Text("Pizza")
            ProductoItem(
                ProductoDTO(
                    1,
                    "Pizza kebab",
                    15.0,
                    SIZE.PEQUEÑA,
                    listOf(Ingrediente(11, "Pizza", listOf("PAler1", "PAler12"))),
                    TipoProducto.PIZZA
                ), R.drawable.kebabpizza
            )
        }

        items(listaProductos) { producto ->
            ProductoItem(producto = producto, foto = R.drawable.kebabpizza)
        }


    }


}


@Composable
fun ProductoItem(producto: ProductoDTO, foto: Int) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier.size(100.dp),
                alignment = Alignment.CenterStart,
                painter = painterResource(foto),
                contentDescription = ""
            )
            Column {
                Text(
                    producto.nombre,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 5.dp)
                )
                Text(
                    producto.listaIngredientesProducto.joinToString(),
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 5.dp)
                )
                Text(
                    "" + producto.precio+"€",
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 5.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalHomePreview() {
    PantallaProducto(HomeViewModel())
}
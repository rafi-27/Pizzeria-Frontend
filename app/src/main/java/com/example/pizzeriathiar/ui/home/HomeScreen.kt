package com.example.pizzeriathiar.ui.home

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.sp
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
    val listaPizzas = listaProductos.filter { it.tipo==TipoProducto.PIZZA }
    val listaPastas = listaProductos.filter { it.tipo==TipoProducto.PASTA }
    val listaBebidas = listaProductos.filter { it.tipo==TipoProducto.BEBIDA }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = (MaterialTheme.colorScheme.background))
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterVertically)
                )

                Text(
                    text = "LA PIZZA DEL SULTAN",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth().padding(top = 40.dp)
                )
            }

        }

        item { Text(text = "Pizzas") }

        items(listaPizzas) { producto ->
            ProductoItem(producto, R.drawable.kebabpizza)
        }

    }
}


@Composable
fun ProductoItem(producto: ProductoDTO, foto: Int) {
    var cantidad: remember by (mutableSetOf(1))

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
                    //el que hize yo:producto.listaIngredientesProducto.map { it.nombre }.joinToString(),
                    //pero android studio me chivo la manera que estoy usando acontinuacion:para mostrar solo el nombre sin nada mas
                    producto.listaIngredientesProducto.joinToString { it.nombre },
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 5.dp)
                )
                Text(
                    "" + producto.precio + "€",
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 5.dp)
                )
                Row (modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically){
                    Spacer(modifier = Modifier.width(16.dp))
                    TextButton(onClick = {if (cantidad>1){cantidad--} }) {
                        Text(
                            "-",
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(5.dp)
                        )
                    }
                    Text(text=""+cantidad)
                    TextButton(onClick = {cantidad++}) {
                        Text(
                        "+",
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(5.dp)
                    )
                    }

                    TextButton(onClick = {}) {  }
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalHomePreview() {
    PantallaProducto(HomeViewModel())
}
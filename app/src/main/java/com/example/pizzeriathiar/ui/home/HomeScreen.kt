package com.example.pizzeriathiar.ui.home

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.pizzeriathiar.data.LineaPedidoDTO
import com.example.pizzeriathiar.data.PizzaDTO
import com.example.pizzeriathiar.data.ProductoDTO
import com.example.pizzeriathiar.data.SIZE
import com.example.pizzeriathiar.data.TipoProducto
import com.example.pizzeriathiar.ui.login.LoginViewModel
import com.example.pizzeriathiar.ui.registro.PantallaRegistro
import com.example.pizzeriathiar.ui.registro.RegistroViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaProducto(homeViewModel: HomeViewModel) {
    val listaProductos: List<ProductoDTO> by homeViewModel.productosDTO.observeAsState(listOf())
    val listaLineaPedido: List<LineaPedidoDTO> by homeViewModel.listaLineaDePedidos.observeAsState(listOf())

    val listaPizzas = listaProductos.filter { it.tipo == TipoProducto.PIZZA }
    val listaPastas = listaProductos.filter { it.tipo == TipoProducto.PASTA }
    val listaBebidas = listaProductos.filter { it.tipo == TipoProducto.BEBIDA }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = (MaterialTheme.colorScheme.background))
    ) {
        item {
            TopAppBar(modifier = Modifier.fillMaxWidth(),
                title = {
                    Row (verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = "",
                            modifier = Modifier.size(50.dp)
                        )
                        //Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "LA PIZZA DEL SULTAN", fontSize = 18.sp, modifier = Modifier.padding(start = 4.dp))
                    }

                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge {
                                Text(
                                    text = ""+listaLineaPedido.sumOf {it.cantidad}
                                )
                            }
                        }, modifier = Modifier.padding(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Carrito"
                        )
                    }
                }
            )
        }

        item {
            Text(
                text = "Pizzas",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )
        }

        items(listaPizzas) { producto ->
            ProductoItem(producto, R.drawable.kebabpizza)
        }

        item {
            Text(
                text = "Pasta",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )
        }

        items(listaPastas) { producto ->
            ProductoItem(producto, R.drawable.pasta)
        }

        item {
            Text(
                text = "Bebida",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )
        }

        items(listaBebidas) { producto ->
            ProductoItem(producto, R.drawable.powerking)
        }


    }
}


@Composable
fun ProductoItem(producto: ProductoDTO, foto: Int) {
    var cantidad by rememberSaveable { mutableStateOf(1) }
    var selectSize by rememberSaveable { mutableStateOf("Tamaño") }
    var desplegar by rememberSaveable { mutableStateOf(false) }


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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = {
                        if (cantidad > 1) {
                            cantidad--
                        }
                    }) {
                        Text(
                            "-",
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(5.dp)
                        )
                    }
                    Text(text = "" + cantidad)
                    TextButton(onClick = { cantidad++ }) {
                        Text(
                            "+",
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(5.dp)
                        )
                    }
                    if (producto.tipo == TipoProducto.PIZZA || producto.tipo == TipoProducto.BEBIDA) {
                        Column {
                            TextButton(onClick = { desplegar = true }) { Text(text = selectSize) }
                            DropdownMenu(
                                expanded = desplegar,
                                onDismissRequest = { desplegar = false }) {
                                DropdownMenuItem(
                                    onClick = { selectSize = "Grande"
                                        desplegar = false },
                                    text = { Text(SIZE.GRANDE.toString()) })
                                DropdownMenuItem(
                                    onClick = { selectSize = "Mediana"
                                        desplegar = false},
                                    text = { Text(SIZE.MEDIANA.toString()) })
                                DropdownMenuItem(
                                    onClick = { selectSize = "Pequeña"
                                        desplegar = false},
                                    text = { Text(SIZE.PEQUEÑA.toString()) })
                            }
                        }
                    }

                    TextButton(onClick = {}) {
                        Text(
                            text = "+",
                            fontSize = 20.sp
                        )
                    }


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
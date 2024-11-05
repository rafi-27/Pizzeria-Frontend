package com.example.pizzeriathiar.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.painter.Painter
import com.example.pizzeriathiar.data.ProductoDTO
import com.example.pizzeriathiar.ui.login.LoginViewModel

@Composable
fun PantallaProducto(homeViewModel:HomeViewModel) {
    val listaProductos:List<ProductoDTO> by homeViewModel.productosDTO.observeAsState(initial = emptyList())

    LazyColumn() {
        item {
            Text("Pizza")
        }

    }



}

@Composable
fun ProductoItem(producto:ProductoDTO,foto:Int){
    Card() {
        Text(producto.nombre)
        Text(producto.listaIngredientesProducto.joinToString())
        Text(""+producto.precio)


    }
}
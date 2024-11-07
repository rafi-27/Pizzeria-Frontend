package com.example.pizzeriathiar.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
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
fun PantallaProducto(homeViewModel:HomeViewModel) {
    val listaProductos:List<ProductoDTO> by homeViewModel.productosDTO.observeAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize().background(color = (MaterialTheme.colorScheme.background))) {
        item {
            Text("Pizza")
            ProductoItem(ProductoDTO(1,"Pizza kebab",15.0,SIZE.PEQUEÑA, listOf(Ingrediente(11,"Pizza", listOf("PAler1","PAler12"))),TipoProducto.PIZZA),R.drawable.kebabpizza)
        }

//        items(listaProductos) { producto ->
//            ProductoItem(producto = producto, foto = R.drawable.kebabpizza)
//        }


    }



}


@Composable
fun ProductoItem(producto:ProductoDTO,foto:Int){
    Card(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(300.dp)
                .padding(top = 50.dp),
            painter = painterResource(foto),
            contentDescription = ""
        )
        Text(producto.nombre)
        Text(producto.listaIngredientesProducto.joinToString())
        Text(""+producto.precio)
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalHomePreview(){
    PantallaProducto(HomeViewModel())
}
package com.reinosa.apilist.View.Recycler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.reinosa.apilist.Model.Article
import com.reinosa.apilist.ViewModel.APIViewModel


@Composable
fun newsItem(noticia: Article, navController: NavController, viewModel: APIViewModel) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable {
                viewModel.modificarNoticiaId(noticia.source.id.toString())
                navController.navigate("detail")
                 },
        ){
            Row() {

                Column {
                    AsyncImage(
                        model = noticia.urlToImage,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = noticia.title,
                        fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(4.dp))
                    Spacer(modifier = Modifier.padding(4.dp))

                }
            }

    }
}
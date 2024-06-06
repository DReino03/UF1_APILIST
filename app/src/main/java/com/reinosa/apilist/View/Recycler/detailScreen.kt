import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.reinosa.apilist.Model.Article
import com.reinosa.apilist.ViewModel.APIViewModel


@Composable
fun detailScreen(viewModel: APIViewModel, navController: NavController) {
    val noticia = viewModel.getNoticiasPorId(viewModel.currentId())
    val showLoading: Boolean by viewModel.loading.observeAsState(true)
    val context = LocalContext.current
    val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(noticia?.url))
    Box(modifier = Modifier.fillMaxSize()) {
        if (showLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)
            )
        } else {
            if (noticia != null) {
                LazyColumn(modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxHeight()) {
                    item {
                        val image = rememberImagePainter(data = noticia.urlToImage)
                        Image(
                            painter = image,
                            contentDescription = "News Image",
                            modifier = Modifier.size(200.dp).fillMaxWidth()
                        )
}
                    item {
                        Text(text = noticia.author,
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier
                                .padding(5.dp)
                                .background(Color.LightGray))
                        Text(text = noticia.publishedAt,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .background(Color.LightGray))

                        Text(
                            text = noticia.title,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .background(Color.LightGray))
                        Spacer(modifier = Modifier.padding(20.dp))
                    }
                    item {
                        Text(
                            text = noticia.description,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .background(Color.LightGray))
                        Text(text = noticia.content,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .background(Color.LightGray))

                        Text(text = noticia.url,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .background(Color.LightGray)
                                .clickable { context.startActivity(webIntent) })

                    }
                    item {
                        ShareButton(noticia.url, context)
                    }
                    item {
                        Text(text = noticia.source.name)
                    }
                }
            } else {
                Text(text = "No se ha encontrado la noticia",
                    modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}





@Composable
fun ShareButton(text: String, context: Context) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)

    IconButton(
        modifier = Modifier,
        onClick = {
            ContextCompat.startActivity(context, shareIntent, null)
        },
    ) {
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "Share",
            tint = Color.White
        )
    }

}

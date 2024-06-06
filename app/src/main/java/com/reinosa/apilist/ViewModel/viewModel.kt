package com.reinosa.apilist.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reinosa.apilist.API.Repository
import com.reinosa.apilist.Model.Article
import com.reinosa.apilist.Model.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class APIViewModel: ViewModel() {

    private val repository = Repository()
    private val _loading = MutableLiveData(true)
    val loading = _loading
    private val _noticias = MutableLiveData<Data>()
    val noticias = _noticias
    private var id:String by mutableStateOf("")

    private val _isFavorite = MutableLiveData(false)
    val isFavorite = _isFavorite
    private val _favorites = MutableLiveData<MutableList<>>()
    val favorites = _favorites

    init {
        getNoticias()
    }

    fun getNoticias() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getNoticia()
            withContext(Dispatchers.Main) {
                if(response.isSuccessful){
                    println("ERROR:${response.body()} ")
                    _noticias.value = response.body()
                    _loading.value = false
                }
                else{
                    Log.e("Error :", response.message())
                }
            }
        }
    }
    fun onSearchTextChange(text: String) {
        Log.d("APIViewModel", "onSearchTextChange: $text")
    }
    fun searchText() {
        //el text que es mostra a la caixa de text.

    }

    fun getNoticiasPorId(id: String):Article?{
        return noticias.value?.articles?.find { it.source.id == id }
    }
    fun modificarNoticiaId(id:String){
        this.id = id
    }
    fun currentId():String{
        return id
    }

}
package com.reinosa.apilist.API

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reinosa.apilist.Model.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository {
        val apiInterface = ApiInterface.create()
        suspend fun getNoticia() = apiInterface.getNoticias()

        //val daoInterface =
}
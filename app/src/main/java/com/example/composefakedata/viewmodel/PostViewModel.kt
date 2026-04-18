package com.example.composefakedata.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefakedata.model.Post
import com.example.composefakedata.network.RetrofitInstance
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    var postList = mutableStateListOf<Post>()

    init {
        getPosts()
    }

    private fun getPosts(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPosts()
                postList.addAll(response)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}
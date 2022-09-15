package com.example.practicemvvm1.data.network

import com.example.practicemvvm1.core.RetrofitHelper
import com.example.practicemvvm1.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api: QuoteApiClient) {

    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            //val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }

}
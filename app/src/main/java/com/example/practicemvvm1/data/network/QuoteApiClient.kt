package com.example.practicemvvm1.data.network

import com.example.practicemvvm1.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>


}
package com.example.practicemvvm1.data

import com.example.practicemvvm1.data.model.QuoteModel
import com.example.practicemvvm1.data.model.QuoteProvider
import com.example.practicemvvm1.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }

}
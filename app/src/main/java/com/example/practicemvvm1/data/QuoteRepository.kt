package com.example.practicemvvm1.data

import com.example.practicemvvm1.data.model.QuoteModel
import com.example.practicemvvm1.data.model.QuoteProvider
import com.example.practicemvvm1.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuoteProvider) {

    //private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        //QuoteProvider.quotes = response
        quoteProvider.quotes = response
        return response
    }

}
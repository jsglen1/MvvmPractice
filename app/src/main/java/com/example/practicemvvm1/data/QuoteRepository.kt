package com.example.practicemvvm1.data

import com.example.practicemvvm1.data.databaseRoom.dao.QuoteDao
import com.example.practicemvvm1.data.databaseRoom.entities.QuoteEntity
import com.example.practicemvvm1.data.model.QuoteModel
import com.example.practicemvvm1.data.network.QuoteService
import com.example.practicemvvm1.domain.model.Quote
import com.example.practicemvvm1.domain.model.ToDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    // private val quoteProvider: QuoteProvider,
    private val quoteDao: QuoteDao
) {

    //private val api = QuoteService()

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        //QuoteProvider.quotes = response
        //quoteProvider.quotes = response
        return response.map { it.ToDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.ToDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insetAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }

}
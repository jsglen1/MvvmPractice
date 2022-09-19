package com.example.practicemvvm1.domain

import com.example.practicemvvm1.data.QuoteRepository
import com.example.practicemvvm1.data.databaseRoom.entities.ToDataBase
import com.example.practicemvvm1.data.model.QuoteModel
import com.example.practicemvvm1.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    //private val repository = QuoteRepository()

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.ToDataBase() })
            quotes

        } else {
            repository.getAllQuotesFromDatabase()
        }

    }

}
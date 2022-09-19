package com.example.practicemvvm1.domain

import com.example.practicemvvm1.data.QuoteRepository
import com.example.practicemvvm1.domain.model.Quote
import javax.inject.Inject

class GetRandomUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        //val quotes = QuoteProvider.quotes
        if (quotes.isNotEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}
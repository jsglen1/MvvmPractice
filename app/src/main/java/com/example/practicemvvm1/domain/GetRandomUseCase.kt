package com.example.practicemvvm1.domain

import com.example.practicemvvm1.data.model.QuoteModel
import com.example.practicemvvm1.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        //val quotes = QuoteProvider.quotes
        if (quotes.isNotEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}
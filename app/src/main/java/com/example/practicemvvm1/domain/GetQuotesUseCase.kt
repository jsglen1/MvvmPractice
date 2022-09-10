package com.example.practicemvvm1.domain

import com.example.practicemvvm1.data.QuoteRepository
import com.example.practicemvvm1.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}
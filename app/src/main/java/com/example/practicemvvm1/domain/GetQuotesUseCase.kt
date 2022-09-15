package com.example.practicemvvm1.domain

import com.example.practicemvvm1.data.QuoteRepository
import com.example.practicemvvm1.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    //private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()

}
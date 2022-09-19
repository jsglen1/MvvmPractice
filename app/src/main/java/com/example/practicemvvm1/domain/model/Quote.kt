package com.example.practicemvvm1.domain.model

import com.example.practicemvvm1.data.databaseRoom.entities.QuoteEntity
import com.example.practicemvvm1.data.model.QuoteModel

data class Quote(
    val quote: String, val author: String
)

fun QuoteModel.ToDomain() = Quote(quote, author)
fun QuoteEntity.ToDomain() = Quote(quote, author)
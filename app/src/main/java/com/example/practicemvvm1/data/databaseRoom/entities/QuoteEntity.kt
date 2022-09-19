package com.example.practicemvvm1.data.databaseRoom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.practicemvvm1.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String
)

fun Quote.ToDataBase() = QuoteEntity(quote = quote,author = author)

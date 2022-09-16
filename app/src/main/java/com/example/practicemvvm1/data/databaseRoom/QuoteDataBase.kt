package com.example.practicemvvm1.data.databaseRoom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practicemvvm1.data.databaseRoom.dao.QuoteDao
import com.example.practicemvvm1.data.databaseRoom.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDataBase : RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao

}
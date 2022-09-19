package com.example.practicemvvm1.data.databaseRoom.dao

import androidx.room.*
import com.example.practicemvvm1.data.databaseRoom.entities.QuoteEntity

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuotes(): List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetAll(quotes:List<QuoteEntity>)

    @Query("DELETE FROM quote_table ")
    suspend fun deleteAllQuotes()
}
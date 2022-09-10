package com.example.practicemvvm1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicemvvm1.data.model.QuoteModel
import com.example.practicemvvm1.domain.GetQuotesUseCase
import com.example.practicemvvm1.domain.GetRandomUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel?>()

    val isLoading = MutableLiveData<Boolean>()

    var getRandomQuotesUseCase = GetRandomUseCase()

    var getQuotesUseCase = GetQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuotesUseCase()

        if (quote != null) {
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)


    }

}
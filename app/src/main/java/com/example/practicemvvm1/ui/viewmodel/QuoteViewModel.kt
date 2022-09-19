package com.example.practicemvvm1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicemvvm1.data.model.QuoteModel
import com.example.practicemvvm1.domain.GetQuotesUseCase
import com.example.practicemvvm1.domain.GetRandomUseCase
import com.example.practicemvvm1.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getRandomQuotesUseCase: GetRandomUseCase,
    private val getQuotesUseCase: GetQuotesUseCase

) : ViewModel() {

    val quoteModel = MutableLiveData<Quote?>()

    val isLoading = MutableLiveData<Boolean>()

    // var getRandomQuotesUseCase = GetRandomUseCase()

    // var getQuotesUseCase = GetQuotesUseCase()

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

        viewModelScope.launch {

            isLoading.postValue(true)
            val quote = getRandomQuotesUseCase()

            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)

        }

    }

}
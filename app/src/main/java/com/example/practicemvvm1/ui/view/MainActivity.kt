package com.example.practicemvvm1.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.practicemvvm1.databinding.ActivityMainBinding
import com.example.practicemvvm1.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this) { currentQuote ->
            if (currentQuote != null) {
                binding.tvQuote.text = currentQuote.quote
            }
            if (currentQuote != null) {
                binding.tvAuthor.text = currentQuote.author
            }
        }

        quoteViewModel.isLoading.observe(this) {
            binding.loading.isVisible = it
        }

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
}
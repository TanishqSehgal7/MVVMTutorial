package com.example.mvvmtutorial.ui

import androidx.lifecycle.ViewModel
import com.example.mvvmtutorial.data.Quote
import com.example.mvvmtutorial.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote)= quoteRepository.addQuote(quote)

}
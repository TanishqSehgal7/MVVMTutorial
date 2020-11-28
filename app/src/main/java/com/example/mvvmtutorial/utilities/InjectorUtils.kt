package com.example.mvvmtutorial.utilities

import com.example.mvvmtutorial.data.FakeDatabase
import com.example.mvvmtutorial.data.QuoteRepository
import com.example.mvvmtutorial.ui.QuotesViewModelFactory

object InjectorUtils  {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {

      val quoteRepository= QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }

}
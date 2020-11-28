package com.example.mvvmtutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmtutorial.R
import com.example.mvvmtutorial.data.Quote
import com.example.mvvmtutorial.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel= ViewModelProviders.of(this,factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer{ quotes->
            val stringBuilder= StringBuilder()
            quotes.forEach {quote->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text=stringBuilder.toString()
            button_add_quote.setOnClickListener {
                val quote= Quote(editText_quote.text.toString(),editText_author.text.toString())
                viewModel.addQuote(quote)
                editText_author.setText("")
                editText_quote.setText("")
            }
        })

    }
}
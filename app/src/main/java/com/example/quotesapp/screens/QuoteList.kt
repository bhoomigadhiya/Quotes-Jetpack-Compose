package com.example.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.quotesapp.models.Quote

@Composable
fun QuoteList(quotes:Array<Quote>,onClick: (quote:Quote)->Unit) {
    val colors= listOf(MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.colorScheme.errorContainer)

    LazyColumn(content = {

        items(quotes.size){ i->
            ItemQuote(quote = quotes[i],onClick,colors[i % colors.size])
        }
    })
}
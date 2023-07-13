package com.example.quotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotesapp.models.Quote

@Preview
@Composable
fun Trying() {
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Quotes App",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center

        )
    }
}

@Composable
fun QuoteListScreen(quotes: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "QUOTES APP",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        
        )
        Spacer(modifier = Modifier.height(10.dp))

        QuoteList(quotes = quotes, onClick)
    }
}

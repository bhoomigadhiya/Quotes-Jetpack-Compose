package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import com.example.quotesapp.screens.QuoteDetailsScreen
import com.example.quotesapp.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //for better performance, use coroutine
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
            MyApp()
        }
    }


}


@Composable
fun MyApp() {
    if (DataManager.isDataLoaded.value) {
        //we are fetching data on main thread but it is safe because we have used state and State is thread free.
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(quotes = DataManager.data) {
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetailsScreen(quote = it) }
        }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(text = "Loading...", style = MaterialTheme.typography.headlineMedium)
        }
    }
}

//to handle navigation
enum class Pages {
    LISTING,
    DETAIL
}

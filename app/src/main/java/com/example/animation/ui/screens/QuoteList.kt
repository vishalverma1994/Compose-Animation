package com.example.animation.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.animation.domain.model.Quote

@Composable
fun QuoteList(quoteList: List<Quote>, onItemClick: (quote: Quote) -> Unit) {

    LazyColumn {
        items(quoteList) { quote ->
            QuoteListItem(quote = quote, onItemClick = onItemClick)
        }
    }
}
package com.example.animation.domain.manager

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.animation.domain.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DataManager {

    var quotesData = mutableStateOf(emptyList<Quote>())
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: Quote? = null

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val type: Type = object : TypeToken<List<Quote>>() {}.type
        isDataLoaded.value = true
        quotesData.value = gson.fromJson(json, type)
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else currentPage.value = Pages.LISTING
    }
}
package com.example.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.models.Quote
import com.google.gson.Gson

//to read and maintain Data
object DataManager {
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote :Quote?=null


    fun switchPages(quote: Quote?=null){
        if(currentPage.value == Pages.LISTING){
            currentQuote=quote
            currentPage.value=Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }

    fun loadAssetsFromFile(context: Context) {
        val inputStream =  context.assets.open("quotes.json")
        val size=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json= String(buffer,Charsets.UTF_8)
        val gson= Gson()
        data=gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value=true
    }
}
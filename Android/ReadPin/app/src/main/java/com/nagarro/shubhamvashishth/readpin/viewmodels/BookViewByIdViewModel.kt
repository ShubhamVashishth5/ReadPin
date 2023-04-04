package com.nagarro.shubhamvashishth.readpin.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nagarro.shubhamvashishth.readpin.constants.DEBUG_LOG
import com.nagarro.shubhamvashishth.readpin.model.trending.Book
import com.nagarro.shubhamvashishth.readpin.repository.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewByIdViewModel : ViewModel() {
    val repository= DataRepository()

    private var _book = MutableStateFlow<Book?>(null);
    var book: StateFlow<Book?> = _book

    fun loadBook(olId:String){
        viewModelScope.launch {
            var responseBook=repository.getBookById(olId)
            var unparsedBook= responseBook.await()

            Log.d(DEBUG_LOG, unparsedBook!!.description.toString())

            var parsedDescription=  unparsedBook!!.description.toString().removeRange(1..17)
            parsedDescription=parsedDescription.replace("\"","\\\"")
            parsedDescription= parsedDescription.replaceRange(7,7,"\"")
                .replaceRange(parsedDescription.length,parsedDescription.length,"\"")

            Log.d(DEBUG_LOG, parsedDescription)

            var ddesc = if(unparsedBook!!.description is String){
                 unparsedBook!!.description as String
            } else {
                val gson = Gson()
                val pojo: Description = gson.fromJson(
                    parsedDescription
                    , Description::class.java)
                pojo.value
            }
            unparsedBook.actualDescription=ddesc
            unparsedBook.description=ddesc
            Log.d(DEBUG_LOG,  ddesc)
            _book.value=unparsedBook


        }

    }

    inner class Description(var value:String)


}
package com.nagarro.shubhamvashishth.readpin.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nagarro.shubhamvashishth.readpin.constants.NETWORK_LOG
import com.nagarro.shubhamvashishth.readpin.constants.VALUE_CHECK_LOG
import com.nagarro.shubhamvashishth.readpin.model.Book
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
            var responseBook=repository.getBookByIdAsync(olId)
            var unparsedBook= responseBook.await()
            if (unparsedBook!!.description==null){
                unparsedBook!!.description="No description available"
            }
            var parsedDescription:String=""

            unparsedBook?.let { book ->
                book.description?.let {
                    if(it!="No description available") {
                        parsedDescription = it.toString().removeRange(1..17)
                        parsedDescription = parsedDescription.replace("\"", "\\\"")
                        parsedDescription = parsedDescription.replaceRange(7, 7, "\"")
                            .replaceRange(parsedDescription.length, parsedDescription.length, "\"")
                    }

                    Log.d(VALUE_CHECK_LOG, parsedDescription.toString())

                    var actualDescription = if(book.description is String){
                        book.description as String
                    } else {
                        val gson = Gson()
                        val pojo: Description = gson.fromJson(
                            parsedDescription
                            , Description::class.java)
                        pojo.value
                    }
                    book.actualDescription=actualDescription
                    book.description=actualDescription
                    Log.d(NETWORK_LOG,  actualDescription)
                    repository.getAuthorByIdAsync(book.
                    authors.first().author.key.substringAfterLast('/')).await()?.let {author->
                        book.author=author
                    }

                    _book.value=book


            }

            }


        }

    }

    fun loadAuthorDetails(){

    }

    inner class Description(var value:String)


}
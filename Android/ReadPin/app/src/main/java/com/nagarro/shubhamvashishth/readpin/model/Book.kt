package com.nagarro.shubhamvashishth.readpin.model


data class Book(
    var description: Any,
    val title: String,
    val covers: List<Int>,
    val subject_places:List<String>,
    val subjects: List<String>,
    val subject_people : List<String>,
    val key: String,
    var actualDescription:String,
    val authors: List<Authors>,
    var author:Author
                ) {

    inner class Authors(val author: BookAuthor, val type: Type)
    inner class BookAuthor(val key: String)
    inner class Type(val key:String)

}


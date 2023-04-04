package com.nagarro.shubhamvashishth.readpin.model.trending


data class Book(
    var description: Any,
    val title: String,
    val covers: List<Int>,
    val subject_places:List<String>,
    val subjects: List<String>,
    val subject_people : List<String>,
    val key: String,
    var actualDescription:String
                ) {
}
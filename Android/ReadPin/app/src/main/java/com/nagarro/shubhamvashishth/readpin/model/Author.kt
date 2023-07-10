package com.nagarro.shubhamvashishth.readpin.model

data class Author(val personal_name:String,
                  val key:String,
                  val alternate_names:List<String>,
                  val name:String,
                  val title:String,
                  val birth_date: String,
                  val photos:List<Int>) {
}
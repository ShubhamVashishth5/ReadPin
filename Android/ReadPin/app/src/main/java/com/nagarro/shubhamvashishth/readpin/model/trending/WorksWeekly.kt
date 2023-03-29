package com.nagarro.shubhamvashishth.readpin.model.trending

data class WorksWeekly (val key: String,
                        val title: String,
                        val author_name: List<String>,
                        val author_key: List<String>,
                        val edition_count:Int,
                        val cover_edition_key:String) {
}
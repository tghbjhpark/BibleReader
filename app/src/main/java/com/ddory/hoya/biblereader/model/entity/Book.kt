package com.ddory.hoya.biblereader.model.entity

data class Book(
    val name: String,
    val testament: Testament,
//    val category:
    val total: Int,
    val read: IntArray
)

enum class Testament {
    OLD, NEW
}

//enum class Category(value: String) {
//    MOSE()
//}

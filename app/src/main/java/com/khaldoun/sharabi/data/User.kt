package com.khaldoun.sharabi.data

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    var imagePath: String = "" //profile picture
){
    constructor():this("", "", "", "")
}

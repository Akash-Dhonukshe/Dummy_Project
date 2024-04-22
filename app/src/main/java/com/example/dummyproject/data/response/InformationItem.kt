package com.example.dummyproject.data.response

data class InformationItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
    var isExpanded : Boolean = false
)
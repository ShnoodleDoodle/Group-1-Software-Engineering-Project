package com.example.projectElderWatch

data class User(
    val id: Int,
    val username: String,
    val password: String,
    val roleId: Int,
    val email: String
) {
    fun getEmail(): String {
        return email
    }

    fun getUsername(): String {
        return username
    }
}


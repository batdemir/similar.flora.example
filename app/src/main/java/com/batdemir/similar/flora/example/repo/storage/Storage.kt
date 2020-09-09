package com.batdemir.similar.flora.example.repo.storage

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String
}

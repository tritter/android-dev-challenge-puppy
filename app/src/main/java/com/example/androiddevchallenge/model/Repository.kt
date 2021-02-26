package com.example.androiddevchallenge.model

object Repository {
    fun all(): List<Dog> = dogs
    fun get(name: String)  = all().find { it.name == name }
}
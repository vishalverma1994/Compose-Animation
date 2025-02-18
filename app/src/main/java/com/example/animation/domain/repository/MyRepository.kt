package com.example.animation.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}
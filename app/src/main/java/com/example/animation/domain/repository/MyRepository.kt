package com.example.animation.domain.repository

import com.example.animation.domain.model.Quote

interface MyRepository {
    suspend fun doNetworkCall()
}
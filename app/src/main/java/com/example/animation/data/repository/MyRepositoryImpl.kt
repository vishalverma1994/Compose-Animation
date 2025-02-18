package com.example.animation.data.repository

import com.example.animation.data.remote.MyAPI
import com.example.animation.domain.repository.MyRepository

class MyRepositoryImpl(private val api: MyAPI): MyRepository {
    override suspend fun doNetworkCall() {

    }
}
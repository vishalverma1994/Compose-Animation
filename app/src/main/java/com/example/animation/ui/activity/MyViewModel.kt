package com.example.animation.ui.activity

import androidx.lifecycle.ViewModel
import com.example.animation.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: MyRepository): ViewModel() {

}
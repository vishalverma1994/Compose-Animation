package com.example.animation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewModelScope
import com.example.animation.domain.manager.DataManager
import com.example.animation.domain.manager.Pages
import com.example.animation.ui.screens.QuoteListScreen
import com.example.animation.ui.screens.QuotesDetail
import com.example.animation.ui.theme.MyAnimationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val myViewModel: MyViewModel by viewModels()
    private val dataManager: DataManager by lazy {
        DataManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myViewModel.viewModelScope.launch(Dispatchers.IO) {
            dataManager.loadAssetsFromFile(this@MainActivity)
        }
        setContent {
            MyAnimationTheme {
                LaunchApp()
            }
        }
    }

    @Composable
    fun LaunchApp() {
        if (dataManager.isDataLoaded.value) {
            if (dataManager.currentPage.value == Pages.LISTING) {
                QuoteListScreen(quoteList = dataManager.quotesData.value) {
                    dataManager.switchPages(it)
                }
            } else {
                dataManager.currentQuote?.let { QuotesDetail(quote = it, dataManager) }
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(1f)
            ) {
                Text(
                    text = "Loading....",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }

}
package io.aaronspooky.daggercomponents.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.aaronspooky.network.domain.usecase.FetchPostsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchPostsUseCase: FetchPostsUseCase
) : ViewModel() {

    /** */
    fun fetchPosts() = flow<String> {
        emit("Loading...")
        emit(fetchPostsUseCase.invoke())
    }.asLiveData(Dispatchers.IO)
}
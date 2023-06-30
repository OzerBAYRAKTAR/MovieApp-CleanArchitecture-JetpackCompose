package com.bayraktar.movieappcompose.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayraktar.movieappcompose.domain.use_case.movie_detail.getMoviesDetailCase
import com.bayraktar.movieappcompose.util.Constants.IMDB_ID
import com.bayraktar.movieappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val case: getMoviesDetailCase,
    private val stateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state

    init {
        //savedStateHandle comes with Compose. To take state of viewmodel when viewmodel instance created,
        //when moviedetailViewmodel created init works. we take IMDB_DB value with statehandle and pass it to the getMovieDetail()
        //if some value passed with route in main activities while tryng to navigate between screens.
        stateHandle.get<String>(IMDB_ID)?.let {id ->
            getMovieDetail(id)
        }
    }

    private fun getMovieDetail(imdbID: String) {
        case.invoke(imdbID).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = it.data)
                }
                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error")
                }

            }
        }.launchIn(viewModelScope)
    }
}
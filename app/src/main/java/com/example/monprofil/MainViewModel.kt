package com.example.monprofil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    /**var compteur by MutableStateOf(0)

    fun incrementer_compteur() {
        compteur = compteur + 1
    }**/
    val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build();

    val api = retrofit.create(Api::class.java)

    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val series=MutableStateFlow<List<TmdbTv>>(listOf())
    val acteurs= MutableStateFlow<List<TmdbActor>>(listOf())
    val movie= MutableStateFlow<TmdbMovieDetail>(TmdbMovieDetail())
    val serie= MutableStateFlow<TmdbTvDetail>(TmdbTvDetail())
    val acteur= MutableStateFlow<TmdbPersonDetail>(TmdbPersonDetail())


    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies("73fbeeb046f41168a80509da0ee03c8c").results
        }
    }
    fun getSeries() {
        viewModelScope.launch {
            series.value = api.lasttv("73fbeeb046f41168a80509da0ee03c8c").results
        }
    }

    fun getActeurs() {
        viewModelScope.launch {
            acteurs.value = api.lastperson("73fbeeb046f41168a80509da0ee03c8c").results
        }
    }

    fun getDetailMovie(id:String) {
        viewModelScope.launch {
            movie.value = api.movie(id,"73fbeeb046f41168a80509da0ee03c8c")
        }
    }

    fun getDetailTv(id:String) {
        viewModelScope.launch {
            serie.value = api.tv(id,"73fbeeb046f41168a80509da0ee03c8c")
        }
    }

    fun getDetailActeur(id:String) {
        viewModelScope.launch {
            acteur.value = api.person(id,"73fbeeb046f41168a80509da0ee03c8c")
        }
    }

}

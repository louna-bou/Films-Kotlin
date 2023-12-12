package com.example.monprofil

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult

    @GET("trending/tv/week")
    suspend fun lasttv(@Query("api_key") api_key: String): TmdbTvResult

    @GET("trending/person/week")
    suspend fun lastperson(@Query("api_key") api_key: String): TmdbActorResult

    @GET("movie/{id}?append_to_response=credits")
    suspend fun movie(@Path("id") id:String, @Query("api_key") api_key: String): TmdbMovieDetail
}
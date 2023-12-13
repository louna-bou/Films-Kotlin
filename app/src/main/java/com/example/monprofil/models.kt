package com.example.monprofil

data class TmdbMovieResult(
    val page: Int = 0,
    val results: List<TmdbMovie> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

data class TmdbMovie(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val media_type: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)


data class TmdbTvResult(
    val page: Int = 0,
    val results: List<TmdbTv> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

data class TmdbTv(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val first_air_date: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val media_type: String = "",
    val name: String = "",
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_name: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)


data class TmdbActorResult(
    val page: Int = 0,
    val results: List<TmdbActor> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

data class TmdbActor(
    val adult: Boolean = false,
    val gender: Int = 0,
    val id: Int = 0,
    val known_for: List<KnownFor> = listOf(),
    val known_for_department: String = "",
    val media_type: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

data class KnownFor(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val first_air_date: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val media_type: String = "",
    val name: String = "",
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_name: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

// Detail d'un film
data class TmdbMovieDetail(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val belongs_to_collection: Any = Any(),
    val budget: Int = 0,
    val credits: CreditsFilm = CreditsFilm(),
    val genres: List<GenreFilm> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val production_companies: List<ProductionCompanyFilm> = listOf(),
    val production_countries: List<ProductionCountryFilm> = listOf(),
    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spoken_languages: List<SpokenLanguageFilm> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class CreditsFilm(
    val cast: List<CastFilm> = listOf(),
    val crew: List<CrewFilm> = listOf()
)

data class GenreFilm(
    val id: Int = 0,
    val name: String = ""
)

data class ProductionCompanyFilm(
    val id: Int = 0,
    val logo_path: String = "",
    val name: String = "",
    val origin_country: String = ""
)

data class ProductionCountryFilm(
    val iso_3166_1: String = "",
    val name: String = ""
)

data class SpokenLanguageFilm(
    val english_name: String = "",
    val iso_639_1: String = "",
    val name: String = ""
)

data class CastFilm(
    val adult: Boolean = false,
    val cast_id: Int = 0,
    val character: String = "",
    val credit_id: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val known_for_department: String = "",
    val name: String = "",
    val order: Int = 0,
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

data class CrewFilm(
    val adult: Boolean = false,
    val credit_id: String = "",
    val department: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val job: String = "",
    val known_for_department: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

data class TmdbPersonDetail(
    val adult: Boolean = false,
    val also_known_as: List<String> = listOf(),
    val biography: String = "",
    val birthday: String = "",
    val credits: Credits = Credits(),
    val deathday: Any = Any(),
    val gender: Int = 0,
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val known_for_department: String = "",
    val name: String = "",
    val place_of_birth: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

data class Credits(
    val cast: List<CastPerson> = listOf(),
    val crew: List<CrewPerson> = listOf()
)

data class CastPerson(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val character: String = "",
    val credit_id: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val order: Int = 0,
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class CrewPerson(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val credit_id: String = "",
    val department: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val job: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class TmdbTvDetail(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val created_by: List<CreatedBy> = listOf(),
    val credits: CreditsTv = CreditsTv(),
    val episode_run_time: List<Any> = listOf(),
    val first_air_date: String = "",
    val genres: List<GenreTv> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val in_production: Boolean = false,
    val languages: List<String> = listOf(),
    val last_air_date: String = "",
    val last_episode_to_air: LastEpisodeToAir = LastEpisodeToAir(),
    val name: String = "",
    val networks: List<Network> = listOf(),
    val next_episode_to_air: Any = Any(),
    val number_of_episodes: Int = 0,
    val number_of_seasons: Int = 0,
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_name: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val production_companies: List<ProductionCompany> = listOf(),
    val production_countries: List<ProductionCountry> = listOf(),
    val seasons: List<Season> = listOf(),
    val spoken_languages: List<SpokenLanguageTv> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val type: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class CreatedBy(
    val credit_id: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val profile_path: String = ""
)

data class CreditsTv(
    val cast: List<CastTv> = listOf(),
    val crew: List<CrewTv> = listOf()
)

data class GenreTv(
    val id: Int = 0,
    val name: String = ""
)

data class LastEpisodeToAir(
    val air_date: String = "",
    val episode_number: Int = 0,
    val episode_type: String = "",
    val id: Int = 0,
    val name: String = "",
    val overview: String = "",
    val production_code: String = "",
    val runtime: Int = 0,
    val season_number: Int = 0,
    val show_id: Int = 0,
    val still_path: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class Network(
    val id: Int = 0,
    val logo_path: String = "",
    val name: String = "",
    val origin_country: String = ""
)

data class ProductionCompany(
    val id: Int = 0,
    val logo_path: String = "",
    val name: String = "",
    val origin_country: String = ""
)

data class ProductionCountry(
    val iso_3166_1: String = "",
    val name: String = ""
)

data class Season(
    val air_date: String = "",
    val episode_count: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val overview: String = "",
    val poster_path: String = "",
    val season_number: Int = 0,
    val vote_average: Double = 0.0
)

data class SpokenLanguageTv(
    val english_name: String = "",
    val iso_639_1: String = "",
    val name: String = ""
)

data class CastTv(
    val adult: Boolean = false,
    val character: String = "",
    val credit_id: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val known_for_department: String = "",
    val name: String = "",
    val order: Int = 0,
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)

data class CrewTv(
    val adult: Boolean = false,
    val credit_id: String = "",
    val department: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val job: String = "",
    val known_for_department: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)
package coroutines.exam.lesson1

import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubServiceApi {
    @GET("users/{login}")
    suspend fun getUser(@Path("login") login: String): User
}

data class User(val id: String, val name: String, val url: String)
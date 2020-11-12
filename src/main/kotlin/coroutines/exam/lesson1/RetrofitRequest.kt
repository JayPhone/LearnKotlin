package coroutines.exam.lesson1

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main() {
    val gitHubServiceApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        retrofit.create(GitHubServiceApi::class.java)
    }

    GlobalScope.launch() {
        try {
            showUser(gitHubServiceApi.getUser("JayPhone"))
        } catch (e: Exception) {
            println("发生了错误，${e.message}")
        }
    }
    Thread.sleep(2000)


}

fun showUser(user: User) {
    println("user id:${user.id} name:${user.name} url:${user.url}")
}
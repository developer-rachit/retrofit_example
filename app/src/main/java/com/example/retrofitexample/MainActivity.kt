package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofitexample.data.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = RetrofitClient.apiService
        val call = apiService.getPosts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    if (posts != null) {
                        // Handle the list of posts
                        for (post in posts) {
                            Log.d("Post", "Title: ${post.title}, Body: ${post.body}")
                        }
                    }
                } else {
                    // Handle error
                    Log.e("API Error", "Response not successful.")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // Handle network error
                Log.e("Network Error", t.message ?: "Unknown error")
            }
        })
    }
}

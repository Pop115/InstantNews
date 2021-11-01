package fr.kienanbachwa.instantnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.kienanbachwa.instantnews.data.services.RetrofitBuilder
import fr.kienanbachwa.instantnews.databinding.ActivityMainBinding
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var retrofitSingleton: Retrofit//retrofit singleton instance, used to call other services in the application
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofitSingleton = RetrofitBuilder.createRetrofitInstance(this)
    }

}
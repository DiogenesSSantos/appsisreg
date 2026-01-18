package com.github.diogenessantos.appsisreg.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitInstance {

    companion object {
        var retrofitInstance : Retrofit? = null
        val  url = "http://sisreg.devdiogenes.shop/"

        fun getInstaceRetrofit() : Retrofit {
            if (retrofitInstance == null) {
                return Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(
                        GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
            }
             return retrofitInstance!!
        }
    }
}
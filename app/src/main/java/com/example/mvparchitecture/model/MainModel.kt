package com.example.mvparchitecture.model

import com.example.mvparchitecture.constracts.MainActivityContract
import com.example.mvparchitecture.network.api.ApiService

class MainModel(private val apiService: ApiService): MainActivityContract.Model {

    override suspend fun fetchUniversity(
        onFinishListener: MainActivityContract.Model.OnFinishListener,
        country: String
    ) {

        onFinishListener.onLoading()

        try {

            val response = apiService.getUniversity(country)
            if(response.isSuccessful){
                response.body()?.let {
                    onFinishListener.onSuccess(it)
                }
            } else {
                onFinishListener.onError(response.errorBody().toString())
            }

        } catch (e: Exception) {
            onFinishListener.onError(message = e.message.toString())
        }
    }
}
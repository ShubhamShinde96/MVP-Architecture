package com.example.mvparchitecture.presenter

import com.example.mvparchitecture.constracts.MainActivityContract
import com.example.mvparchitecture.network.model.University
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPresenter(
    private val view: MainActivityContract.View,
    private val model: MainActivityContract.Model
) : MainActivityContract.Presenter, MainActivityContract.Model.OnFinishListener {

    // The role of presenter is to take the data from model and update that data onto view

    val scope = CoroutineScope(Dispatchers.IO)

    override fun getUniversity(country: String) {
        scope.launch {
            model.fetchUniversity(this@MainPresenter, country = country)
        }
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(list: List<University>) {
        TODO("Not yet implemented")
    }
}
package com.example.mvparchitecture.constracts

import com.example.mvparchitecture.network.model.University

interface MainActivityContract {

    interface View {
        fun onLoading()
        fun onSuccess(list: List<University>)
        fun onError(message: String)
    }

    interface Presenter {
        fun getUniversity(country: String)
        fun onDestroy()
    }

    interface Model {

        interface OnFinishListener {
            fun onLoading()
            fun onError(message: String)
            fun onSuccess(list: List<University>)
        }

        suspend fun fetchUniversity(onFinishListener: OnFinishListener, country: String)
    }

}
package com.example.mvparchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import com.example.mvparchitecture.adapters.MainRvAdapter
import com.example.mvparchitecture.constracts.MainActivityContract
import com.example.mvparchitecture.databinding.ActivityMainBinding
import com.example.mvparchitecture.model.MainModel
import com.example.mvparchitecture.network.api.ApiService
import com.example.mvparchitecture.network.model.University
import com.example.mvparchitecture.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var presenter: MainPresenter

    @Inject
    lateinit var apiService: ApiService

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
    get() = _binding!!

    private val mainAdapter: MainRvAdapter = MainRvAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this, MainModel(apiService))

        initView()

        binding.searchView.setOnQueryTextListener(object: OnQueryTextListener {

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.getUniversity(newText.toString())
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
        })
    }

    private fun initView() {

        binding.rvUniversityList.adapter = mainAdapter
    }

    override fun onLoading() {
        binding.progressMain.visibility = View.VISIBLE
    }

    override fun onSuccess(list: List<University>) {
        binding.progressMain.visibility = View.GONE
        mainAdapter.addItem(list)
    }

    override fun onError(message: String) {
        binding.progressMain.visibility = View.GONE
        Toast.makeText(this@MainActivity, "Error: $message", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
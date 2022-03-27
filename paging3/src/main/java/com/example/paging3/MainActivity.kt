package com.example.paging3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3.adapter.FooterAdapter
import com.example.paging3.adapter.PagingAdapter
import com.example.paging3.viewmodel.GithubServiceViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val myViewModel: GithubServiceViewModel by viewModels()
    private val repoAdapter by lazy {
        PagingAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = this.findViewById<RecyclerView>(R.id.rv_test)
        val progressBar = this.findViewById<ProgressBar>(R.id.progress_bar)
        recyclerView.adapter = repoAdapter.withLoadStateFooter(FooterAdapter {
            repoAdapter.retry()
        })

        val githubServiceFlow = myViewModel.getGithubServiceData()
        lifecycleScope.launch {
            githubServiceFlow.collect {
                repoAdapter.submitData(it)
            }
        }

        repoAdapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    progressBar.visibility = View.INVISIBLE
                    recyclerView.visibility = View.VISIBLE
                }

                is LoadState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.INVISIBLE
                }

                is LoadState.Error -> {
                    val state = it.refresh as LoadState.Error
                    progressBar.visibility = View.INVISIBLE
                    Log.d("xfwa", "errorMsg: ${state.error.message}")
                    Toast.makeText(this, "Load Error: ${state.error.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }

}
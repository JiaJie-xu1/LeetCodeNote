package com.univers.paging3

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.univers.leetcodenote.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TestPaging3Activity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val testPaging3Adapter = TestPaging3Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_paging)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = testPaging3Adapter.withLoadStateFooter(FooterAdapter {
            testPaging3Adapter.retry()
        })
        lifecycleScope.launch {
            viewModel.getPagingData().collect { pagingData ->
                testPaging3Adapter.submitData(pagingData)
            }
        }

        testPaging3Adapter.addLoadStateListener {
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
                    Toast.makeText(this, "Load Error: ${state.error.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
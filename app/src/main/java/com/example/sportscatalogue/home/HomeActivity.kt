package com.example.sportscatalogue.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportscatalogue.R
import com.example.core.data.Resource
import com.example.core.ui.SportAdapter
import com.example.sportscatalogue.detail.DetailSportActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sportAdapter = SportAdapter()
        sportAdapter.onItemClick = { selectedData->
            val intent = Intent(this, DetailSportActivity::class.java)
            intent.putExtra(DetailSportActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        homeViewModel.sport.observe(this, Observer { sport ->
            if (sport != null) {
                when (sport) {
                    is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        progress_bar.visibility = View.GONE
                        sportAdapter.setData(sport.data)
                    }
                    is Resource.Error -> {
                        progress_bar.visibility = View.GONE
                        Toast.makeText(this,"Fail to load data", Toast.LENGTH_SHORT ).show()
                    }
                }
            }
        })
        with(rv_sports) {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            setHasFixedSize(true)
            adapter = sportAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite_user_list -> {
                val uri = Uri.parse("sportscatalogue://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
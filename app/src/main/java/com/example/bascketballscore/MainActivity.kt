package com.example.bascketballscore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bascketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        print("Start application")

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainViewModel = viewModel

        viewModel.resultLocal.observe(this, Observer {
            resultLocalValue ->
            binding.resultLocal.text = resultLocalValue.toString()
        })

        viewModel.resultVisit.observe(this, Observer {
            resultVisitValue ->
            binding.resultVisits.text = resultVisitValue.toString()
        })

        binding.goDetailActivity.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(ResultActivity.RESULT_LOCAL, viewModel.resultLocal.value.toString())
            intent.putExtra(ResultActivity.RESULT_VISIT, viewModel.resultVisit.value.toString())

            startActivity(intent)
        }
    }
}
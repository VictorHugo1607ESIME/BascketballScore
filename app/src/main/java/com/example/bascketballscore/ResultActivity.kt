package com.example.bascketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bascketballscore.databinding.ActivityResult2Binding

class ResultActivity : AppCompatActivity() {

    companion object{
        const val RESULT_LOCAL = "Local"
        const val  RESULT_VISIT = "Visitantes"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResult2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val results = intent.extras!!

        val resultLocal = results.getString(RESULT_LOCAL)!!
        val resultVisits = results.getString(RESULT_VISIT)!!

        val resultado = "$resultLocal - $resultVisits"
        binding.results.text = resultado

        binding.resultDescription.text = when{
            resultLocal.toInt() > resultVisits.toInt() -> getString(R.string.localWin)
            resultLocal.toInt() < resultVisits.toInt() -> getString(R.string.visitorsWin)
            resultLocal.toInt() == resultVisits.toInt() -> getString(R.string.tie)
            else -> getString(R.string.WR)
        }
    }
}
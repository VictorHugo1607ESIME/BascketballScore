package com.example.bascketballscore

import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var _resultLocal:MutableLiveData<Int> = MutableLiveData()
    var _resultVisit:MutableLiveData<Int> = MutableLiveData()
    internal val toastMessage = SingleLiveEvent<Int>()

    val resultLocal : LiveData<Int>
        get() = _resultLocal

    val resultVisit : LiveData<Int>
        get() = _resultVisit

    init {
        reset()
    }

    fun reset(){
        _resultLocal.value = 0
        _resultVisit.value = 0
    }

    fun minus(n:Int, team:Boolean){
        if(team){
            if(resultLocal.value!! > 0)
                _resultLocal.value = _resultLocal.value?.minus(1)

        }else{
            if(resultVisit.value!! > 0)
                _resultVisit.value = _resultVisit.value?.minus(1)
        }
    }

    fun plus(n: Int, team: Boolean){
        if(team)
           _resultLocal.value = _resultLocal.value?.plus(n)
        else
            _resultVisit.value = _resultVisit.value?.plus(n)
    }

}
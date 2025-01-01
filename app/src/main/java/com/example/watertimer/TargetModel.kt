package com.example.watertimer

data class TargetModel( var target: Int = 0 )

class TargetRepository{
    private val _target = TargetModel(0)

    fun getTarget(): Int{
        return _target.target
    }

    fun addTargetValue(addedValue: Int){
        _target.target += addedValue
    }

    fun reduceTargetValue(reducedValue: Int){
        _target.target -= reducedValue
    }
}
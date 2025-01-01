package com.example.watertimer

data class ConsumedModel( var consumed: Int = 0 )

class ConsumedRepository{
    private val _consumed = ConsumedModel(0)

    fun getConsumed(): Int{
        return _consumed.consumed
    }

    fun addConsumedValue(addedValue: Int){
        _consumed.consumed += addedValue
    }

    fun reduceConsumedValue(reducedValue: Int){
        _consumed.consumed -= reducedValue
    }
}
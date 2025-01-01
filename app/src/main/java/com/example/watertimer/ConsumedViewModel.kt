package com.example.watertimer

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel


class ConsumedViewModel: ViewModel() {

    // make an object of model
    private val _consumedRepository = ConsumedRepository()

    // make a private counter
    private var _consumed = mutableIntStateOf(_consumedRepository.getConsumed())

    var consumed: MutableIntState = _consumed;

    fun getConsumedValue(): Int {
        return _consumed.intValue;
    }

    fun addValue(value: Int) {
        _consumedRepository.addConsumedValue(value)
        _consumed.intValue = _consumedRepository.getConsumed()
    }

    fun reduceValue(value: Int) {
        _consumedRepository.reduceConsumedValue(value)
        _consumed.intValue = _consumedRepository.getConsumed()
    }
}
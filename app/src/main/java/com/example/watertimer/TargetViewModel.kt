package com.example.watertimer

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class TargetViewModel: ViewModel() {
    private val _targetRepository = TargetRepository()
    private var _target = mutableIntStateOf(_targetRepository.getTarget())

    fun getTarget(): Int {
        return _target.intValue;
    }

    fun addValue(value: Int) {
        _targetRepository.addTargetValue(value)
        _target.intValue = _targetRepository.getTarget()
    }

    fun reduceValue(value: Int) {
        _targetRepository.reduceTargetValue(value)
        _target.intValue = _targetRepository.getTarget()
    }
}
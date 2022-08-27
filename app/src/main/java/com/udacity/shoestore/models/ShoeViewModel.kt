package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf()
    }

    private fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        _shoeList.value!!.add(shoe)
    }

    fun addNewShoe(name: String, size: Double, company: String, description: String): Boolean {
        if (!validateInputNewShoe(name, size, company, description))
            return false
        addShoe(name, size, company, description)
        return true
    }

    private fun validateInputNewShoe(name: String, size: Double, company: String, description: String): Boolean {

        if (name.isBlank() ||
            size < 0 ||
            company.isBlank() ||
            description.isBlank()
        ) {
            return false
        }
        return true
    }
}
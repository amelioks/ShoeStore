package com.udacity.shoestore.models

import android.provider.Settings.Global.getString
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String>
        get() = _shoeName

    private val _shoeSize = MutableLiveData<String>()
    val shoeSize: LiveData<String>
        get() = _shoeSize

    private val _shoeCompany = MutableLiveData<String>()
    val shoeCompany: LiveData<String>
        get() = _shoeCompany

    private val _shoeDescription = MutableLiveData<String>()
    val shoeDescription: LiveData<String>
        get() = _shoeDescription

    init {
        _shoeList.value = mutableListOf()
    }

    private fun addShoe() {
        val shoe = Shoe(shoeName.value?:"", shoeSize.value?.toDouble()?: -1.0,
            shoeCompany.value?:"", shoeDescription.value?:"")
        _shoeList.value!!.add(shoe)
    }

    fun addNewShoe(): Boolean {
        if (!validateInputNewShoe())
            return false
        addShoe()
        return true
    }

    private fun validateInputNewShoe(): Boolean {

        if (shoeName.value.isNullOrBlank() ||
            shoeSize.value.isNullOrBlank() ||
            shoeCompany.value.isNullOrBlank()||
            shoeDescription.value.isNullOrBlank()
        ) {
            return false
        }
        return true
    }
}
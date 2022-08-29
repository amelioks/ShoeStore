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
    val shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeName = MutableLiveData<String>()

    val shoeSize = MutableLiveData<String>()

    val shoeCompany = MutableLiveData<String>()

    val shoeDescription = MutableLiveData<String>()


    init {
        shoeList.value = mutableListOf()
    }

    private fun addShoe() {
        val shoe = Shoe(shoeName.value?:"", shoeSize.value?.toDouble()?: -1.0,
            shoeCompany.value?:"", shoeDescription.value?:"")
        shoeList.value!!.add(shoe)
    }

    fun resetInput() {
        shoeName.value = ""
        shoeSize.value = ""
        shoeCompany.value = ""
        shoeDescription.value = ""
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
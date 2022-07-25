package com.example.shoestore_starter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_starter.modeks.Shoe


class ShoesList : ViewModel() {

    var name: String = ""
    var company: String = ""
    var size: String = ""
    var description: String = ""

    private val _listOfShoes = MutableLiveData<MutableList<Shoe>>()

    val listOfShoes: MutableLiveData<MutableList<Shoe>>
        get() = _listOfShoes

    fun addShoe() {
        _listOfShoes.value?.add(Shoe(name,size,company,description))
        _listOfShoes.notifyObserver()
    }

    fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}

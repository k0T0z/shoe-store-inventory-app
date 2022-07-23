package com.example.shoestore_starter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_starter.modeks.Shoe


class ShoesList : ViewModel() {
    private val _listOfShoes = MutableLiveData<MutableList<Shoe>>()

    init {
        _listOfShoes.value?.add(Shoe("g3", 39.0,"adidas","sport shoe",))
    }

    val listOfShoes: MutableLiveData<MutableList<Shoe>>
        get() = _listOfShoes

    fun addShoe(name: String, size: Double, company: String, description: String) {
        _listOfShoes.value?.add(
            Shoe(name, size, company, description,)
        )
    }

}

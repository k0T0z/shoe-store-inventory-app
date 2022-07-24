package com.example.shoestore_starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestore_starter.databinding.FragmentShoeListViewBinding


class ShoeListViewFragment : Fragment() {

    private lateinit var viewModel: ShoesList

    private lateinit var binding: FragmentShoeListViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list_view, container, false
        )
        binding.floatingActionButtonId.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListViewFragment_to_shoeDetailsFragment)
        )
        viewModel = ViewModelProvider(this)[ShoesList::class.java]
        viewModel.listOfShoes.observe(viewLifecycleOwner, Observer { newListOfShoes ->
            binding.viewModel!!.listOfShoes.value = newListOfShoes
        })
        return binding.root
    }
}
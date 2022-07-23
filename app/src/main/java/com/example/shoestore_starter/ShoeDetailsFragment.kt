package com.example.shoestore_starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestore_starter.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false)
        binding.detailScreenCancelButtonId.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailsFragment_pop_including_shoeListViewFragment)
        )
        binding.detailScreenSaveButtonId.setOnClickListener { view: View ->
            val name: String = binding.shoeNameInputTextId.text.toString()
            val size: String = binding.shoeSizeInputTextId.text.toString()
            val company: String = binding.shoeCompanyInputTextId.text.toString()
            val description: String = binding.shoeDescriptionInputTextId.text.toString()

            binding.viewModel!!.addShoe(name, size.toDouble(), company,description)
            view.findNavController().navigate(R.id.action_shoeDetailsFragment_pop_including_shoeListViewFragment)

//            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailsFragment_pop_including_shoeListViewFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}
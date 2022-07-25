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
import com.example.shoestore_starter.modeks.Shoe

class ShoeDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false
        )
        binding.detailScreenCancelButtonId.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentPopIncludingShoeListViewFragment())
        )
        binding.detailScreenSaveButtonId.setOnClickListener { view: View ->
            ShoeListViewFragment.Obj.name = binding.shoeNameInputTextId.text.toString()
            ShoeListViewFragment.Obj.size = binding.shoeSizeInputTextId.text.toString()
            ShoeListViewFragment.Obj.company = binding.shoeCompanyInputTextId.text.toString()
            ShoeListViewFragment.Obj.description =
                binding.shoeDescriptionInputTextId.text.toString()

            ShoeListViewFragment.Obj.viewModel.addShoe()

            view.findNavController()
                .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentPopIncludingShoeListViewFragment())
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}
package com.example.shoestore_starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestore_starter.databinding.FragmentLoginBinding
import com.example.shoestore_starter.databinding.FragmentOnBoardingInstructionsBinding

class OnBoardingInstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentOnBoardingInstructionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_on_boarding_instructions, container, false)
        binding.onBoardingInstructionsButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_onBoardingInstructionsFragment_to_shoeListViewFragment)
        )
        return binding.root
    }
}
package com.example.shoestore_starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestore_starter.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //The complete onClickListener with Navigation
        val binding: FragmentOnBoardingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_on_boarding, container, false)
        binding.onBoardingButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(OnBoardingFragmentDirections.actionOnBoardingFragmentToOnBoardingInstructionsFragment())
        )
        return binding.root
    }
}
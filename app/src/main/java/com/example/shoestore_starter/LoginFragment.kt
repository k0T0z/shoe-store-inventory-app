package com.example.shoestore_starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestore_starter.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)
        binding.loginButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment())
        )
        binding.registerButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment())
        )
        return binding.root
    }
}
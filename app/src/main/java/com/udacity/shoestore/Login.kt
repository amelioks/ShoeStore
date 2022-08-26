package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_login, container, false)

        binding.buttonLogin.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_login_to_welcome))

        binding.buttonSignup.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_login_to_welcome))
        return binding.root

    }
}
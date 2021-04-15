package com.femiras.framework.mvvm.ui.spalash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.FragmentLoginBinding
import com.femiras.framework.mvvm.databinding.FragmentSignInBinding
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.backToTransactionButton.setOnClickListener{
            if (findNavController().currentDestination?.id != R.id.otpFragment && findNavController().currentDestination?.id == R.id.loginFragment) {
                findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToOtpFragment(

                        )
                )
            }


        }
        return binding.root
    }
}
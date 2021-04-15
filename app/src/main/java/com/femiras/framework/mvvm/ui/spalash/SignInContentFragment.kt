package com.femiras.framework.mvvm.ui.spalash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.fragment_login.*


class SignInContentFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        backToTransactionButton.setOnClickListener{
            if (findNavController().currentDestination?.id != R.id.loginFragment && findNavController().currentDestination?.id == R.id.signInContentFragment) {
                findNavController().navigate(
                        SignInContentFragmentDirections.actionSignInContentFragmentToLoginFragment(

                        )
                )
            }


        }
    }

}
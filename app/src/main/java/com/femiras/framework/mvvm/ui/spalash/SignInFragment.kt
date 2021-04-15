package com.femiras.framework.mvvm.ui.spalash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    // TODO: Rename and change types of parameters
    companion object {
        @JvmStatic
        fun newInstance() =
            SignInFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        val binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }
}
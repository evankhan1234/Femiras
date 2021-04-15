package com.femiras.framework.mvvm.ui.spalash


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.FragmentSplashScreenBinding
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.femiras.framework.mvvm.extension.onTransitionCompletedListener
import kotlinx.coroutines.launch

class SplashScreenFragment: Fragment()  {

    private var _binding: FragmentSplashScreenBinding ? = null
    private val binding get() = _binding!!

    companion object {
        @JvmStatic
        fun newInstance() = SplashScreenFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.splashScreenMotionLayout.onTransitionCompletedListener {
            lifecycleScope.launch {
                if(findNavController().currentDestination?.id != R.id.signInFragment && findNavController().currentDestination?.id == R.id.splashScreenFragment) {
                  findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToSignInFragment())
                }
            }
        }
    }


}
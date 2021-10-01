package com.octal.actorpay

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.octal.actorpay.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val root: View = binding.root

        Handler().postDelayed(Runnable {
            Navigation.findNavController(root).navigate(R.id.action_splashFragment_to_loginFragment)
        }, 2000)
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
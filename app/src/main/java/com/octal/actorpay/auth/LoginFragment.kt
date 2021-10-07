package com.octal.actorpay.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.octal.actorpay.R
import com.octal.actorpay.databinding.FragmentLoginBinding
import androidx.viewpager.widget.ViewPager.OnPageChangeListener


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun init() {
            binding.apply {
                val viewPagerAdapter = activity?.let { ViewPagerAdapter(it.supportFragmentManager) }
                viewPager.adapter = viewPagerAdapter
                tabs.setupWithViewPager(viewPager)

                val params =
                    LinearLayout.LayoutParams(
                        ViewPager.LayoutParams.WRAP_CONTENT,
                        ViewPager.LayoutParams.WRAP_CONTENT
                    )

                viewPager.addOnPageChangeListener(object : OnPageChangeListener {
                    override fun onPageScrollStateChanged(state: Int) {
                    }
                    override fun onPageScrolled(
                        position: Int,
                        positionOffset: Float,
                        positionOffsetPixels: Int
                    ) {
                    }
                    override fun onPageSelected(position: Int) {
                        when (position) {
                            0 -> {
                              //  params.height = 800
                               // headerLinearLayout.layoutParams = params
                                viewPager.invalidate();
                                viewPagerAdapter?.notifyDataSetChanged()
                            }
                            1 -> {
                             //   params.height = 1700
                             //   headerLinearLayout.layoutParams = params
                                viewPager.invalidate();
                                viewPagerAdapter?.notifyDataSetChanged()
                            }
                        }
                    }
                })
            }


    }
}
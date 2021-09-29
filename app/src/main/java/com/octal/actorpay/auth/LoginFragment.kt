package com.octal.actorpay.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.octal.actorpay.R
import com.octal.actorpay.databinding.FragmentLoginBinding
import androidx.viewpager.widget.ViewPager.OnPageChangeListener


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
            binding.apply {
                val viewPagerAdapter = activity?.let { ViewPagerAdapter(it.supportFragmentManager) }
                viewPager.adapter = viewPagerAdapter
                val params =
                    RelativeLayout.LayoutParams(
                        ViewPager.LayoutParams.WRAP_CONTENT,
                        ViewPager.LayoutParams.WRAP_CONTENT
                    )

//setting margins around imageimageview

//setting margins around imageimageview


                viewPager.addOnPageChangeListener(object : OnPageChangeListener {
                    override fun onPageScrollStateChanged(state: Int) {
                        when (state) {

                        }
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
                                params.height = 300
                                rlHolder.layoutParams = params
                                viewPager.layoutParams = params
                                scrollable.requestLayout();
                            }
                            1 -> {
                                params.height = 700
                                rlHolder.layoutParams = params
                                viewPager.layoutParams = params
                                scrollable.requestLayout();

                            }
                        }
                    }
                })
            }

        }
    }
}
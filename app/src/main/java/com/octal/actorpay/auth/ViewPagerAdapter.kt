package com.octal.actorpay.auth

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import org.jetbrains.annotations.NotNull
import viewpagerwc.ui.dom.wrapping.WrappingFragmentPagerAdapter


class ViewPagerAdapter internal constructor(fm: FragmentManager) : WrappingFragmentPagerAdapter(fm) {

    private val COUNT = 2
    val tab = arrayOf("Login", "Signup")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = LoginScreenFragment()
            1 -> fragment = SignUpScreenFragment()
        }

        return fragment!!
    }

    override fun getCount(): Int {
        return COUNT
    }
    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tab[position]
    }
}

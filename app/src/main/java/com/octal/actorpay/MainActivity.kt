package com.octal.actorpay

import android.os.Bundle
import com.octal.actorpay.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Data binding here
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_Container) as NavHostFragment).navController

    }


    override fun onSupportNavigateUp(): Boolean {
        if (navController!!.navigateUp() == false) {
            onBackPressed()
        }
        return navController!!.navigateUp()
    }

    override fun onBackPressed() {
        when (navController!!.currentDestination?.id) {
            R.id.homeFragment -> {
                navController!!.navigateUp()
            }
            R.id.walletFragment -> {
                navController!!.navigateUp()
            }
            else -> super.onBackPressed()
        }
        // super.onBackPressed()
    }
}
/*

    override fun onBackPressed() {
        when (navController!!.currentDestination?.id) {
            R.id.homeFragment -> {
                navController!!.navigateUp()
            }
            else -> super.onBackPressed()
        }
        super.onBackPressed()
    }



}
package com.octal.actorpay

import android.os.Bundle
import com.octal.actorpay.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Data binding here
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /**
         * initialize the view-model
         */
        setContentView(R.layout.activity_main)
        //initiliation()

    }



}
package com.octal.actorpay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.octal.actorpay.base.BaseActivity

class SplashScreen : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.statusBarColor = this.resources.getColor(R.color.primary)
        Handler().postDelayed(Runnable {
           startActivity(Intent(this@SplashScreen,MainActivity::class.java))
        },2000)
    }
}
package com.roobics.chuck.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.roobics.chuck.R
import kotlinx.android.synthetic.main.activity_welcome.*
import com.roobics.chuck.factory.ViewModelFactory


class WelcomeActivity : AppCompatActivity() {

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)
        viewModel = ViewModelProviders.of(this,ViewModelFactory(this.application)).get(WelcomeViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

       viewModel.getJoke().observe(this, Observer {
           chuckNor ->
           messageView?.text = chuckNor?.data?.value
       })

        button_joke.setOnClickListener {
            viewModel.fetchJoke()
        }
    }
}

package com.roobics.chuck.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.roobics.chuck.R
import com.roobics.chuck.factory.ViewModelFactory
import com.roobics.chuck.utils.Resource
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity() {

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this.application)).get(WelcomeViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        viewModel.getJoke().observe(this, Observer { chuckNor ->

            if (chuckNor?.status == Resource.Status.LOADING) {
                progressBar.visibility = VISIBLE
            } else {
                progressBar.visibility = GONE
                messageView?.text = chuckNor?.data?.value
            }

        })

        buttonJoke.setOnClickListener {
            viewModel.fetchJoke()
        }
    }

}

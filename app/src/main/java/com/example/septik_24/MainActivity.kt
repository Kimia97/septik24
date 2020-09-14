package com.example.septik_24

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val login = LoginFragment()
        supportFragmentManager.beginTransaction().replace(R.id.content_id, login).commit()

        /* findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
             Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     .setAction("Action", null).show()
         }*/
    }

    override fun passData(textInput: String) {
        val bundle = Bundle()
        bundle.putString("input_txt", textInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val vakter = VakterFragment()
        vakter.arguments = bundle

        transaction.replace(R.id.content_id, vakter)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}
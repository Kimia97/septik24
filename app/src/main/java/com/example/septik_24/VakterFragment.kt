package com.example.septik_24

import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_vakter.*
import kotlinx.android.synthetic.main.fragment_vakter.view.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class VakterFragment : Fragment() {
    private lateinit var database: DatabaseReference

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootview =  inflater.inflate(R.layout.fragment_vakter, container, false)
        (activity as MainActivity).supportActionBar?.title = getString(R.string.vakter_title)


        val arrayAdapter: ArrayAdapter<*>
        val testArray = arrayOf("14.09.2020", "15.09.2020", "16.09.2020")
        val listView = rootview.vakter_list
        arrayAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, testArray)
        listView.adapter = arrayAdapter
        // Inflate the layout for this fragment
        return rootview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.lag_ny_dagslogg_button).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_dagsloggFragment)
        }
    }
}
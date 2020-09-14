package com.example.septik_24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vakter.*
import kotlinx.android.synthetic.main.fragment_vakter.view.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class VakterFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_vakter, container, false)
        (activity as MainActivity).supportActionBar?.title = getString(R.string.vakter_title)
        val arrayAdapter: ArrayAdapter<*>
        val testArray = arrayOf("14.09.2020", "15.09.2020", "16.09.2020")
        println(vakter_list)
        val listView = view.vakter_list
        arrayAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, testArray)
        listView.adapter = arrayAdapter
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
package com.example.septik_24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dagslogg.view.*

class DagsloggFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).supportActionBar?.title = getString(R.string.dagslogg_title)
        val rootView = inflater.inflate(R.layout.fragment_dagslogg, container, false)
        val arrayAdapter: ArrayAdapter<*>
        val testArray = arrayOf("seddelnummer: 1234,  kubikk: 100000", "seddelnummer: 5678, kubikk: 1000000", "seddelnummer: 91011, kubikk: 234541151")
        val listView = rootView.dagslogg_list
        arrayAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, testArray)
        listView.adapter = arrayAdapter
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO: knapp logikk
    }
}
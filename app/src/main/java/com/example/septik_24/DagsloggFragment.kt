package com.example.septik_24

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_dagslogg.view.*

class DagsloggFragment: Fragment() {
    private var seddelnummerList = ArrayList<Int>()
    private var kubikkList = ArrayList<Int>()
    private var visningList = ArrayList<String>()
    private var arrayAdapter: ArrayAdapter<*>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).supportActionBar?.title = getString(R.string.dagslogg_title)
        val rootView = inflater.inflate(R.layout.fragment_dagslogg, container, false)

        seddelnummerList.add(1234)
        seddelnummerList.add(6789)
        kubikkList.add(1000)
        kubikkList.add(2000)

        Log.d("sjekker: ", seddelnummerList.size.toString())
        addToVisningsList()
        //val testArray = arrayOf("seddelnummer: 1234,  kubikk: 100000", "seddelnummer: 5678, kubikk: 1000000", "seddelnummer: 91011, kubikk: 234541151")
        val listView = rootView.dagslogg_list
        arrayAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, visningList)
        listView.adapter = arrayAdapter
        return rootView
    }

    fun addToAdapter() {

    }

    fun addToVisningsList() {
        var listContent: String
        val size = seddelnummerList.size
        for(i in 0 until size) {
            listContent = ("Seddelnummer: "+ seddelnummerList[i].toString() +" , "  + "kubikk tømt: " + kubikkList[i].toString())
            visningList.add(listContent)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.legg_til_button).setOnClickListener {
            var listView = view.dagslogg_list
            val textinput1 = view.dagslogg_textinput1.text.toString().toInt()
            val textinput2 = view.dagslogg_textinput2.text.toString().toInt()

            seddelnummerList.add(textinput1)
            kubikkList.add(textinput2)
            visningList.add("Seddelnummer: " + seddelnummerList.last().toString() + " , " + "kubikk tømt: " + kubikkList.last().toString())
            arrayAdapter?.notifyDataSetChanged()

        }
    }
}
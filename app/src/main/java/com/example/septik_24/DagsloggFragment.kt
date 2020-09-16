package com.example.septik_24

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_dagslogg.view.*

class DagsloggFragment: Fragment() {
    private var seddelnummerList = ArrayList<Int>()
    private var cubicList = ArrayList<Int>()
    private var visningList = ArrayList<String>()
    private var arrayAdapter: ArrayAdapter<*>? = null
    private var totalCubic: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).supportActionBar?.title = getString(R.string.dagslogg_title)
        val rootView = inflater.inflate(R.layout.fragment_dagslogg, container, false)

        seddelnummerList.add(1234)
        seddelnummerList.add(6789)
        cubicList.add(1000)
        cubicList.add(2000)

        addToVisningsList()
        val listView = rootView.dagslogg_list
        arrayAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, visningList)
        listView.adapter = arrayAdapter
        return rootView
    }

    private fun addToVisningsList() {
        var listContent: String
        val size = seddelnummerList.size
        for(i in 0 until size) {
            listContent = ("Seddelnummer: "+ seddelnummerList[i].toString() +" , "  + "kubikk tømt: " + cubicList[i].toString())
            visningList.add(listContent)
        }
    }

    private fun calcTotalCubic(): Int {
        for(cubic in cubicList) {
            totalCubic += cubic
        }
        return totalCubic
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.legg_til_button).setOnClickListener {
            val textinput1 = view.dagslogg_textinput1.text.toString().toInt()
            val textinput2 = view.dagslogg_textinput2.text.toString().toInt()

            seddelnummerList.add(textinput1)
            cubicList.add(textinput2)
            visningList.add("Seddelnummer: " + seddelnummerList.last().toString() + " , " + "kubikk tømt: " + cubicList.last().toString())
            arrayAdapter?.notifyDataSetChanged()
        }


        view.findViewById<Button>(R.id.send_in_button).setOnClickListener {
            val args = Bundle()
            args.putInt("totalCubic", calcTotalCubic())
            val newDialog = ConfirmDialogFragment()
            newDialog.arguments = args
            activity?.supportFragmentManager?.let { it1 -> newDialog.show(it1, "confirm") }
        }
    }
}
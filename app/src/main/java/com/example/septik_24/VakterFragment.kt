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
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_vakter.*
import kotlinx.android.synthetic.main.fragment_vakter.view.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class VakterFragment : Fragment() {
    private val testArray = ArrayList<String>()
    private var arrayAdapter: ArrayAdapter<*>? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootview =  inflater.inflate(R.layout.fragment_vakter, container, false)
        testArray.add("14.09.2020")
        testArray.add("15.09.2020")

        val listView = rootview.vakter_list
        arrayAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, testArray)
        listView.adapter = arrayAdapter

        (activity as MainActivity).supportActionBar?.title = getString(R.string.vakter_title)
        val database = Firebase.database
        var ref = database.getReference("driver").child("1")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.w("Check here", "loadPost:onCancelled", error.toException())
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val dagslogg = snapshot.getValue(Dagslogg::class.java)
                Log.d("123", dagslogg.toString())
                dagslogg?.date?.let { testArray.add(it) }
                arrayAdapter?.notifyDataSetChanged()
            }
            })
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
package com.example.septik_24

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.IllegalStateException

class ConfirmDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)
            val mArgs = arguments
            val totalCubic = mArgs?.getInt("totalCubic")
            builder.setMessage(
                "Vil du legge til dagsloggen med total kubikk: $totalCubic?").setTitle(" Lag dagslogg")
            builder.apply {
                setPositiveButton(R.string.ok
                ) { dialog, id ->
                    val database = Firebase.database
                    val dagslogg = Dagslogg(1, "16.09.2020", totalCubic )
                    database.getReference("driver").child("1").setValue(dagslogg).addOnSuccessListener {
                        val toast = Toast.makeText(context, "Lagt til i database", Toast.LENGTH_SHORT)
                        toast.show()
                    }
                    findNavController().navigate(R.id.action_dagsloggFragment_to_SecondFragment)
                }
                setNegativeButton(R.string.cancel) {
                    dialog, id ->
                    dismiss()
                }
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
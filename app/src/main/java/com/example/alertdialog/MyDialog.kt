package com.example.alertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialog : DialogFragment() {
    private var removable: Removable? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        removable = context as Removable?
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val user = requireArguments().getString("user")
        val builder = AlertDialog.Builder(requireActivity())
        return builder
            .setTitle("Внимание")
            .setIcon(R.drawable.ic_delete)
            .setMessage("Удалить пользователя $user")
            .setPositiveButton("Да") { dialog, which ->
                removable?.remove(user)
            }
            .setNegativeButton("Отмена", null)
            .create()
    }
}
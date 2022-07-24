package jth.fitpet.presentation.views

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import jth.fitpet.presentation.R

class WeatherDialogFragment(
    private val message: String,
    private val onPositiveButtonClick: () -> Unit = {}
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(message)
                .setPositiveButton(
                    R.string.confirm
                ) { _, _ ->
                    dismiss()
                    onPositiveButtonClick()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
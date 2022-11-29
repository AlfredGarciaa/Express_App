package edu.bo.ucb.express_app.Alarma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import edu.bo.ucb.express_app.R
import kotlinx.android.synthetic.main.fragment_custom_dialog.*
import kotlinx.android.synthetic.main.fragment_custom_dialog.view.*

class CustomDialogFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_custom_dialog, container, false)

        // CANCELAR VISTA Y VOLVER A LA ALARMA \\
        rootView.cancelButton.setOnClickListener {
            dismiss()
        }

        // CAMBIA A VISTA DE OPCIONES DE MATERIA \\
        rootView.submitButton.setOnClickListener {
            val selectedID = ratingRadioGroup.checkedRadioButtonId
            val radio = rootView.findViewById<RadioButton>(selectedID)
            var ratingResult = radio.text.toString()

            Toast.makeText(context, "Recordatorio de: $ratingResult", Toast.LENGTH_LONG).show()
            dismiss()
        }

        return rootView
    }
}
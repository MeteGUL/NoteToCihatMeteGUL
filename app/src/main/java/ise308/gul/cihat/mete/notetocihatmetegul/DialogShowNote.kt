package ise308.gul.cihat.mete.notetocihatmetegul

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import org.w3c.dom.Text

class DialogShowNote : DialogFragment() {

    private var note: Note?= null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity!!)
        val inflater = activity!!.layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_show_note, null)


        val textViewTitle = dialogLayout.findViewById<TextView>(R.id.textView_title)
        val textViewDescription = dialogLayout.findViewById<TextView>(R.id.textView_description)
        val textViewIdea = dialogLayout.findViewById<CheckBox>(R.id.textView_idea)
        val textViewToDo = dialogLayout.findViewById<CheckBox>(R.id.textView_todo)
        val textViewImportant = dialogLayout.findViewById<CheckBox>(R.id.textView_important)
        val buttonDone = dialogLayout.findViewById<Button>(R.id.button_done)

        textViewTitle.text = note!!.title
        textViewDescription.text = note!!.description

        if (!note!!.todo){
            textViewToDo.visibility = View.GONE
        }
        if (!note!!.idea){
            textViewIdea.visibility = View.GONE
        }

        buttonDone.setOnClickListener {
            dismiss()
        }

        builder.setView(dialogLayout)
            .setMessage("Your Note")


        return builder.create()
    }

    fun sendNoteSelected(noteselected: Note){
    note= noteselected

    }
}
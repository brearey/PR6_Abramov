package ru.oktemsec.pr6_abramov

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment

var constraintLayout:ConstraintLayout? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_fon:Button = findViewById(R.id.button_fon)
        constraintLayout = findViewById(R.id.constraintLayout)

        btn_fon.setOnClickListener {
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            myDialogFragment.show(manager, "myDialog")
        }
    }
}

class MyDialogFragment : DialogFragment() {

    private val colors = arrayOf("Красный", "Зелёный", "Желтый")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)

            builder.setTitle(R.string.message)
                .setItems(colors
                ) { dialog, which ->
                    Toast.makeText(activity, colors[which],
                        Toast.LENGTH_SHORT).show()
                    when(which) {
                        0 -> constraintLayout?.setBackgroundColor(Color.RED)
                        1 -> constraintLayout?.setBackgroundColor(Color.GREEN)
                        2 -> constraintLayout?.setBackgroundColor(Color.YELLOW)
                    }
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}
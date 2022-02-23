package torres.felipe.clicker

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var btn_restar: Button
    lateinit var btn_borrar: ImageButton
    lateinit var tv_contador: TextView
    lateinit var txt_nombre: EditText

    var cosa: String? = ""
    var cuenta: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_sumar: Button = findViewById(R.id.btn_contar)

        txt_nombre = findViewById(R.id.txt_nombre)

        tv_contador = findViewById(R.id.tv_contador)

        btn_restar = findViewById(R.id.btn_restaruno)
        btn_borrar = findViewById(R.id.btn_borrar)

        btn_sumar.setOnClickListener{
            cuenta ++
            tv_contador.setText("$cuenta")
        }

        btn_restar.setOnClickListener{
            cuenta --
            tv_contador.setText("$cuenta")
        }

        btn_borrar.setOnClickListener{

            val alertDialog: AlertDialog? = this?.let {
                val builder = AlertDialog.Builder(it)
                builder.apply {
                    setPositiveButton("Borrar",
                        DialogInterface.OnClickListener { dialog, id ->
                            cuenta = 0
                            tv_contador.setText("$cuenta")
                        })
                    setNegativeButton("Cancelar",
                        DialogInterface.OnClickListener { dialog, id ->
                            // User cancelled the dialog
                        })
                }
                // Set other dialog properties
                builder?.setMessage("¿Seguro que desea borrar la cuenta?")
                    .setTitle("ALERTA")

                // Create the AlertDialog
                builder.create()
            }

            alertDialog?.show()

        }
    }

    override fun onPause() {
        super.onPause()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        cosa = txt_nombre.text.toString()
        editor.putInt("contador", cuenta)
        editor.putString("cosa", cosa)
        editor.commit()



    }

    override fun onResume() {
        super.onResume()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        cuenta = sharedPref.getInt("contador",0)
        cosa = sharedPref.getString("cosa","")
        tv_contador.setText("$cuenta")
        txt_nombre.setText("$cosa")


    }
}
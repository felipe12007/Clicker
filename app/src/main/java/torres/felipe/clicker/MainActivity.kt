package torres.felipe.clicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btn_restar: Button
    lateinit var btn_borrar: ImageButton
    var cuenta: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_sumar: Button = findViewById(R.id.btn_contar)
        var tv_contador: TextView = findViewById(R.id.tv_contador)

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
            cuenta = 0
            tv_contador.setText("$cuenta")
        }
    }
}
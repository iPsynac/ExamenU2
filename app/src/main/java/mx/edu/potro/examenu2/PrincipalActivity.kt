package mx.edu.potro.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var btnDetalles: Button = findViewById(R.id.buttonDetalles)
        var btnGlobos: Button = findViewById(R.id.buttonGlobos)
        var btnPeluches: Button = findViewById(R.id.buttonPeluches)
        var btnRegalos: Button = findViewById(R.id.buttonRegalos)
        var btnTazas: Button = findViewById(R.id.buttonTazas)


        btnDetalles.setOnClickListener {
            var intent : Intent = Intent(this,RegalosActivity::class.java)
            intent.putExtra("menuType","Detalles")
            startActivity(intent)
        }
        btnGlobos.setOnClickListener {
            var intent : Intent = Intent(this,RegalosActivity::class.java)
            intent.putExtra("menuType","Globos")
            startActivity(intent)
        }
        btnPeluches.setOnClickListener {
            var intent : Intent = Intent(this,RegalosActivity::class.java)
            intent.putExtra("menuType","Peluches")
            startActivity(intent)
        }
        btnRegalos.setOnClickListener {
            var intent : Intent = Intent(this,RegalosActivity::class.java)
            intent.putExtra("menuType","Regalos")
            startActivity(intent)
        }
        btnTazas.setOnClickListener {
            var intent : Intent = Intent(this,RegalosActivity::class.java)
            intent.putExtra("menuType","Tazas")
            startActivity(intent)
        }


    }
}
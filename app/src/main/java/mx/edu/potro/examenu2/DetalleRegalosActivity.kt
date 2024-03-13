package mx.edu.potro.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetalleRegalosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_regalos)

        val iv_detalle_image: ImageView = findViewById(R.id.iv_regalo_imagen)
        val tv_regalo_precio: TextView = findViewById(R.id.tv_regalo_precio)

        val bundle=intent.extras

        if (bundle!=null){
            iv_detalle_image.setImageResource(bundle.getInt("imagen"))
            tv_regalo_precio.setText(bundle.getString("precio"))

        }
    }
}
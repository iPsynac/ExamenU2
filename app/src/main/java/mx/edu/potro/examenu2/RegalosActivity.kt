package mx.edu.potro.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class RegalosActivity : AppCompatActivity() {
    var detalles: ArrayList<Detalles> = ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var menuOption : String? = intent.getStringExtra("menuType")
        agregarDetalles(menuOption)

        var gridView: GridView = findViewById(R.id.catalogo) as GridView

        var adaptador : AdaptadorDetalles = AdaptadorDetalles(this, detalles)
        gridView.adapter = adaptador
    }

    fun agregarDetalles(option:String?){
        var detalles=ArrayList<Detalles>()
        var title:TextView = findViewById(R.id.title)

        when(option){
            "Detalles"->{
                title.setText("Detalles")
                detalles.add(Detalles(R.drawable.cumplebotanas,"$280"))
                detalles.add(Detalles(R.drawable.cumplecheve,"$320"))
                detalles.add(Detalles(R.drawable.cumpleescolar,"$330"))
                detalles.add(Detalles(R.drawable.cumplesnack,"$190"))
                detalles.add(Detalles(R.drawable.cumplepaletas,"$150"))
                detalles.add(Detalles(R.drawable.cumplevinos,"$370"))

            }
        }

    }
    private class AdaptadorDetalles: BaseAdapter{
        var detalles =ArrayList<Detalles>()
        var contexto: Context?=null

        constructor(contexto: Context,producto: ArrayList<Detalles>){
            this.detalles=producto
            this.contexto=contexto

        }


        override fun getCount(): Int {
           return detalles.size
        }

        override fun getItem(p0: Int): Any {
           return detalles[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod=detalles[p0]
            var inflator = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista=inflator.inflate(R.layout.detalles,null)

            var image: ImageView=vista.findViewById(R.id.image_detalle_cell)
            var price: TextView =vista.findViewById(R.id.detalle_price_cell)

            image.setImageResource(prod.image)
            price.setText(prod.precio)

            image.setOnClickListener(){
                val intento = Intent(contexto,DetalleRegalosActivity::class.java)
                intento.putExtra("imagen",prod.image)
                intento.putExtra("precio", prod.precio)
                intento.putExtra("pos", p0)
                contexto!!.startActivity(intento)
            }
            return  vista

        }


    }
}
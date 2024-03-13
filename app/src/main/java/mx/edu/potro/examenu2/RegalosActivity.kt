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
            "Globos"->{
                title.setText("Globos")
                detalles.add(Detalles(R.drawable.globoamor,"$240"))
                detalles.add(Detalles(R.drawable.globocumple,"$820"))
                detalles.add(Detalles(R.drawable.globofestejo,"$260"))
                detalles.add(Detalles(R.drawable.globonum,"$760"))
                detalles.add(Detalles(R.drawable.globoregalo,"$150"))
                detalles.add(Detalles(R.drawable.globos,"$240"))
            }
            "Peluches"->{
                title.setText("Peluches")
                detalles.add(Detalles(R.drawable.peluchemario,"$320"))
                detalles.add(Detalles(R.drawable.pelucheminecraft,"$290"))
                detalles.add(Detalles(R.drawable.peluches,"$700"))
                detalles.add(Detalles(R.drawable.peluchesony,"$330"))
                detalles.add(Detalles(R.drawable.peluchestich,"$280"))
                detalles.add(Detalles(R.drawable.peluchevarios,"$195"))
            }
            "Regalos"->{
                title.setText("Regalos")
                detalles.add(Detalles(R.drawable.regaloazul,"$80"))
                detalles.add(Detalles(R.drawable.regalobebe,"$290"))
                detalles.add(Detalles(R.drawable.regalocajas,"$140"))
                detalles.add(Detalles(R.drawable.regalocolores,"$85"))
                detalles.add(Detalles(R.drawable.regalos,"$1000"))
                detalles.add(Detalles(R.drawable.regalovarios,"$75"))
            }
            "Tazas"->{
                title.setText("Tazas")
                detalles.add(Detalles(R.drawable.tazaabuela,"$120"))
                detalles.add(Detalles(R.drawable.tazalove,"$120"))
                detalles.add(Detalles(R.drawable.tazaquiero,"$260"))
                detalles.add(Detalles(R.drawable.tazas,"$280"))

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
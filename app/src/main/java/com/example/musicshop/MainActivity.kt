package com.example.musicshop

import android.graphics.ColorSpace
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var names = R.array.brands
    var prices = R.array.prices
    var picture = R.array.gutarPic

    private val modelsList = arrayListOf<Model>()
    private val modelsNames = arrayListOf<String>()
    private lateinit var currentModel: Model


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spinner = findViewById<Spinner>(R.id.spinner)
        modelsList.add(Model("Акустическая гитара TERRIS", 25000, getDrawable(R.drawable.gutar_1) as Drawable))
        modelsList.add(Model("Электрогитара YAMAHA Pacifica Red 113JL", 50000, getDrawable(R.drawable.gutar_2) as Drawable))
        modelsList.add(Model("Электрогитара YAMAHA Pacifica 112JL", 65000, getDrawable(R.drawable.gutar_3) as Drawable))
        modelsList.forEach {
            modelsNames.add(it.name)
        }

            var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, modelsNames )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                 override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    var textView = p1 as TextView
                    currentModel = modelsList.first { it.name == textView.text }

                    var image = findViewById<ImageView>(R.id.imageView3)
                    image.setImageDrawable(currentModel.picture)
                     var modelNameView = findViewById<TextView>(R.id.textView5)
                     modelNameView.text = textView.text
                    var priceView = findViewById<TextView>(R.id.textView6)
                    priceView.text = currentModel.price.toString() + " RUB"
                }
            }
    }
    public fun CountDecrease(view: View){
        var count = findViewById<TextView>(R.id.minus)
        var totalPrice = findViewById<TextView>(R.id.totalPrice)
        var num = count.text.toString().toInt()
        if (num == 0)
            return
        else
            num--
        count.text = num.toString()
        totalPrice.text = (currentModel.price*num).toString() + " RUB"
    }
    public fun CountIncrease(view: View){
        var count = findViewById<TextView>(R.id.plus)
        var totalPrice = findViewById<TextView>(R.id.totalPrice)
        var num = count.text.toString().toInt()
        num++
        count.text = num.toString()
        totalPrice.text = (currentModel.price*num).toString() + " RUB"
    }
    }
       data class Model (val name: String, var price: Int, var picture: Drawable ) {

        }

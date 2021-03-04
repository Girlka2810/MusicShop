package com.example.musicshop
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class BasketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        var models = intent.getStringArrayListExtra("names")
        var counts = intent.getStringArrayListExtra("counts")
        var totals = intent.getStringArrayListExtra("totals")

        var namesView = findViewById<ListView>(R.id.counts)
        var countsView = findViewById<ListView>(R.id.names)
        var totalsView = findViewById<ListView>(R.id.counts)

       // var namesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, models)
       // namesView.adapter = namesAdapter
     //   var countsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, counts)
      //  countsView.adapter = countsAdapter
      //  var totalsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, totals)
       // totalsView.adapter = totalsAdapter
    }

    public fun onBuyButtonClick(view: View){
        var action = getString(R.string.BROADCAST_BUY_MESSAGE)
        var intent = Intent(action)
        intent.putExtra("message", getString(R.string.BUY_MESSAGE))
        sendBroadcast(intent)
       //  var prev = Intent(this, MainActivity::class.java)
      //  startActivity(prev)
    }

}
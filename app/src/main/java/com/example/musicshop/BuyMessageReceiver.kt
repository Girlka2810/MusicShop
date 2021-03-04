package com.example.musicshop
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BuyMessageReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        var toast = Toast.makeText(context, intent.getStringExtra("message"), Toast.LENGTH_LONG)
        toast.show()
    }
}
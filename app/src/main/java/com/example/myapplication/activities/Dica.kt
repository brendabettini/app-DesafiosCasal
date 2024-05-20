package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.activities.models.InfoModelo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class Dica: AppCompatActivity() {

    private lateinit var tvComida: TextView
    private lateinit var tvFilme: TextView
    private lateinit var tvGostos: TextView
    private lateinit var tvDesgosto: TextView
    private lateinit var tvAlergia: TextView
    private lateinit var tvHobbie: TextView


    private lateinit var dbRef: DatabaseReference
    private var dispList: ArrayList<InfoModelo> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dicas)

        tvComida = findViewById(R.id.textView5)
        tvFilme = findViewById(R.id.textView6)
        tvAlergia = findViewById(R.id.textView7)
        tvGostos = findViewById(R.id.textView8)
        tvDesgosto = findViewById(R.id.textView9)
        tvHobbie = findViewById(R.id.textView10)

        dbRef = FirebaseDatabase.getInstance().getReference("Armozinho")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dispList.clear()
                if (snapshot.exists()) {
                    for (favSnap in snapshot.children) {
                        val favData = favSnap.getValue(InfoModelo::class.java)
                        dispList.add(favData!!)
                    }
                    if (dispList.isNotEmpty()) {
                        tvComida.text = dispList[0].comifavo.toString()
                        tvFilme.text = dispList[0].filmefavo.toString()
                        tvAlergia.text = dispList[0].alergias.toString()
                        tvGostos.text = dispList[0].gosto.toString()
                        tvDesgosto.text = dispList[0].desgoto.toString()
                        tvHobbie.text = dispList[0].hobbie.toString()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled event
            }
        })
    }
}




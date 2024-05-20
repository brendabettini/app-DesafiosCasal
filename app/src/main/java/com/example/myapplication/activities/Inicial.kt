package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.myapplication.activities.models.InfoModelo
import java.util.ArrayList
class Inicial : AppCompatActivity() {

        private lateinit var dbRef: DatabaseReference
        private lateinit var dispList: ArrayList<InfoModelo>

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.inicial)


                val btnon: Button = findViewById(R.id.buttoninicial)
                btnon.setOnClickListener{
                        dbRef = FirebaseDatabase.getInstance().getReference("Armozinho")

                        val comidafav = findViewById<EditText>(R.id.textcumida).text.toString()
                        val filmefav = findViewById<EditText>(R.id.textfilmin).text.toString()
                        val gostos = findViewById<EditText>(R.id.textgosto).text.toString()
                        val desgostos = findViewById<EditText>(R.id.textdesgo).text.toString()
                        val alergias = findViewById<EditText>(R.id.textalergia).text.toString()
                        val hobbie = findViewById<EditText>(R.id.texthob).text.toString()

                        if (comidafav.isEmpty()){
                                findViewById<EditText>(R.id.textcumida).error ="Insira a sua Comida Favorita pfv :)"
                        }
                        if (filmefav.isEmpty()){
                                findViewById<EditText>(R.id.textfilmin).error ="Insira seu filme Favorito pfv :)"
                        }
                        if (gostos.isEmpty()){
                                findViewById<EditText>(R.id.textgosto).error ="Insira sua série Favorita pfv :)"
                        }
                        if (desgostos.isEmpty()){
                                findViewById<EditText>(R.id.textdesgo).error ="Insira sua música Favorita pfv :)"
                        }
                        if (alergias.isEmpty()){
                                findViewById<EditText>(R.id.textalergia).error ="Insira sua Alergia pfv :)"
                        }
                        if (hobbie.isEmpty()){
                                findViewById<EditText>(R.id.texthob).error ="Insira sua Comida que vc não gosta pfv :)"
                        }

                        val dispId = dbRef.push().key?: ""


                        val dispositivosss = InfoModelo(dispId, comidafav,filmefav,alergias,gostos,desgostos,hobbie)

                        dbRef.child(dispId).setValue(dispositivosss)
                                .addOnCompleteListener{
                                        Toast.makeText(this,"Dado inserido com sucesso", Toast.LENGTH_SHORT).show()

                                }.addOnFailureListener{ err->
                                        Toast.makeText(this,"Erro ${err.message}", Toast.LENGTH_SHORT).show()
                                }



                        val intent = Intent(this@Inicial, Princi::class.java)
                        startActivity(intent)

                }

        }
}


















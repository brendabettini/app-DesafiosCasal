package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import com.example.myapplication.R

class Dodiar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dodia)

        val generator = UniqueRandomGenerator()
        val x = generator.generateUniqueNumber(1, 5)

        if (x == 1) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Noite de Cinema em Casa:\n" +
                        "Desafio: Prepare uma noite romântica de cinema em casa para o seu parceiro.\n" +
                        "Como: Escolha os filmes favoritos do seu parceiro ou filmes românticos clássicos, prepare uma seleção de petiscos, como pipoca, doces e refrigerantes, e crie um ambiente aconchegante com cobertores e almofadas."
        }

        if (x == 2) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Jantar Romântico Surpresa:\n" +
                        "Desafio: Prepare um jantar romântico surpresa para o seu parceiro.\n" +
                        "Como: Prepare o prato favorito do seu parceiro ou experimente uma nova receita romântica juntos. Decore a mesa com velas, flores e música suave para criar um ambiente íntimo e especial."
        }

        if (x == 3) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Caça ao Tesouro Romântica:\n" +
                        "Desafio: Organize uma caça ao tesouro romântica para o seu parceiro.\n" +
                        "Como: Esconda mensagens de amor e pistas pela casa ou por lugares significativos para vocês dois. Cada pista pode levar a um lugar especial onde vocês compartilharam momentos memoráveis ou a um presente romântico no final da caça ao tesouro."
        }

        if (x == 4) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Maratona de Séries Juntos:\n" +
                        "Desafio: Faça uma maratona de séries românticas juntos.\n" +
                        "Como: Escolha uma série de TV romântica que vocês dois gostariam de assistir e assistam a vários episódios seguidos. Prepare lanches deliciosos, como fondue de chocolate, frutas e champanhe, para acompanhar a maratona."
        }

        if (x == 5) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Picnic ao Pôr do Sol:\n" +
                        "Desafio: Organize um picnic romântico ao pôr do sol.\n" +
                        "Como: Prepare uma cesta de picnic com sanduíches, queijos, frutas e uma garrafa de vinho. Escolha um local bonito, como um parque ou uma praia, e assistam juntos ao pôr do sol enquanto desfrutam da comida e da companhia um do outro."
        }


        val btnon: Button = findViewById(R.id.btndica)
        btnon.setOnClickListener{
            val intent = Intent(this@Dodiar, Dica::class.java)
            startActivity(intent)

        }
        val btnone: Button = findViewById(R.id.enviar)
        btnone.setOnClickListener{
            val intent = Intent(this@Dodiar, Diario::class.java)
            startActivity(intent)

        }


    }



    class UniqueRandomGenerator {
        private val generatedNumbers = mutableListOf<Int>()

        fun generateUniqueNumber(min: Int, max: Int): Int {
            var randomNumber: Int
            do {
                randomNumber = Random.nextInt(min, max + 1)
            } while (generatedNumbers.contains(randomNumber))

            generatedNumbers.add(randomNumber)
            return randomNumber
        }
    }
}





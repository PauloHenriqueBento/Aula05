package com.psicoamerican.aula05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.psicoamerican.aula05.databinding.ActivityPokemonBinding

class Pokemon : AppCompatActivity() {
    lateinit var binding: ActivityPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemons = arrayListOf("Escolha um Pokémon", "Bulbasaur", "Squirtle", "Chamander")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemons)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapter: AdapterView<*>?, spinner: View?, posicao: Int, id: Long) {
                when(posicao){
                    1 -> {
                        val imageBulbassauro = getDrawable(R.drawable.bulbassauro)
                        binding.imageView.setImageDrawable(imageBulbassauro)
                    }
                    2 -> {
                        val imageSquirtle = getDrawable(R.drawable.squirtle)
                        binding.imageView.setImageDrawable(imageSquirtle)
                    }
                    3 -> {
                        val imageChamander = getDrawable(R.drawable.charmander)
                        binding.imageView.setImageDrawable(imageChamander)
                    }
                    else -> binding.imageView.setImageDrawable(null)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.button.setOnClickListener {
            when(binding.spinner.selectedItemPosition){
                1 -> {
                    val msg = """Tipo:
                        |Planta e Venenoso
                    """.trimMargin()
                    alert("Sobre", msg, this)
                }
                2 -> {
                    val msg = """Tipo:
                        |Água
                    """.trimMargin()
                    alert("Sobre", msg, this)
                }
                3 -> {
                    val msg = """Tipo:
                        |Fogo
                    """.trimMargin()
                    alert("Sobre", msg, this)
                }
            }
        }
    }

}
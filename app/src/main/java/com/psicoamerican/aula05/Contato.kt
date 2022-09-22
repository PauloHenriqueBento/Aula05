package com.psicoamerican.aula05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.psicoamerican.aula05.databinding.ActivityContatoBinding

class Contato : AppCompatActivity() {
    lateinit var binding: ActivityContatoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonIr.setOnClickListener {
            val msg = """${getString(R.string.nome)}: ${binding.editNome.text}
            |${getString(R.string.tel)}: ${binding.editTelefone.text}
            |${getString(R.string.email)}: ${binding.editEmail.text}
            |
            |${getString(R.string.contato_tel)}: ${if (binding.checkBoxTel.isChecked) getString(R.string.sim) else getString(R.string.nao) }
            |${getString(R.string.contato_email)}: ${if (binding.checkBoxEmail.isChecked) getString(R.string.sim) else getString(R.string.nao)}""".trimMargin()

            alert(getString(R.string.Confirmacao), msg, this)
        }
        
        binding.editTelefone.isEnabled = binding.checkBoxTel.isChecked
        binding.editEmail.isEnabled = binding.checkBoxEmail.isChecked

        binding.checkBoxTel.setOnCheckedChangeListener { checkbox, marcado ->
            binding.editTelefone.isEnabled = marcado
        }

        binding.checkBoxEmail.setOnCheckedChangeListener { checkbox, marcado ->
            binding.editEmail.isEnabled = marcado
        }
    }
}
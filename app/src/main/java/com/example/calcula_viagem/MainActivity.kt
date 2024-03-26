package com.example.calcula_viagem

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calcula_viagem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcula.setOnClickListener(this)

        closedKeyboard()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_Calcula){
            Toast.makeText(this, "Botão Funcionando", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculate() {

    }

    /*

    -> MODO JAVA
    private void ocutarTeclado() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(edtValor.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
    */

    private fun closedKeyboard() {
        val closedKeyboard = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        closedKeyboard.hideSoftInputFromWindow(
            binding.edtPreco.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }


}
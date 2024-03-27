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

        binding.btnCalculate.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_Calculate) {
            calculate()
        }
    }

  private fun isValid():Boolean {

      return (binding.edtDistance.text.toString() != ""
              && binding.edtPrice.text.toString() != ""
              && binding.edtAutonomy.text.toString() != ""
              && binding.edtAutonomy.text.toString().toFloat() != 0f)
  }

    private fun calculate() {

        if (isValid()){
            val distance = binding.edtDistance.text.toString().toFloat()
            val price = binding.edtPrice.text.toString().toFloat()
            val autonomy = binding.edtAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.txtTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

            closedKeyboard()

        } else {
            Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()

        }

    }

    private fun closedKeyboard() {
        val closedKeyboard = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        closedKeyboard.hideSoftInputFromWindow(
            binding.btnCalculate.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }


}
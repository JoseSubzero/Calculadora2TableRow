package com.example.appcalculadora2tablerow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.appcalculadora2tablerow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var n1 = 0
    private var n2 = 0
    private var op = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPunto.setOnClickListener {
            if (!binding.tvPantalla.text.toString().contains('.'))
                binding.tvPantalla.text = binding.tvPantalla.text.toString().plus(".")
        }

        binding.btnClear.setOnClickListener {
            binding.tvPantalla.text = "0"
            n1 = 0
            n2 = 0
            op = ""
        }
        binding.btnIgual.setOnClickListener {
            if (op != "")
            n2 = binding.tvPantalla.text.toString().toInt()

            binding.tvPantalla.text = when (op){
                "/" -> (n1/n2).toString()
                "X" -> (n1*n2).toString()
                "-" -> (n1-n2).toString()
                "+" -> (n1+n2).toString()
                else -> "Error"
            }
            op = ""


        }
    }

    fun onClickNumber(view: View){
        if (view is Button){
            val textBtn = view.text.toString()
            if (binding. tvPantalla.text.toString() != "0"){
                binding.tvPantalla.text = binding.tvPantalla.text.toString().plus(textBtn)
            } else {
                binding.tvPantalla.text = textBtn
            }
        }
    }
    fun onClickOp(view: View){
        if (view is Button){
            n1 = binding.tvPantalla.text.toString().toInt()
            op = view.text.toString()
            binding.tvPantalla.text = "0"
        }
    }
}
//
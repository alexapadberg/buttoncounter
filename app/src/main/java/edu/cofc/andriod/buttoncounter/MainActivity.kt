package edu.cofc.andriod.buttoncounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.cofc.andriod.buttoncounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var counter = 0
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// set up button listener for the count button
        binding.countButton.setOnClickListener {
            ++counter
            binding.textView.text = counter.toString()
        }
// set up button listener for the clear button
        binding.clearButton.setOnClickListener {
            counter = 0
            binding.textView.text = counter.toString()
        }
    }
    override fun onSaveInstanceState(outState : Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }
    override fun onRestoreInstanceState(inState: Bundle) {
        super.onRestoreInstanceState(inState)
        counter = inState.getInt("counter")
        binding.textView.text = counter.toString()
    }

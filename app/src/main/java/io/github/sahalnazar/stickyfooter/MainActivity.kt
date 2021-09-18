package io.github.sahalnazar.stickyfooter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import io.github.sahalnazar.stickyfooter.databinding.ActivityMainBinding
import io.github.sahalnazar.stickyfooter.utils.ExtensionFunctions.getViewBinding
import io.github.sahalnazar.stickyfooter.utils.ExtensionFunctions.isViewVisible

private lateinit var binding: ActivityMainBinding
private var counter = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding(R.layout.activity_main)

        setupStickyFooter()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnBuyNowSticky.setOnClickListener {
            counter += 1
            Toast.makeText(this, "clicked on buy now #$counter", Toast.LENGTH_SHORT).show()
        }
        binding.btnBuyNowFixed.setOnClickListener {
            counter += 1
            Toast.makeText(this, "clicked on buy now #$counter", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupStickyFooter() {
        binding.clBuyNowSticky.isVisible = binding.nestedScrollView.isViewVisible(binding.clBuyNowFixed) == false
        binding.nestedScrollView.setOnScrollChangeListener { _, _, _, _, _ ->
            binding.clBuyNowSticky.isVisible = binding.nestedScrollView.isViewVisible(binding.clBuyNowFixed) == false
        }
    }

}
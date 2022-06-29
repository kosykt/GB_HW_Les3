package com.example.animation

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import com.example.animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.car.setOnClickListener {
            val firstRotationX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, 0f, 1000f)
            ObjectAnimator
                .ofPropertyValuesHolder(binding.car, firstRotationX).apply {
                    duration = 5000
                    interpolator = DecelerateInterpolator()
                    repeatCount = 0
                    start()
                }.doOnEnd {
                    val secondRotationY =
                        PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0f, -1800f)
                    ObjectAnimator
                        .ofPropertyValuesHolder(binding.car, secondRotationY).apply {
                            duration = 5000
                            interpolator = DecelerateInterpolator()
                            repeatCount = 0
                            start()
                        }
                }
        }
    }
}
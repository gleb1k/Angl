package com.example.angl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.angl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        supportActionBar?.hide()

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container,
                MainFragment(),
                MainFragment.MAIN_FRAGMENT_TAG
            )
            .commit()

    }
}
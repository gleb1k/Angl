package com.example.angl

import com.example.angl.databinding.FragmentMainBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import java.util.*


class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding?.run {
            btn.setOnClickListener {
                calculate()
            }
        }

    }

    private fun calculate() {
        var sentence = readSentence() ?: return
        sentence = sentence.lowercase()

        var splittedSentence = sentence.splitToSequence(' ').filter { it.isNotBlank() }.toList()

        val result = PassiveVoiceUtils.calculateType(splittedSentence)
        binding?.run {
            if (result == null) {
                tvAnswer.text = "Not passive voice :c"
            } else {
                tvAnswer.text = result
            }
        }
    }

    private fun readSentence(): String? {
        val sentence = binding?.textInputEditText?.text.toString()
        return if (sentence == "") {
            binding?.textInputLayout?.error = "Required"
            binding?.tvAnswer?.text = ""
            null
        } else {
            binding?.textInputLayout?.error = null
            sentence
        }
    }


    companion object {
        const val MAIN_FRAGMENT_TAG = "Main_FRAGMENT_TAG"
    }
}
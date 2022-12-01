package com.example.criminalinent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.criminalinent.databinding.FragmentCrimeDetailBinding
import java.util.*
import androidx.core.*
import java.*

class CrimeDetailFragment: Fragment() {
    private lateinit var crime: Crime
    private lateinit var binding: FragmentCrimeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCrimeDetailBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            crimeTitle.doOnTextChanged {
                    text, _, _, _ ->
                    crime = crime.copy(title = text.toString())
            }
            crimeDate.apply {
                text = crime.date.toString()
                isEnabled = false
            }
            crimeSolved.apply {
                crime = crime.copy(isSolved = isChecked)
            }
        }
    }
}

package com.example.criminalinent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.text.format.DateFormat
import android.util.Log
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.criminalinent.databinding.FragmentCrimeDetailBinding
import java.util.*
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

class CrimeDetailFragment: Fragment() {
    private lateinit var binding: FragmentCrimeDetailBinding
    private val args: CrimeDetailFragmentArgs by navArgs()

    private val crimeDetailViewModel: CrimeDetailViewModel by viewModels {
       CrimeDetailViewModelFactory(args.crimeId)
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
                crimeDetailViewModel.updateCrime { oldCrime ->
                    oldCrime.copy(title = text.toString())
                }
            }
            crimeDate.apply {
                isEnabled = false
            }
            crimeSolved.setOnCheckedChangeListener { _, isChecked ->
                crimeDetailViewModel.updateCrime { oldCrime ->
                    oldCrime.copy(isSolved = isChecked)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                crimeDetailViewModel.crime.collect { crime ->
                    crime?.let {updateUi(it)}
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        _binding = null
    }
    private fun updateUi(crime: Crime) {
        binding.apply{
            if (crimeTitle.text.toString() != crime.title) {
                crimeTitle.setText(crime.title)
            }
            crimeDate.text = crime.date.toString()
            crimeSolved.isChecked = crime.isSolved
        }
    }
}


// FORMAT DATE
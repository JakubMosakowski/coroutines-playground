package com.jakmos.coroutinesplayground.service

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jakmos.coroutinesplayground.databinding.FragmentServiceBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ServiceFragment : Fragment() {

    private var _binding: FragmentServiceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStart.setOnClickListener {
            startService()
        }

        binding.buttonDestroy.setOnClickListener {
            stopService()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun startService() {
        applicationContext?.startService(Intent(applicationContext, SampleService::class.java))
    }

    private fun stopService() {
        applicationContext?.stopService(Intent(applicationContext, SampleService::class.java))
    }

    private val applicationContext get() = requireActivity().application
}

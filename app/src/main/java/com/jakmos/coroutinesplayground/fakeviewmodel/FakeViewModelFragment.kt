package com.jakmos.coroutinesplayground.fakeviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jakmos.coroutinesplayground.databinding.FragmentFakeViewModelBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FakeViewModelFragment : Fragment() {

    private var _binding: FragmentFakeViewModelBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var fakeViewModel: FakeViewModel = FakeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFakeViewModelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStart.setOnClickListener {
            fakeViewModel.collect()
        }

        binding.buttonDestroy.setOnClickListener {
            simulateDestroy()
        }
    }

    private fun simulateDestroy() {
        fakeViewModel.onDestroy()
        fakeViewModel = FakeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

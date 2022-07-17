package com.jakmos.coroutinesplayground.guide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jakmos.coroutinesplayground.databinding.FragmentGuideBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GuideFragment : Fragment() {

    private var _binding: FragmentGuideBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val idealViewModel: IdealViewModel by viewModels()
    private val threadViewModel: ThreadViewModel by viewModels()
    private val callbackViewModel: CallbackViewModel by viewModels()
    private val coroutineViewModel: CoroutineViewModel by viewModels()
    private val jobViewModel: JobViewModel by viewModels()
    private val flowViewModel: FlowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGuideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        idealViewModel.onCreate()
//        threadViewModel.onCreate()
//        callbackViewModel.onCreate()
//        coroutineViewModel.onCreate()
//        flowViewModel.onCreate()

        binding.start.setOnClickListener {
            jobViewModel.start()
        }
        binding.stop.setOnClickListener {
            jobViewModel.stop()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.example.freetoplaygames.free

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freetoplaygames.R
import com.example.freetoplaygames.databinding.FragmentPlatformFreeBinding

class PlatformFreeFragment : Fragment() {

    private var _binding: FragmentPlatformFreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlatformFreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        binding.imgGood1.setOnClickListener {
            val intent = Intent(context, CourseDetailsActivity::class.java)
            startActivity(intent)
        }
        */
    }
}
package com.example.freetoplaygames.discount

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freetoplaygames.CategoryDiscountActivity
import com.example.freetoplaygames.PlatformFreeActivity
import com.example.freetoplaygames.R
import com.example.freetoplaygames.databinding.FragmentPlatformDiscountBinding

class PlatformDiscountFragment : Fragment() {

    private var _binding: FragmentPlatformDiscountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlatformDiscountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Steam.setOnClickListener {
            val intent = Intent(context, CategoryDiscountActivity::class.java)
            startActivity(intent)
        }
    }
}
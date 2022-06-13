package com.example.freetoplaygames.free

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.commit
import com.example.freetoplaygames.R
import com.example.freetoplaygames.databinding.FragmentPlatformFreeBinding
import com.example.freetoplaygames.discount.PlatformDiscountFragment

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

        binding.Steam.setOnClickListener {

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.Steam, FreeSteamFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
            /*
            var fragment = FreeSteamFragment()
            //childFragmentManager.beginTransaction().replace(R.id.Steam,ChildFragment.getInstance()).commit()
            childFragmentManager.beginTransaction().replace(R.id.Steam,fragment).commit()
            */
        }


        /*
        binding.Steam.setOnClickListener {


            //val intent = Intent(context, CourseDetailsActivity::class.java)
            //startActivity(intent)
        }
        */


    }
}
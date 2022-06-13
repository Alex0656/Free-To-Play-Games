package com.example.freetoplaygames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.commit
import com.example.freetoplaygames.databinding.ActivityManagerProfileBinding
import com.example.freetoplaygames.discount.PlatformDiscountFragment
import com.example.freetoplaygames.free.PlatformFreeFragment

class ManagerProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManagerProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagerProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)

        if(savedInstanceState == null){
            var fragment = PlatformFreeFragment()
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, fragment, fragment.tag)
            }
            binding.bottomNavigation.menu.getItem(0).isChecked = true
        }


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.free -> {
                    var fragment = PlatformFreeFragment()
                    supportFragmentManager.commit {
                        replace(binding.fragmentContainer.id, fragment, fragment.tag)
                    }
                    binding.bottomNavigation.menu.getItem(0).isChecked = true
                    //val intent = Intent(this, ManagerProfileActivity::class.java)
                    //startActivity(intent)
                }
                R.id.discount -> {
                    var fragment = PlatformDiscountFragment()
                    supportFragmentManager.commit {
                        replace(binding.fragmentContainer.id, fragment, fragment.tag)
                    }
                    binding.bottomNavigation.menu.getItem(2).isChecked = true
                }
                else -> {}
            }
            true
        }

    }
}
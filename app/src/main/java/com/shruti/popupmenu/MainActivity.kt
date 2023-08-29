package com.shruti.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shruti.popupmenu.databinding.ActivityMainBinding
import com.shruti.popupmenu.databinding.BottomSheetViewBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnpopup.setOnClickListener {
            PopupMenu(this,binding.btnpopup).apply {
                menuInflater.inflate(R.menu.pop_menu,menu)
                setOnMenuItemClickListener {
                    when (it.itemId){
                        R.id.menufirst -> Toast.makeText(this@MainActivity,"First",Toast.LENGTH_SHORT).show()
                        R.id.menusecond -> Toast.makeText(this@MainActivity,"Second",Toast.LENGTH_SHORT).show()
                        R.id.menuthird -> Toast.makeText(this@MainActivity,"Third",Toast.LENGTH_SHORT).show()
                    }
                    return@setOnMenuItemClickListener true
                }
                    show()
            }
        }
        binding.btnbuttonsheet.setOnClickListener {
            var dialogBinding = BottomSheetViewBinding.inflate(layoutInflater)
            BottomSheetDialog(this).apply {
                setContentView(dialogBinding.root)
                show()
            }
        }

    }
}
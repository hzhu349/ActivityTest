package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        init()
    }


    private fun init() {
        var fragmentManager = supportFragmentManager


        var fragmentTransaction = fragmentManager.beginTransaction()
        var blankFragment = BlankFragment()


        button_add.setOnClickListener {


            fragmentTransaction.add(R.id.fragment_container, blankFragment)
            if (!fragmentManager.fragments.isEmpty())
                fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()





        }

        button_drop.setOnClickListener {
 /*           supportFragmentManager.beginTransaction().remove(R.id.blankFragment).commit()
*/
            fragmentTransaction.remove(blankFragment).commit()


        }

        supportFragmentManager.addOnBackStackChangedListener {


            if (fragmentManager.backStackEntryCount() > 0)
            { val lastFragment = fragmentManager.fragments.last()
                fragmentTransaction.add(R.id.fragment_container,lastFragment)
            }
            else{
                finish()
            }

            }
        }



}
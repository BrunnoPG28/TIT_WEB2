package com.example.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.spotifyclone.Fragments.Biblioteca
import com.example.spotifyclone.Fragments.Buscar
import com.example.spotifyclone.Fragments.Home
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var Content : FrameLayout? = null

    private var mOnNavegationItemSectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.nav_inicio -> {
                val fragment = Home.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_buscar ->{
                val fragment = Buscar.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_biblioteca->{
                val fragment = Biblioteca.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val content = findViewById<FrameLayout>(R.id.content)
        val bottom_menu = findViewById<BottomNavigationView>(R.id.botton_menu)

        Content = content
        bottom_menu.setOnNavigationItemSelectedListener(mOnNavegationItemSectedListener)

        val fragment = Home.newInstance()
        addFragment(fragment)

    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()

    }
}


package com.example.spotifyclone.Detalhes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.spotifyclone.Fragments.Home
import com.example.spotifyclone.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe_album.*

class DetalheAlbum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_album)

        intent.extras?.let {
            var album = it.getString("album")
            var titulos = it.getString("titulos")

            Picasso.get().load(album).into(img_detalhe)
            txt_detalhe.setText(titulos)

        }

        window.statusBarColor = Color.LTGRAY
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_arrow_back))
        toolbar.title = null
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivities(intent)
            finish()
        }
    }

    private fun startActivities(intent: Intent) {
    }
}
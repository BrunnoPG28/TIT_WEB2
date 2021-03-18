package com.example.spotifyclone.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone.API.SpotifyApi
import com.example.spotifyclone.API.retrofit
import com.example.spotifyclone.Detalhes.DetalheAlbum
import com.example.spotifyclone.Model.*
import com.example.spotifyclone.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_intem.view.*
import kotlinx.android.synthetic.main.categoria_item.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment() {

    private lateinit var categoriaAdapter : CategoriaAdapter

    companion object{
        fun newInstance() : Home{
            val fragmentHome = Home()
                val argumentos = Bundle()
            fragmentHome.arguments = argumentos
            return fragmentHome
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      val categorias = arrayListOf<Categoria>()
        categoriaAdapter = CategoriaAdapter(categorias)
        rcl_categorias.adapter = categoriaAdapter
        rcl_categorias.layoutManager = LinearLayoutManager(context)

        retrofit().create(SpotifyApi::class.java)
            .ListCategorias()
            .enqueue(object : Callback<ListaCategorias> {
                override fun onResponse(
                    call: Call<ListaCategorias>,
                    response: Response<ListaCategorias>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            categoriaAdapter.categorias
                            categoriaAdapter.categorias.addAll(it.categorias)
                            categoriaAdapter.notifyDataSetChanged()
                        }
                    }
                }

                override fun onFailure(call: Call<ListaCategorias>, t: Throwable) {
                    println(Toast.makeText(context, "Erro no servidor", Toast.LENGTH_SHORT).show())
                }
            })
    }

    private inner class CategoriaAdapter(internal val categorias: ArrayList<Categoria>)
        : RecyclerView.Adapter<CategoriaHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder {
            val view = (layoutInflater.inflate(R.layout.categoria_item, parent, false))
            return CategoriaHolder(view)

        }

        override fun onBindViewHolder(holder: CategoriaHolder, position: Int) {
            val categoria = categorias[position]
            holder.bind(categoria)
        }

        override fun getItemCount(): Int {
            return categorias.size
        }
    }

    private inner class CategoriaHolder(itemView : View): RecyclerView.ViewHolder(itemView){

         fun bind (categoria : Categoria){
            itemView.txt_titulo.text = categoria.titulo
            itemView.rcl_albuns.adapter = AlbunsAdapter(categoria.albuns){
                 album ->

                 val intent = Intent(context, DetalheAlbum::class.java)
                 intent.putExtra("album", album.album)
                 intent.putExtra("titulos", titulos[album.id])
                 startActivity(intent)
             }

             itemView.rcl_albuns.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }

    //--------------------album
    private inner class AlbunsAdapter(private val albuns : List<Album>, private val listener:((Album) -> Unit)?) : RecyclerView.Adapter<AlbunsHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbunsHolder = AlbunsHolder(
            layoutInflater.inflate(R.layout.album_intem, parent, false),listener)




        override fun onBindViewHolder(holder: AlbunsHolder, position: Int) {
            val album = albuns[position]
            holder.bind(album)
        }

        override fun getItemCount(): Int {
            return albuns.size
        }
    }
    private inner class AlbunsHolder(itemView : View, val onClick : ((Album)  -> Unit)?) : RecyclerView.ViewHolder(itemView){
            fun bind (album : Album){
                Picasso.get().load(album.album).placeholder(R.drawable.placeholder).fit().into(itemView.imageAlbum)
                itemView.imageAlbum.setOnClickListener{
                    onClick?.invoke(album)
                }

            }
    }


}

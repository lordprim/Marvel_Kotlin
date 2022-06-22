package com.example.marvel_api.view


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_api.Api.model.HeroiResult
import com.example.marvel_api.R

class HeroiAdapter(
    private val items: List<HeroiResult>
//    private val listener: OnItemClickListener
) : RecyclerView.Adapter<HeroiAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.heroi_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    override fun getItemCount() = items.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//    View.OnClickListener{

//        init {
//            itemView.setOnClickListener(this)
//        }
//
//        override fun onClick(p0: View?) {
//            val position = adapterPosition
//            if (position != RecyclerView.NO_POSITION) {
//                listener.onItemClick(position)
//            }
//        }

        fun bindView(item: HeroiResult) = with(itemView) {
            val ivHeroi = findViewById<ImageView>(R.id.ivHeroi)
            val tvName = findViewById<TextView>(R.id.tvName)

            var midia = "${item.thumbnail.path}.${item.thumbnail.extension}"
            var lista = midia.split(":").toMutableList()
            lista[0] = lista[0]+"s"
            Log.d("MIDIA", lista.toString())

            midia = "${lista[0]}:${lista[1]}"

            Log.d("MIDIA", midia)
            if (midia !== null){
                Glide.with(itemView.context).load(midia).into(ivHeroi)
            }
            tvName.text = item.name
        }

    }

//    interface OnItemClickListener{
//        fun onItemClick(position: Int)
//    }

}
package com.kylix.submissionbajp2.ui.tvshow

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kylix.submissionbajp2.R
import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.ui.activities.DetailActivity
import com.kylix.submissionbajp2.ui.activities.DetailActivity.Companion.TITLE
import kotlinx.android.synthetic.main.item_list.view.*

class TvShowAdapter(private val context: Context): RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private var listTvShow: List<ItemList> = emptyList()
    fun addList(tvShowModel: List<ItemList>){
        this.listTvShow = tvShowModel
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(listTvShow[position])
        context.let {
            Glide.with(it)
                .load("${"https://image.tmdb.org/t/p/"}w500${listTvShow[position].posterPath}")
                .into(holder.poster)
        }

        holder.cardItem.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.apply {
                putExtra("tvShow", listTvShow[position].id.toString())
                putExtra(TITLE, listTvShow[position].name)
            }
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val poster = itemView.iv_poster_list!!
        val cardItem = itemView.cv_list!!
        fun bindViewHolder(listTvShow: ItemList) {
            itemView.tv_title_list.text = listTvShow.name
        }
    }
}
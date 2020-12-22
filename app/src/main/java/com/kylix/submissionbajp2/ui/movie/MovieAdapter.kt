package com.kylix.submissionbajp2.ui.movie

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

class MovieAdapter(private val context: Context?): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

	private var listMovies: List<ItemList> = emptyList()
	fun addList(movieModel: List<ItemList>){
		this.listMovies = movieModel
		notifyDataSetChanged()
	}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
		ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

	override fun getItemCount(): Int = listMovies.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bindViewHolder(listMovies[position])
		context.let {
			Glide.with(it!!)
				.load("https://image.tmdb.org/t/p/w500${listMovies[position].posterPath}")
				.into(holder.poster)
		}

		holder.cardItem.setOnClickListener {
			val intent = Intent(context, DetailActivity::class.java)
			intent.apply {
				putExtra("movie", listMovies[position].id.toString())
				putExtra(TITLE, listMovies[position].title)
			}
			context?.startActivity(intent)
		}
	}

	inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
		val poster = itemView.iv_poster_list!!
		val cardItem = itemView.cv_list!!
		fun bindViewHolder(listMovies: ItemList) {
			itemView.tv_title_list.text = listMovies.title
		}
	}
}
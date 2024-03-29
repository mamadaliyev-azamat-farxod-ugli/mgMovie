package uz.mamadaliev.mimovie.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.mamadaliev.mimovie.data.genre.local.Genre
import uz.mamadaliev.mimovie.databinding.ItemGenreBinding

class GenreListAdapter : RecyclerView.Adapter<GenreListAdapter.MovieCardViewHolder>() {

    private var itemClickListener: ((id: Int, name: String) -> Unit)? = null

    fun setItemClickListener(f: (id: Int, name: String) -> Unit) {
        itemClickListener = f
    }

    var data = mutableListOf<Genre>()

    @SuppressLint("NotifyDataSetChanged")
    fun setGenres(nData: List<Genre>) {
        this.data.clear()
        this.data.addAll(nData)
        notifyDataSetChanged()
    }

    inner class MovieCardViewHolder(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Genre) {
            binding.apply {
                name.text = data.name
                Glide.with(binding.root.context)
                    .load("https://source.unsplash.com/random/?${data.name} films")
                    .into(binding.image)

                itemView.setOnClickListener {
                    itemClickListener?.invoke(data.id, data.name)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieCardViewHolder(
        ItemGenreBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MovieCardViewHolder, position: Int) =
        holder.bindData(data[position])
}
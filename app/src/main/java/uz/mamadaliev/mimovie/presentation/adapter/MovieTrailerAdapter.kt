package uz.mamadaliev.mimovie.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.mamadaliev.mimovie.data.movie_detail.model.remote.response.MovieTrailerResponse
import uz.mamadaliev.mimovie.databinding.ItemMovieTrailerBinding

class MovieTrailerAdapter : RecyclerView.Adapter<MovieTrailerAdapter.HomeMovieViewHolder>() {
    var _data = mutableListOf<MovieTrailerResponse>()

    private var itemClickListener: ((key: String) -> Unit)? = null

    fun setItemClickListener(f: (key: String) -> Unit) {
        itemClickListener = f
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTrailers(newData: List<MovieTrailerResponse>) {
        _data.clear()
        _data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class HomeMovieViewHolder(private val binding: ItemMovieTrailerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindView(data: MovieTrailerResponse) {
            binding.apply {
                Glide.with(binding.root.context)
                    .load("https://img.youtube.com/vi/${data.key}/mqdefault.jpg")
                    .into(binding.image)

                itemView.setOnClickListener {
                    itemClickListener?.invoke(data.key)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeMovieViewHolder(
            ItemMovieTrailerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int {
        if (_data.size > 2) {
            return 2
        } else {
            return _data.size;
        }
    }

    override fun onBindViewHolder(holder: HomeMovieViewHolder, position: Int) =
        holder.bindView(_data[position])
}
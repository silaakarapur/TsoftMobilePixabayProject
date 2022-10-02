package com.example.tsoftmobilepixabayproject.adapter

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.app.NotificationCompat.getColor
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tsoftmobilepixabayproject.R
import com.example.tsoftmobilepixabayproject.data.Hit
import com.example.tsoftmobilepixabayproject.databinding.ListCardViewBinding
import com.example.tsoftmobilepixabayproject.loadImage
import com.example.tsoftmobilepixabayproject.room.Favorite
import com.example.tsoftmobilepixabayproject.ui.HomeFragmentDirections
import com.example.tsoftmobilepixabayproject.viewmodel.FavoritesViewModel

class PhotoListAdapter(
    private var photoList: List<Hit>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<PhotoListAdapter.PhotoListVH>() {

    class PhotoListVH(val binding: ListCardViewBinding) : RecyclerView.ViewHolder(binding.root) {}

    fun filtering(newFilterlist: ArrayList<Hit>) {
        photoList = newFilterlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListVH {
        val view = ListCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoListVH(view)
    }


    // gelen görüntüleri recyclerview ile liste oluşturulduğundan imageview'a ve textView'e Gönderiyoruz
    override fun onBindViewHolder(holder: PhotoListVH, position: Int) {
        val viewModel: FavoritesViewModel? = null
        val data = photoList[position]
        var favorideger:Boolean
        with(holder.binding) {
            imageView.loadImage(photoList[position].previewURL)
            like.text =
                photoList[position].likes.toString() + "(" + photoList[position].comments.toString() + " Yorum)"
            views.text = photoList[position].views.toString() + " görüntülenme"
            imageView.setOnClickListener {
                itemClickListener.onClick(photoList[position])
            }
            favButton.setImageResource(R.drawable.favorite)
        }
        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data)
            Navigation.findNavController(it).navigate(action)


        }
        holder.binding.favButton.setOnClickListener {
            val image = holder.binding.imageView.loadImage(photoList[position].previewURL)
            val like = photoList[position].likes
            val views = photoList[position].views
            val comments=photoList[position].comments

            if (image.toString().isNotEmpty() || like.toString().isNotEmpty() || views.toString()
                    .isNotEmpty()
            ) {
                val data = Favorite(
                    null,
                    image = image.toString(),
                    like = like.toString(),
                    views = views.toString(),
                    comments = comments.toString()


                )
               holder.binding.favButton.setImageResource(R.drawable.favoritetrue)
                holder.binding.favButton.setOnClickListener {
                    holder.binding.favButton.setImageResource(R.drawable.favorite)
                    favorideger=false

                }
                //holder.binding.favButton.setBackgroundColor(Color.parseColor("#FEBE24"))
                println("database başarılı")
                viewModel?.addNotes(data)
                println("database başarılı" + data.views)


            }
        }

    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    interface ItemClickListener {
        fun onClick(data: Hit)
    }
}
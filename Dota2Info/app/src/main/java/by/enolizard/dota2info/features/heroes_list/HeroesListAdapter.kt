package by.enolizard.dota2info.features.heroes_list

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.enolizard.dota2info.R
import by.enolizard.dota2info.entities.Hero
import by.enolizard.dota2info.inflate
import by.enolizard.dota2info.loadImg
import kotlinx.android.synthetic.main.item_heroes.view.*

class HeroesListAdapter(private val itemClick: View.OnClickListener) : RecyclerView.Adapter<HeroesListAdapter.ViewHolder>() {

    private val items = ArrayList<Hero.Dto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(itemView = parent.inflate(R.layout.item_heroes))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    fun setData(body: List<Hero.Dto>) {
        items.clear()
        items.addAll(body)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivAvatar: ImageView = itemView.iv_hero_avatar_item
        private val tvName: TextView = itemView.tv_hero_name_item

        init {
            itemView.setOnClickListener(itemClick)
        }

        fun bind(item: Hero.Dto) {
            ivAvatar.loadImg(item.avatarUrl)
            tvName.text = item.name
        }
    }
}

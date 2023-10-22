package com.example.alicebianchi_rm86850.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alicebianchi_rm86850.model.BreedModel
import com.example.alicebianchi_rm86850.model.ICatApi
import com.example.alicebianchi_rm86850.databinding.GatinhosListItemBinding
import com.example.alicebianchi_rm86850.model.CatModel
import com.squareup.picasso.Picasso

class CatsAdapter(private val delegate: ICatApi):
    RecyclerView.Adapter<CatsAdapter.CatsViewHolder>(){

        private val catsItemsDetails: MutableList<BreedModel> = mutableListOf()
        private val catsItems: MutableList<CatModel> = mutableListOf()

    class CatsViewHolder(val itemHolder: GatinhosListItemBinding) :
            RecyclerView.ViewHolder(itemHolder.root) {
                fun bind(item: CatModel) {
                    Picasso.with(itemView.context).load(item.url).into(itemHolder.imgPicture1)
                    Picasso.with(itemView.context).load(item.url).into(itemHolder.imgPicture2)
                }

                fun bind2(item2: BreedModel) {

                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        return CatsViewHolder(
            GatinhosListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return catsItemsDetails.size
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        holder.bind2(catsItemsDetails[position])
        holder.itemHolder.itemCard.setOnClickListener {
            delegate.getCatDetails(catsItemsDetails[position])
        }
    }

    fun setList(newItems: List<BreedModel>) {
        catsItemsDetails.clear()
        catsItemsDetails.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addListItem(newItem: BreedModel) {
        catsItemsDetails.add(newItem)
        notifyItemInserted(catsItemsDetails.size)
    }

    fun removeListItem(removed: BreedModel) {
        val removedIndex = catsItemsDetails.indexOf(removed)
        catsItemsDetails.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, catsItemsDetails.size)
    }

    fun editListItem(newItem: BreedModel, position: Int) {
        catsItemsDetails[position] = newItem
        notifyItemChanged(position)
    }
}
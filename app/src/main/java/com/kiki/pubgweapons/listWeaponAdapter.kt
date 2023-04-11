package com.kiki.pubgweapons

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class listWeaponAdapter(private val listWeapon: ArrayList<Weapon>): RecyclerView.Adapter<listWeaponAdapter.listViewHolder>() {

    class listViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.imgWeapon)
        val tvName: TextView = itemView.findViewById(R.id.nameWeapon)
        val tvType: TextView = itemView.findViewById(R.id.typeWeapon)
        val tvAmmo : TextView = itemView.findViewById(R.id.Ammo)
        val tvDesc : TextView = itemView.findViewById(R.id.deskripsi)
        val tvMagazine : TextView = itemView.findViewById(R.id.Magazine)
        val tvRTime : TextView = itemView.findViewById(R.id.ReloadTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return listViewHolder(view)
    }

    override fun getItemCount(): Int = listWeapon.size

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val (name, type , ammo, desc, magazine, reloadTime, photo) = listWeapon[position]
        holder.tvName.text = name
        holder.tvType.text = type
        holder.tvAmmo.text = ammo
        holder.tvDesc.text = desc
        holder.tvMagazine.text = magazine
        holder.tvRTime.text = reloadTime

        holder.imgPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailWeapon::class.java)
            intentDetail.putExtra("key_weapon", listWeapon[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }


}



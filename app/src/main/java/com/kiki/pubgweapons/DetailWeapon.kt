package com.kiki.pubgweapons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailWeapon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_weapon)


        val dataWeapon = intent.getParcelableExtra<Weapon>("key_weapon")

        val tvDetailName : TextView = findViewById(R.id.name)
        val ivPhoto : ImageView = findViewById(R.id.Image)
        val tvType : TextView = findViewById(R.id.typeSenjata)
        val tvAmmo : TextView = findViewById(R.id.Ammo)
        val tvDesc : TextView = findViewById(R.id.desc)
        val tvMagazine : TextView = findViewById(R.id.Magazine)
        val tvRTime : TextView = findViewById(R.id.ReloadTime)

        tvDetailName.text = dataWeapon?.name
        tvType.text = dataWeapon?.type
        tvAmmo.text = dataWeapon?.ammo
        tvDesc.text = dataWeapon?.desc
        tvMagazine.text = dataWeapon?.magazine
        tvRTime.text = dataWeapon?.reloadTime

        if (dataWeapon != null) {
            ivPhoto.setImageResource(dataWeapon.image)
        }

    }
}
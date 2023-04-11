package com.kiki.pubgweapons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvWeapon: RecyclerView
    private val list = ArrayList<Weapon>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvWeapon = findViewById(R.id.rv_weapon)
        rvWeapon.setHasFixedSize(true)

        list.addAll(getListWeapon())
        showRecyclerList()
    }

    private fun getListWeapon(): ArrayList<Weapon> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataType = resources.getStringArray(R.array.data_type)
        val dataAmmo = resources.getStringArray(R.array.data_ammo)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataMagazine = resources.getStringArray(R.array.data_magazine)
        val dataReloadTime = resources.getStringArray(R.array.data_reloadTime)
        val dataPhoto = resources.obtainTypedArray(R.array.data_img)

        val listWeapon = ArrayList<Weapon>()
        for (i in dataName.indices) {
            val weapon = Weapon(dataName[i], dataType[i], dataAmmo[i], dataDesc[i], dataMagazine[i], dataReloadTime[i], dataPhoto.getResourceId(i, -1))
            listWeapon.add(weapon)
        }
        return listWeapon
    }

    private fun showRecyclerList() {
        rvWeapon.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = listWeaponAdapter(list)
        rvWeapon.adapter = listHeroAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                val moveIntent = Intent(this@MainActivity, Profile::class.java)
                startActivity(moveIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
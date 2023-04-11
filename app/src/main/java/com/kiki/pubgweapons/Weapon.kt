package com.kiki.pubgweapons

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Weapon (
    var name : String,
    var type : String,
    var ammo : String,
    var desc : String,
    var magazine : String,
    var reloadTime : String,
    var image : Int
) : Parcelable

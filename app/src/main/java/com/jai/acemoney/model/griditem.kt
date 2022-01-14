package com.jai.acemoney.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class griditem (
    var image: Int ?=0,
    var name:String ?= null
        ):Parcelable


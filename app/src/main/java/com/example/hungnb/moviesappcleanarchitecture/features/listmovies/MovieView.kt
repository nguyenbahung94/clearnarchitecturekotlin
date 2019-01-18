package com.example.hungnb.moviesappcleanarchitecture.features.listmovies

import android.os.Parcel
import com.example.hungnb.moviesappcleanarchitecture.core.platform.KParcelable
import com.example.hungnb.moviesappcleanarchitecture.core.platform.parcelableCreator


data class MovieView(val id: Int, val poster: String) : KParcelable {
    companion object {
        @JvmField val CREATOR = parcelableCreator(::MovieView)
    }

    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readString())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest) {
            writeInt(id)
            writeString(poster)
        }
    }
}

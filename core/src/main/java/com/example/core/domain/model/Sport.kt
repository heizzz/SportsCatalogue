package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sport(
    val sportId: String,
    val name: String,
    val format: String,
    val thumb: String,
    val thumbGreen: String,
    val description: String,
    val isFavorite: Boolean
) : Parcelable
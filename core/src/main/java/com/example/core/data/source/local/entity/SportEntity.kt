package com.example.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sport")
data class SportEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "sportId")
    var sportId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "format")
    var format: String,

    @ColumnInfo(name = "thumb")
    var thumb: String,

    @ColumnInfo(name = "thumbGreen")
    var thumbGreen: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
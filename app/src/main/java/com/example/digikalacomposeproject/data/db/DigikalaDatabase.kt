package com.example.digikalacomposeproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.digikalacomposeproject.data.model.basket.CartItem

@Database(entities = [CartItem::class], version = 1, exportSchema = false)
abstract class DigikalaDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}
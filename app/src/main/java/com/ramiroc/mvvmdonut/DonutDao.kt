package com.ramiroc.mvvmdonut

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface DonutDao {

    @Insert
    suspend fun insert(donut:Donut)

    @Update
    suspend fun update(donut: Donut)

    @Delete
    suspend fun delete(donut: Donut)

    @Query("SELECT * FROM donut_table WHERE donutId= :donutId")
    fun get(donutId: Long): LiveData<Donut>

    @Query("SELECT * FROM donut_table ORDER BY donutId DESC")
    fun getAll(): LiveData<List<Donut>>
}
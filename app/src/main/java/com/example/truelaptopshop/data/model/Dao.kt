package com.example.truelaptopshop.data.model


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.truelaptopshop.data.model.Entity.LaptopDBEntity

@Dao
interface LaptopDao {
    @Insert(entity = LaptopDBEntity::class)
    fun insertNewStatisticData(statistic: LaptopDBEntity)

    @Query("SELECT laptops.id, laptops.info FROM laptops")
    fun getAllStatisticData(): List<LaptopInfoTuple>

    @Query("DELETE FROM laptops WHERE id = :laptopId")
    fun deleteStatisticDataById(laptopId: Long)
}
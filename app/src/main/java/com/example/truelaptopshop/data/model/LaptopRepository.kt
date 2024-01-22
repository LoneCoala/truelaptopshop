package com.example.truelaptopshop.data.model


import com.example.truelaptopshop.data.model.Entity.LaptopDBEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LaptopRepository(private val laptopDao: LaptopDao) {
    suspend fun insertNewLaptopData(laptopDBEntity: LaptopDBEntity) {
        withContext(Dispatchers.IO) {
            laptopDao.insertNewStatisticData(laptopDBEntity)
        }
    }

    suspend fun getAllLaptopData(): List<LaptopInfoTuple> {
        return withContext(Dispatchers.IO) {
            return@withContext laptopDao.getAllStatisticData()
        }
    }

    suspend fun removeLaptopDataById(id: Long) {
        withContext(Dispatchers.IO) {
            laptopDao.deleteStatisticDataById(id)
        }
    }
}
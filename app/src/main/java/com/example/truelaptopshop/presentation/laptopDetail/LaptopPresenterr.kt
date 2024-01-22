package com.example.truelaptopshop.presentation.laptopDetail

import android.content.Intent
import com.example.truelaptopshop.domain.interactors.LoadDataUseCase
import com.example.truelaptopshop.domain.interactors.OnCartClickedUseCase

class LaptopPresenterr(private val view: LaptopContract.View) : LaptopContract.Presenter {
    private val repository: LaptopContract.Repository = LaptopRepository()
    val loadDataUseCase = LoadDataUseCase(view)
    val onCartClickedUseCase = OnCartClickedUseCase(view)

    override fun loadData(intent: Intent) {
        loadDataUseCase.execute(intent)
    }

    override fun onCartClicked() {
        onCartClickedUseCase.execute()
    }
}
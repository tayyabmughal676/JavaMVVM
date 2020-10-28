package com.example.jmvvm.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.jmvvm.models.Product;
import com.example.jmvvm.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    //    Shop Repo
    ShopRepo shopRepo = new ShopRepo();
    public LiveData<List<Product>> getProduct() {
//        Get Product from Shop Repo.
        return shopRepo.getProducts();
    }
}

package com.example.jmvvm.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jmvvm.models.Product;
import com.example.jmvvm.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    //    Shop Repo
    ShopRepo shopRepo = new ShopRepo();
    MutableLiveData<Product> mutableProduct = new MutableLiveData<>();

    public LiveData<List<Product>> getProducts() {
//        Get Product from Shop Repo.
        return shopRepo.getProducts();
    }

    public void setProduct(Product product) {
        mutableProduct.setValue(product);
    }

    public LiveData<Product> getProduct(){
        return mutableProduct;
    }
}

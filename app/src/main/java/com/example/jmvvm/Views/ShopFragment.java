package com.example.jmvvm.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jmvvm.adapters.ShopListAdapter;
import com.example.jmvvm.models.Product;
import com.example.jmvvm.databinding.FragmentShopBinding;
import com.example.jmvvm.viewModel.ShopViewModel;

import java.util.List;

public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {
    //    Fragment Shop Binding.
    FragmentShopBinding fragmentShopBinding;
    //    Shop List Adapter.
    private ShopListAdapter shopListAdapter;
    //    Show View Model.
    private ShopViewModel shopViewModel;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding = FragmentShopBinding.inflate(inflater, container, false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//      Shop List Adapter
        shopListAdapter = new ShopListAdapter();
        fragmentShopBinding.shopRecyclerView.setAdapter(shopListAdapter);
//        Shop View Model
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getProduct().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
//                submit list to Adapter
                shopListAdapter.submitList(products);
            }
        });
    }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {

    }
}
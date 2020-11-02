package com.example.jmvvm.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jmvvm.R;
import com.example.jmvvm.adapters.ShopListAdapter;
import com.example.jmvvm.models.Product;
import com.example.jmvvm.databinding.FragmentShopBinding;
import com.example.jmvvm.viewModel.ShopViewModel;

import java.util.List;

public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {
    private static final String TAG = "ShopProductList";
    //    Fragment Shop Binding.
    FragmentShopBinding fragmentShopBinding;
    //    Shop List Adapter.
    private ShopListAdapter shopListAdapter;
    //    Show View Model.
    private ShopViewModel shopViewModel;
//     Navi controller
    private NavController navController;

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
        shopListAdapter = new ShopListAdapter(this);
        fragmentShopBinding.shopRecyclerView.setAdapter(shopListAdapter);
//        Navi Controller
        navController = Navigation.findNavController(view);

//        Divided Line View
        fragmentShopBinding
                .shopRecyclerView
                .addItemDecoration(
                        new DividerItemDecoration(
                                requireContext(),
                                DividerItemDecoration.VERTICAL
                        )
                );
        fragmentShopBinding
                .shopRecyclerView
                .addItemDecoration(
                        new DividerItemDecoration(
                                requireContext(),
                                DividerItemDecoration.HORIZONTAL
                        )
                );
//        Shop View Model
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
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
        shopViewModel.setProduct(product);
        navController.navigate(R.id.action_shopFragment_to_productDetailFragment);
    }
}
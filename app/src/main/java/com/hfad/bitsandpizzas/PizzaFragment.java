package com.hfad.bitsandpizzas;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {


    public PizzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //this code we used when this class extended the list fragment class
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1,
//                getResources().getStringArray(R.array.pizzas));
//        setListAdapter(adapter);
//        return super.onCreateView(inflater, container, savedInstanceState);

        RecyclerView pizzaRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++){
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < pizzaImages.length; i++){
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames,pizzaImages);
        pizzaRecyclerView.setAdapter(adapter);
        GridLayoutManager grid = new GridLayoutManager(getActivity(), 2);
        pizzaRecyclerView.setLayoutManager(grid);
        return pizzaRecyclerView;
    }

}

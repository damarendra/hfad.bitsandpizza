package com.hfad.bitsandpizza;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.bitsandpizza.adapter.CaptionImagesAdapter;
import com.hfad.bitsandpizza.data.Pizza;

public class PizzaFragment extends Fragment {

    public PizzaFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                inflater.getContext(),
//                android.R.layout.simple_list_item_1,
//                getResources().getStringArray(R.array.pizzas)
//        );
//        setListAdapter(adapter);

        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_pizza,
                container,
                false
        );

        int[] pizzaImages= new int[Pizza.pizzas.length];
        String[] pizzaCaptions = new String[Pizza.pizzas.length];

        for(int i = 0; i < Pizza.pizzas.length; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImage();
            pizzaCaptions[i] = Pizza.pizzas[i].getName();
            Log.d("damn", "+"+pizzaImages[i]);
            Log.d("damn", "+"+pizzaCaptions[i]);
        }

        CaptionImagesAdapter captionImagesAdapter = new CaptionImagesAdapter(
                pizzaCaptions,
                pizzaImages
        );

        pizzaRecycler.setAdapter(captionImagesAdapter);
        pizzaRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return pizzaRecycler;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
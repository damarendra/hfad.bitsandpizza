package com.hfad.bitsandpizza;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.bitsandpizza.adapter.CaptionImagesAdapter;
import com.hfad.bitsandpizza.data.Pizza;

public class PizzaFragment extends Fragment implements CaptionImagesAdapter.CaptionImagesAdapterOnClickListener {

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
        }

        CaptionImagesAdapter captionImagesAdapter = new CaptionImagesAdapter(
                pizzaCaptions,
                pizzaImages
        );
        captionImagesAdapter.setCaptionImagesViewHolderListener(this);

        pizzaRecycler.setAdapter(captionImagesAdapter);
        pizzaRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return pizzaRecycler;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
        intent.putExtra(PizzaDetailActivity.PIZZA_DETAIL_ID, position);
        getActivity().startActivity(intent);
    }
}
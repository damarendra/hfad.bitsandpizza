package com.hfad.bitsandpizza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.bitsandpizza.adapter.CaptionImagesAdapter;
import com.hfad.bitsandpizza.data.Pasta;

public class PastaFragment extends Fragment {

    public PastaFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                inflater.getContext(),
//                android.R.layout.simple_list_item_1,
//                getResources().getStringArray(R.array.pastas)
//        );
//        setListAdapter(adapter);

        RecyclerView pastaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_pasta,
                container,
                false
        );

        int[] pastaImages = new int[Pasta.pastas.length];
        String[] pastaCaptions = new String[Pasta.pastas.length];

        for(int i=0;i<Pasta.pastas.length;i++) {
            pastaImages[i] = Pasta.pastas[i].getImage();
            pastaCaptions[i] = Pasta.pastas[i].getName();
        }

        CaptionImagesAdapter captionImagesAdapter = new CaptionImagesAdapter(
            pastaCaptions,
            pastaImages
        );
        pastaRecycler.setAdapter(captionImagesAdapter);

        pastaRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));

//        return super.onCreateView(inflater, container, savedInstanceState);
        return pastaRecycler;
    }

}
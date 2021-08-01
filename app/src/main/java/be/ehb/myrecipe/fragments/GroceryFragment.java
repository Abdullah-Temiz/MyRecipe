package be.ehb.myrecipe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.ehb.myrecipe.R;

public class GroceryFragment extends Fragment {

    public GroceryFragment() {

    }

    public static GroceryFragment newInstance() {
        GroceryFragment fragment = new GroceryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grocery, container, false);
    }
}
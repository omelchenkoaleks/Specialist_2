package com.omelchenkoaleks.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logger.logMe();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logMe();

        Log.d("happy", "onCreate " + hashCode());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        Logger.logMe();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.logMe();
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.logMe();
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.logMe();
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.logMe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.logMe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.logMe();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.logMe();
    }
}

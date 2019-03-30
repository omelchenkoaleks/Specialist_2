package com.omelchenkoaleks.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    public static final String PARAMETER = "parameter";
    private TextView mParameter;

    // этот код будет работать в Activity (Bundle) это передатчик
    public static MyFragment getInstance(String parameter) {
        Bundle bundleForFragment = new Bundle();
        bundleForFragment.putString(PARAMETER, parameter);

        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(bundleForFragment);

        return myFragment;
    }

    // этот код работает внутри (здесь во фрагменте) Bundle - это приемник
    private String getParameter() {
        Bundle bundleForFragment = getArguments();
        if (bundleForFragment != null && bundleForFragment.containsKey(PARAMETER)) {
            return bundleForFragment.getString(PARAMETER);
        }
        return "no parameter";
    }

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

        mParameter = view.findViewById(R.id.parameter_tv);

        mParameter.setText(getParameter());

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

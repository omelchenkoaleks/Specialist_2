package com.omelchenkoaleks.viewpager;

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

    public static MyFragment getInstance(String parameter) {
        Bundle bundleForFragment = new Bundle();
        bundleForFragment.putString(PARAMETER, parameter);
        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(bundleForFragment);
        return myFragment;
    }

    private String getParameter() {
        Bundle bundleForFragment = getArguments();
        if (bundleForFragment != null && bundleForFragment.containsKey(PARAMETER)) {
            return bundleForFragment.getString(PARAMETER);
        }
        return "no parameter";
    }

    public void setMessage(String msg) {
        if (mParameter != null)
            mParameter.setText(mParameter.getText().toString() + " | " + msg);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logMe();

        /**
         * Если использовать этот метод, то операционная система не просто сохранит фрагмент,
         * а сохранит тот же самый объект ...
         */
        setRetainInstance(true);

        Log.d("happy", "MyFragment onCreate " + hashCode());
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
    public void onDestroyView() {
        super.onDestroyView();
        /**
         * Обнуляем:
         *    Во-первых, чтобы не было утечки памяти
         *    Во- вторых, чтобы мы работали с ресурсами только тогда, когда это возоможно
         */
        mParameter = null;
    }
}

package com.omelchenkoaleks.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private Button mClickSave;
    private TextView mTextSave;
    private MyTask myTask;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // этим методом мы говорим, что не нужно фрагмент уничтожать вместе
        // с активити - его нужно сохрнить
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_my, container, false);

        mTextSave = viewFragment.findViewById(R.id.text_fragment_tv);
        mClickSave = viewFragment.findViewById(R.id.button_fragment_bt);
        mClickSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask = new MyTask();
                myTask.execute(3, 4);
            }
        });

        return viewFragment;
    }

    public class MyTask extends AsyncTask<Integer, Void, String> {
        @Override
        protected String doInBackground(Integer... params) {
            Integer a = params[0];
            Integer b = params[1];

            System.out.println("doInBackground "
                    + Thread.currentThread().getName()
                    + " "
                    + Thread.currentThread().getId());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int c = a + b;
            return "Summ " + c;
        }

        @Override
        protected void onPostExecute(String sum) {
            System.out.println("onPostExecute "
                    + Thread.currentThread().getName()
                    + " "
                    + Thread.currentThread().getId());

            if (mTextSave != null)
                mTextSave.setText(sum);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mTextSave = null;
        mClickSave = null;
    }
}

package com.omelchenkoaleks.adapterexperiment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {
    /*
    чтобы адаптер мого работать с данными ему эти данные как-то надо передать:
    1, переменная будет хранить ссылку на массив данных ...
    2, метод будет записывать (передавать) данные ...
     */
    private String[] mData;
    private LayoutInflater mLayoutInflater;

    public void setData(String[] newData) {
        mData = newData;
    }

    @Override
    public int getCount() {
        if (mData != null) {
            return mData.length;
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mLayoutInflater == null) {
            mLayoutInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        /*
        ОПТИМИЗАЦИЯ №1 - лучше использовать параметр convertView для того, чтобы при пролистывании
        наши вью не нагружали (своим создание и уничтожением) сборщик мусора, а переиспользовались ...
         */

        // ВМЕСТО:
//        View itemView = mLayoutInflater.inflate(R.layout.item, parent, false);

        // ОПТИМИЗИРУЕМ:
        View itemView;
        if (convertView == null) {
            itemView = mLayoutInflater.inflate(R.layout.item, parent, false);
        } else {
            itemView = convertView;
        }


        TextView data_1 = itemView.findViewById(R.id.data_1_tv);
        TextView data_2 = itemView.findViewById(R.id.data_2_tv);
        TextView data_3 = itemView.findViewById(R.id.data_3_tv);

        String item = (String) getItem(position);
        data_1.setText(item);
        data_2.setText(item.toUpperCase());
        data_3.setText(item.toLowerCase());

        return itemView;
    }
}

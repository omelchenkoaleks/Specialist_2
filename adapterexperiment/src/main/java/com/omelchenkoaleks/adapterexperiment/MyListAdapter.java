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
    private String[] mData = new String[0];
    private LayoutInflater mLayoutInflater;

    void setData(String[] newData) {
        mData = newData;
        notifyDataSetChanged();
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
        MyHolder holder;
        if (convertView == null) {
            itemView = mLayoutInflater.inflate(R.layout.item, parent, false);
            TextView data_1 = itemView.findViewById(R.id.data_1_tv);
            final TextView data_2 = itemView.findViewById(R.id.data_2_tv);
            TextView data_3 = itemView.findViewById(R.id.data_3_tv);
            holder = new MyHolder(data_1, data_2, data_3);

            // фокусик = скрываем один из view ...
            data_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data_2.getVisibility() == View.VISIBLE) {
                        data_2.setVisibility(View.GONE);
                    } else {
                        data_2.setVisibility(View.VISIBLE);
                    }
                }
            });

            /*
            метод setTag() можно назвать нычкой, куда можно положить один объект
            для будущего использования ...
             */
            itemView.setTag(holder);
        } else {
            itemView = convertView;
            // здесь мы извлекаем холдер (созданный для будущего использования) ...
            holder = (MyHolder) convertView.getTag();
        }

        String item = (String) getItem(position);
        holder.data_1.setText(item);
        holder.data_2.setText(item.toUpperCase());
        holder.data_3.setText(item.toLowerCase());

        return itemView;
    }

    /*
    ОПТИМИЗАЦИЯ №2 - нужна для того, чтобы не пересоздавать (бегая по дереву методом findViewById)
    и расходуя ресурсы, объекты а инициализировать их сразу в созданном классе ...
     */
    public static final class MyHolder {
        MyHolder(TextView data_1, TextView data_2, TextView data_3) {
            this.data_1 = data_1;
            this.data_2 = data_2;
            this.data_3 = data_3;
        }

        TextView data_1;
        TextView data_2;
        TextView data_3;
    }
}

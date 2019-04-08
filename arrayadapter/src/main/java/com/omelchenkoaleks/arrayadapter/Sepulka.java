package com.omelchenkoaleks.arrayadapter;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Categories", id = BaseColumns._ID)
public class Sepulka extends Model {

    @Column(name = "foo")
    public String foo;

    @Column(name = "bar")
    public String bar;
}

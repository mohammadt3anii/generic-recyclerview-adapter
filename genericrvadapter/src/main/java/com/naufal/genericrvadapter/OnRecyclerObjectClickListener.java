package com.naufal.genericrvadapter;

/**
 * Created by Naufal on 03/02/2018.
 */

public interface OnRecyclerObjectClickListener<T> extends BaseRecyclerListener {
    void onItemClicked(T item);
}

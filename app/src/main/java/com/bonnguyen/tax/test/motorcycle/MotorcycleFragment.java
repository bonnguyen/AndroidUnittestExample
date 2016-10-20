package com.bonnguyen.tax.test.motorcycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bonnguyen.tax.test.BaseFragment;
import com.bonnguyen.tax.test.R;

/**
 * Created by nguyenbon on 10/18/16.
 */

public class MotorcycleFragment extends BaseFragment implements MotorcycleView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motorcycle, container, false);
        setRootView(view);

        mPresenter = new MotorcyclePresenterImpl(this);
        return view;
    }
}

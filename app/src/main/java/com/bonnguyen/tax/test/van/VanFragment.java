package com.bonnguyen.tax.test.van;

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

public class VanFragment extends BaseFragment implements VanView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_van, container, false);
        setRootView(view);

        mPresenter = new VanPresenterImpl(this);
        edtValue.setHint("Enter weight");
        btnCalcTax.setHint("Calc Tax Van");
        tvResult.setHint("Tax result van");
        return view;
    }
}

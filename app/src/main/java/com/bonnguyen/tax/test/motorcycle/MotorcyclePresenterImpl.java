package com.bonnguyen.tax.test.motorcycle;

import android.text.TextUtils;

import com.bonnguyen.tax.test.BasePresenter;

/**
 * Created by nguyenbon on 10/18/16.
 */

public class MotorcyclePresenterImpl implements BasePresenter {

    protected MotorcycleView mMotorcycleView;
    protected MotorcycleInteractorImpl mMotorcycleInteractorImpl;

    public MotorcyclePresenterImpl(MotorcycleView motorcycleView) {
        this.mMotorcycleView = motorcycleView;
        this.mMotorcycleInteractorImpl = new MotorcycleInteractorImpl();
    }

    @Override
    public void validate(String value) {
        if (TextUtils.isEmpty(value)) {
            mMotorcycleView.setEdittextError();
        } else {
            mMotorcycleInteractorImpl.setEngine(Long.parseLong(value));
            mMotorcycleView.displayTaxResult(mMotorcycleInteractorImpl.calcTax());
        }
    }
}

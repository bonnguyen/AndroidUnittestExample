package com.bonnguyen.tax.test.car;

import android.text.TextUtils;

/**
 * Created by nguyenbon on 10/18/16.
 */

public class CarPresenterImpl implements CarPresenter {

    protected CarView mCarView;
    protected CarInteractorImpl mCarInteractorImpl;

    public CarPresenterImpl(CarView carView) {
        this.mCarView = carView;
        this.mCarInteractorImpl = new CarInteractorImpl();
    }

    @Override
    public void validate(String value) {
        if (TextUtils.isEmpty(value)) {
            mCarView.setEdittextError();
        } else {
            long registered = mCarInteractorImpl.getRegistered();
            if (registered < 2002) {
                validateEngine();
            } else {
                validateEmission();
            }
        }
    }

    @Override
    public void checkRegistered(String value) {
        if (TextUtils.isEmpty(value)) {
            mCarView.hiddenEdittextEmission();
            mCarView.hiddenEdittextEngine();
        } else {
            long registered = Long.parseLong(value);
            mCarInteractorImpl.setRegistered(registered);
            if (registered < 2002) {
                mCarView.hiddenEdittextEmission();
                mCarView.showEdittextEngine();
            } else {
                mCarView.hiddenEdittextEngine();
                mCarView.showEdittextEmission();
            }
        }
    }

    private void validateEngine() {
        if (TextUtils.isEmpty(mCarView.getEngineValue())) {
            mCarView.setEdittextEngineError();
            return;
        } else {
            mCarInteractorImpl.setEngine(Long.parseLong(mCarView.getEngineValue()));
        }
        mCarView.displayTaxResult(mCarInteractorImpl.calcTax());
    }

    private void validateEmission() {
        if (TextUtils.isEmpty(mCarView.getEmissionValue())) {
            mCarView.setEdittextEmissionError();
            return;
        } else {
            mCarInteractorImpl.setEmission(Long.parseLong(mCarView.getEmissionValue()));
        }
        mCarView.displayTaxResult(mCarInteractorImpl.calcTax());
    }
}

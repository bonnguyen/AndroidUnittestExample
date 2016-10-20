package com.bonnguyen.tax.test.van;

import android.text.TextUtils;

import com.bonnguyen.tax.test.BasePresenter;

/**
 * Created by nguyenbon on 10/18/16.
 */

public class VanPresenterImpl implements BasePresenter {

    protected VanView mVanView;
    protected VanInteractorImpl mVanInteractorImpl;

    public VanPresenterImpl(VanView vanView) {
        this.mVanView = vanView;
        this.mVanInteractorImpl = new VanInteractorImpl();
    }

    @Override
    public void validate(String value) {
        if (TextUtils.isEmpty(value)) {
            mVanView.setEdittextError();
        } else {
            mVanInteractorImpl.setWeight(Long.parseLong(value));
            mVanView.displayTaxResult(mVanInteractorImpl.calcTax());
        }
    }
}

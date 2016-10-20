package com.bonnguyen.tax.test;

import android.view.View;

/**
 * Created by nguyenbon on 10/18/16.
 */

public interface BaseView {
    void setRootView(View rootView);

    void setEdittextError();

    void displayTaxResult(long tax);
}

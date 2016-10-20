package com.bonnguyen.tax.test;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by nguyenbon on 10/18/16.
 */

public abstract class BaseFragment extends Fragment implements BaseView, View.OnClickListener {

    protected BasePresenter mPresenter;

    protected EditText edtValue;
    protected Button btnCalcTax;
    protected TextView tvResult;

    @Override
    public void setRootView(View rootView) {
        edtValue = (EditText) rootView.findViewById(R.id.edt_value);
        btnCalcTax = (Button) rootView.findViewById(R.id.btn_calc);
        tvResult = (TextView) rootView.findViewById(R.id.tv_result);

        btnCalcTax.setOnClickListener(this);
    }

    @Override
    public void setEdittextError() {
        edtValue.setError("Value cannot be empty");
    }

    @Override
    public void displayTaxResult(long tax) {
        tvResult.setText(String.valueOf(tax));
    }

    @Override
    public void onClick(View view) {
        if (mPresenter != null) {
            mPresenter.validate(edtValue.getText().toString().trim());
        }
    }
}

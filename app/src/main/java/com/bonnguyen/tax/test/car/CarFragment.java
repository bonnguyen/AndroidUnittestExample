package com.bonnguyen.tax.test.car;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bonnguyen.tax.test.BaseFragment;
import com.bonnguyen.tax.test.R;

/**
 * Created by nguyenbon on 10/18/16.
 */

public class CarFragment extends BaseFragment implements CarView, TextWatcher {

    private View llEngine;
    private View llEmission;
    private EditText edtEngine;
    private EditText edtEmission;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);
        setRootView(view);

        mPresenter = new CarPresenterImpl(this);
        return view;
    }

    @Override
    public void setRootView(View rootView) {
        super.setRootView(rootView);
        llEngine = rootView.findViewById(R.id.ll_engine);
        llEmission = rootView.findViewById(R.id.ll_emission);
        edtEngine = (EditText) rootView.findViewById(R.id.edt_engine);
        edtEmission = (EditText) rootView.findViewById(R.id.edt_emission);

        edtValue.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (mPresenter != null && mPresenter instanceof CarPresenterImpl) {
            ((CarPresenterImpl) mPresenter).checkRegistered(editable.toString().trim());
        }
    }

    @Override
    public void showEdittextEngine() {
        edtEngine.setEnabled(true);
        llEngine.setVisibility(View.VISIBLE);
    }

    @Override
    public void hiddenEdittextEngine() {
        edtEngine.setEnabled(false);
        llEngine.setVisibility(View.GONE);
    }

    @Override
    public void showEdittextEmission() {
        edtEmission.setEnabled(true);
        llEmission.setVisibility(View.VISIBLE);
    }

    @Override
    public void hiddenEdittextEmission() {
        edtEmission.setEnabled(false);
        llEmission.setVisibility(View.GONE);
    }

    @Override
    public void setEdittextEngineError() {
        edtEngine.setError("Value cannot be empty");
    }

    @Override
    public void setEdittextEmissionError() {
        edtEmission.setError("Value cannot be empty");
    }

    @Override
    public String getEngineValue() {
        return edtEngine.getText().toString().trim();
    }

    @Override
    public String getEmissionValue() {
        return edtEmission.getText().toString().trim();
    }
}

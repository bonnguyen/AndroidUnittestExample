package com.bonnguyen.tax.test.car;

import com.bonnguyen.tax.test.BaseView;

/**
 * Created by nguyenbon on 10/18/16.
 */

public interface CarView extends BaseView {
    void showEdittextEngine();

    void hiddenEdittextEngine();

    void showEdittextEmission();

    void hiddenEdittextEmission();

    void setEdittextEngineError();

    void setEdittextEmissionError();

    String getEngineValue();

    String getEmissionValue();
}

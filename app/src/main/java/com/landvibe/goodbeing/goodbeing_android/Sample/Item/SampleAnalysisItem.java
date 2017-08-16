package com.landvibe.goodbeing.goodbeing_android.Sample.Item;

/**
 * Created by KSM on 2017-08-12.
 */

public class SampleAnalysisItem {
    private String analysis_item;
    private String analysis_exposure;
    private String analysis_result;

    public SampleAnalysisItem(String analysis_item, String analysis_exposure, String analysis_result) {
        this.analysis_item = analysis_item;
        this.analysis_exposure = analysis_exposure;
        this.analysis_result = analysis_result;
    }

    public String getAnalysis_item() {
        return analysis_item;
    }

    public void setAnalysis_item(String analysis_item) {
        this.analysis_item = analysis_item;
    }

    public String getAnalysis_exposure() {
        return analysis_exposure;
    }

    public void setAnalysis_exposure(String analysis_exposure) {
        this.analysis_exposure = analysis_exposure;
    }

    public String getAnalysis_result() {
        return analysis_result;
    }

    public void setAnalysis_result(String analysis_result) {
        this.analysis_result = analysis_result;
    }
}

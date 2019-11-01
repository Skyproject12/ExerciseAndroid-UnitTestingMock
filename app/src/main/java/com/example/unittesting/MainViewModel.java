package com.example.unittesting;


// make ViewModel Test use CTRL+SHIF+T
public class MainViewModel {
    private CuboiModel cuboiModel;

    public MainViewModel(CuboiModel cuboiModel) {
        this.cuboiModel = cuboiModel;
    }
    // call method save from cuboiModel
    void save(double l, double w, double h){
        cuboiModel.Save(l,w,h);
    }
    // get fungtion from cuboiModel
    double getCircumference(){
        return cuboiModel.getCircumference();
    }
    // get fungtion surface from cuboiModel
    double getSurfaceArea(){
        return cuboiModel.getSurfaceArea();
    }
    // get function Volume
    double getVolume(){
        return cuboiModel.getVolume();
    }
}

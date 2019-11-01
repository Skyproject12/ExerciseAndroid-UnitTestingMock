package com.example.unittesting;

import org.junit.Before;

import static org.mockito.Mockito.mock;

// make init testing use mokito
public class MainViewModelTest {
    private MainViewModel mainViewModel;
    private CuboiModel cuboiModel;
    @Before
    public void before(){
        cuboiModel= mock(CuboiModel.class);
    }
}
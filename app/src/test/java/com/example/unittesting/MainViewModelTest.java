package com.example.unittesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// make init testing use mokito
public class MainViewModelTest {
    private MainViewModel mainViewModel;
    private CuboiModel cuboiModel;
    private double dummyVolume=500.0;
    private double dummyLength=12.0;
    private double dummyWidth=7.0;
    private double dummyHeight=6.0;
    private double dummySurfaceArea=396.0;
    @Before
    public void before(){
        cuboiModel= mock(CuboiModel.class);
        mainViewModel= new MainViewModel(cuboiModel);
    }
    @Test
    public void testVolume(){
        cuboiModel= new CuboiModel();
        mainViewModel= new MainViewModel(cuboiModel);
        // set valeu function save from viewmodel
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        // getVolume from viewmodel
        double volume= mainViewModel.getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }
    @Test
    public void testCircumference(){
        cuboiModel= new CuboiModel();
        mainViewModel= new MainViewModel(cuboiModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double volume= mainViewModel.getCircumference();
        assertEquals(volume, 0.0001);
    }
    @Test
    public void testSurfaceArea(){
        cuboiModel= new CuboiModel();
        mainViewModel= new MainViewModel(cuboiModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double volume= mainViewModel.getSurfaceArea();
        assertEquals(dummySurfaceArea, volume, 0.0001);
    }
    @Test
    public void testMockVolume(){
        // ketika viewmodel getvolume sama dengan dummy volume
        when(mainViewModel.getVolume()).thenReturn(dummyVolume);
        double volume= mainViewModel.getVolume();
        verify(cuboiModel).getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }
    @Test
    public void testMockCircumference(){
        when(mainViewModel.getCircumference()).thenReturn(100.0);
        double volume= mainViewModel.getCircumference();
        verify(cuboiModel).getCircumference();
        assertEquals( volume, 0.0001);
    }
    @Test
    public void testMockSurfaceArea(){
        when(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea);
        // get value of volume use viewmodel
        double volume= mainViewModel.getSurfaceArea();
        verify(cuboiModel).getSurfaceArea();
        // check value is same or not
        assertEquals(dummySurfaceArea, volume, 0.0001);
    }
}
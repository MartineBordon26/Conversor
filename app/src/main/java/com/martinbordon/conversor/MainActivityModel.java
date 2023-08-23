package com.martinbordon.conversor;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Integer> activeField = new MutableLiveData<>(1);
    private MutableLiveData<Double> conversionMutalbe;

    public MainActivityModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Integer> getActiveField() {
        return activeField;
    }

    public void setActiveField(int fieldNumber) {
        activeField.setValue(fieldNumber);
    }

    public LiveData<Double> getConversionMutalbe() {
        if (conversionMutalbe == null) {
            conversionMutalbe = new MutableLiveData<>();
        }
        return conversionMutalbe;
    }



  /*  public void conversor(String dato1, String dato2 ) {

        if(moneda.equals("dolar")) {
            dinero *= 720;
        } else {
            dinero /= 720;
        }
        return dinero;
    }*/

    public int pesosADolar(int dinero) {
        return dinero *= 730;
    }
    public int dolarAPesos(int dinero) {
        return dinero /= 730;
    }
}

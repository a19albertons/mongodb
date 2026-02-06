package com.example;

import com.example.controller.ControladorGeneral;
import com.example.utils.MongoProviderSingleton;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MongoProviderSingleton mongoProviderSingleton = MongoProviderSingleton.getInstance();
        ControladorGeneral controladorGeneral = new ControladorGeneral(mongoProviderSingleton);
        controladorGeneral.inicializar();
        mongoProviderSingleton.close();

    }
}

package com.kam.weather.util;

import java.io.IOException;

public class TestThrows {

    public void printMessage() throws NumberFormatException {
        System.out.println("hello");
    }

    public void callPrintMessage(){
        printMessage();
    }

    public void callPrintMessageTryCatch(){
        try{
            printMessage();
        }catch (Exception e){

        }
    }

}

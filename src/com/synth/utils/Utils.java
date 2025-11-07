package com.synth.utils;

public class Utils {

    public static void invokeProcedure(Procedure procedure, boolean printStackTrace) {
        try {
            procedure.invoke();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

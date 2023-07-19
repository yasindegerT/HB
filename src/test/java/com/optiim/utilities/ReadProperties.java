package com.optiim.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    static Properties prop;
    static {
    prop = new Properties();


        try{
            FileInputStream file = new FileInputStream("manage.properties");
            prop.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("problem on \"manage.properties\" check it!");
        }
    }

    public static String getProperty(String keyword){
        return prop.getProperty(keyword);
    }

    public static String getBrowser(){
        return getProperty("browser");
    }

    public static boolean getHeadLessStatus(){
        return getProperty("headless").equals("true");
    }

    public static int[] getViewPort(){
        String[] browserViewPorts = getProperty("browserViewPort").split(",");
        int width = Integer.parseInt(browserViewPorts[0]);
        int height = Integer.parseInt(browserViewPorts[1]);

        return new int[]{width,height};
    }

    public static boolean isMaximize(){
        return getProperty("setMaximizeScreen").equals("true");
    }

}

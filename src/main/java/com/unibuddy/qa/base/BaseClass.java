package com.unibuddy.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;

public class BaseClass {
    public static Properties envName, prop;
    String environment="";

    public BaseClass(){
        System.out.println("====== Reading environment details =============");
        try {
            envName = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/unibuddy"
                    + "/qa/config/env_selection.properties");
            envName.load(ip);
            environment = envName.getProperty("environment");
            System.out.println("Environment provided in the env_selection file is: "+environment);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initialization();
    }

    public void initialization(){
        System.out.println("===== Initializing environment variables ============");
        environment = envName.getProperty("environment");
        if (environment.length()<0){
            environment = "local";
        }
        try{
            FileInputStream pathInput = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/unibuddy"
                        + "/qa/config/"+environment+".properties");
            prop = new Properties();
            prop.load(pathInput);
        }
        catch (FileNotFoundException fe){
            fe.printStackTrace();
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }

}

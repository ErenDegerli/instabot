package com.instagram.utils;

import com.instagram.core.PropKey;
import com.instagram.core.PropertyReader;
import com.instagram.driver.BrowserType;

import java.io.IOException;

public class SystemPropertyHelper {

    /**
     * Method to get value for elementScreenShot
     * @return
     */
    public static String getElementScreenShotValue() throws IOException {
        String msg = "";
        String valueFromPropFile = PropertyReader.getInstance()
                .getProperty(PropKey.ELEMENT_SCREEN_SHOT.getPropVal());
        String valueFromSystemVariable = System.getProperty("elementScreenShot");
        if(valueFromSystemVariable.length() > 0 ){
            if(valueFromSystemVariable.equalsIgnoreCase("ENABLE") ||
                    valueFromSystemVariable.equalsIgnoreCase("DISABLE")){
                return valueFromSystemVariable;
            }
            else{
                msg = "Incorrect system property " + valueFromSystemVariable + " value specified for"
                        + PropKey.ELEMENT_SCREEN_SHOT.getPropVal() +
                        " ...defaulting to property provided by the application.properties file " +
                        PropKey.ELEMENT_SCREEN_SHOT.getPropVal() + " : " + valueFromPropFile;
                System.out.println(msg);
            }
        }
        msg =   "No system property specified" +
                " ...defaulting to application.properties file ->  " +
                PropKey.ELEMENT_SCREEN_SHOT.getPropVal() + " : " + valueFromPropFile;

        System.out.println(msg);
        return valueFromPropFile;
    }

    /**
     * Get is Remote Value
     * @return
     */
    public static String getRemoteVal() throws IOException {

        String msg = "";
        String valueFromPropFile = PropertyReader.getInstance()
                .getProperty(PropKey.REMOTE.getPropVal());

        String remoteVal = System.getProperty(PropKey.REMOTE.getPropVal());

        if(remoteVal.length()>0){
            if(remoteVal.equalsIgnoreCase("TRUE") ||
                    remoteVal.equalsIgnoreCase("FALSE")){

                return remoteVal;
            }else{

                msg = "Incorrect system property " + remoteVal + " value specified for"
                        + PropKey.REMOTE.getPropVal() +
                        " ...defaulting to property provided by the application.properties file " +
                        PropKey.REMOTE.getPropVal() + " : " + valueFromPropFile;

                System.out.println(msg);
            }
        }

        msg =   "No system property specified" +
                " ...defaulting to application.properties file ->  " +
                PropKey.REMOTE.getPropVal() + " : " + valueFromPropFile;

        System.out.println(msg);

        return valueFromPropFile;
    }


    /**
     * Get Hub Url
     * @return
     */
    public static String getHubUrl() throws IOException {

        String hubUrl = System.getProperty(PropKey.HUB_URL.getPropVal());

        if(hubUrl.length()>0){
            return hubUrl;
        }

        return PropertyReader.getInstance().getProperty(PropKey.HUB_URL.getPropVal());
    }

    /**
     * Get browser value from pom.xml
     *
     * @return
     */
    public static BrowserType getBrowserFromSystemVariable() throws IOException {

        String browser = System.getProperty(PropKey.BROWSER.getPropVal());

        if(browser.length()<=0){
            browser = PropertyReader.getInstance().getProperty(PropKey.BROWSER.getPropVal());
        }

        if(browser.equalsIgnoreCase("CHROME")){
            return BrowserType.CHROME;
        }else if (browser.equalsIgnoreCase("FIREFOX")){

            return BrowserType.FIREFOX;
        }
        /*else if(browser.equalsIgnoreCase("IE")){
            return BrowserType.IE;
        }*/
        else {
            return null;
        }
    }
}
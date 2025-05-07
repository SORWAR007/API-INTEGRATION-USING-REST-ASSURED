package utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Utilis {

    public static void setEnvVar(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config=new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key,value);
        config.save();
    }

    public static int generateraqndom(int max,int min)
    {

        double randid=Math.random()*(max-min)+min;


        return (int) randid;
    }


}

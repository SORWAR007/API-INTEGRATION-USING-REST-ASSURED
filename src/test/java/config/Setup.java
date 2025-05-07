package config;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Setup {

     public Properties prop;
    FileInputStream fs;
    @BeforeTest
    public void setup() throws IOException {
        prop = new Properties();
        fs = new FileInputStream("./src/test/resources/config.properties");
        prop.load(fs);
    }


}

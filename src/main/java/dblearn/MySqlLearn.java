package dblearn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MySqlLearn {
    private String smitty = "";
    public MySqlLearn(){
        init();
    }
    public void init(){
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("/home/smithwc/myprop/myprop.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("sqlconnect"));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

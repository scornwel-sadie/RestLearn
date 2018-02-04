package dblearn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlLearn {

    private String url;

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Logger lgr = Logger.getLogger(MySqlLearn.class.getName());
    public MySqlLearn(){
        init();
    }
    private String ConnectString = "";
    public void init(){
        Properties prop = new Properties();
        InputStream input = null;
        String user = "";
        String password = "";

        try {

            input = new FileInputStream("/home/smithwc/myprop/myprop.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            url = prop.getProperty("sqlconnect");
            user = prop.getProperty("user");
            password = prop.getProperty("password");


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
        try {

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {


            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }



            } catch (SQLException ex) {


                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

    public String readAll(){
        String strreturn = "";
        try{
            pst = con.prepareStatement("SELECT * FROM testtable");
            rs = pst.executeQuery();
            while( rs.next()){
                strreturn = strreturn + rs.getString(1);
                strreturn = strreturn + " : ";
                strreturn = strreturn + rs.getString(2);
                strreturn = strreturn + " ::: ";
            }

    }catch(SQLException ex){
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
    }finally{
            try {

                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
                }



            } catch (SQLException ex) {

                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
    }

    return strreturn;

    }

}





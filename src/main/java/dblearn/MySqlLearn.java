package dblearn;

import Entities.main;
import Entities.other;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public List<main> readAll(){
        String sql  = "select main.id, main.name  from main";


        /* need to get main first and create the main class
            then get other class for each main in the list and add to main
         */

        List<main> working = new ArrayList<main>();
        String mainid = "";
        String mainname = "";


        try{

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while( rs.next()){
                main top = new main();
                mainid =  rs.getString(1);
                mainname  = rs.getString(2);
                top.setName(mainname);
                int smitty = Integer.parseInt(mainid);
                top.setId(smitty);
                working.add(top);


            }

            /* we now have the main no get other

             */
            sql = "select id, main_id, icecream from other where main_id = ?";
            pst = con.prepareStatement(sql);
            for(main person : working){
                int index = person.getId();
                pst.setInt(1,index);
                rs = pst.executeQuery() ;
                while (rs.next()){
                   other ice = new other();
                   mainid = rs.getString(1);
                   String id = rs.getString(2);
                   mainname = rs.getString(3);
                   ice.setIcecream(mainname);
                   ice.setId(Integer.parseInt(mainid));
                   ice.setMain_id(Integer.parseInt(id));
                   person.addOther(ice);

                }




                int carol = 45;
            }

    }catch(SQLException ex){

            lgr.log(Level.SEVERE, ex.getMessage(), ex);

    }catch(Exception smitty){
            lgr.log(Level.SEVERE, smitty.getMessage(), smitty);
    }
    finally{
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

    return working;

    }

}





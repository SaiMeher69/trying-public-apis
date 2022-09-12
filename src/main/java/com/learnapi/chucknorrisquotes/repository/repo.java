package com.learnapi.chucknorrisquotes.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Repository
public class repo {

    public Connection createConnection() throws IOException, SQLException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/application.properties"));
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(properties.getProperty("spring.datasource.url"), properties.getProperty("spring.datasource.username"), properties.getProperty("spring.datasource.password"));
    }
    public void getCoinInfo(){
        try(Connection connection = createConnection()){
            String url = "https://api2.binance.com/api/v3/ticker/24hr";
            RestTemplate restTemplate = new RestTemplate();
            String data = restTemplate.getForObject(url, String.class);
            JSONArray jsonArray = new JSONArray(data);
            for(int i=0;i< jsonArray.length();i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String query = "INSERT INTO DATA (jsonData) VALUES ('" +obj.toString() + "');";
                //System.out.println(query);
                PreparedStatement statement = connection.prepareStatement(query);
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void getActivity(){
        String url = "https://www.boredapi.com/api/activity";
    }
}


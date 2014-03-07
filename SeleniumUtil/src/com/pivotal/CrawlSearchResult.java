package com.pivotal;

import core.BrowserLauncher;
import core.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lei on 3/6/14.
 */
public class CrawlSearchResult {
    WebDriver driver = null;
    Connection conn = null;

    ArrayList<String> movieNames = new ArrayList<String>();
    ArrayList<Long> searchResults = new ArrayList<Long>();

    private long getSearchResult(String str){
        int index1 = str.indexOf("约");
        int index2 = str.indexOf("条");
        String ret = str.substring(index1+1,index2);
        ret = ret.trim();
        ret = ret.replaceAll(",","");
        return Long.parseLong(ret);
    }

    private String refresh(String movieName) {
        int index1 = movieName.indexOf("(");
        if (index1 != -1)
            return movieName.substring(0,index1);
        else
            return  movieName;
    }

    @BeforeTest
    public void setup() {
        //System.out.println(refresh("白蛇传说(2011)"));

        driver = BrowserLauncher.initBrowser();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.3.166:3306/movie_data?characterEncoding=utf-8", "movie", "movie");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void crawlDataFromGoogle() throws InterruptedException {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT chinese_name FROM movie_data.movie_revenue_58921");
            while (rs.next()){
                movieNames.add(rs.getString("chinese_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (String movieName : movieNames){
            movieName = refresh(movieName);
            String searchURL = "http://www.google.com/search?q=" + movieName + "+-+电影&safe=strict";

            driver.navigate().to(searchURL);
            Configuration.getConfigurationInstance().waitForTime(2);

            WebElement e = driver.findElement(By.id("resultStats"));
            String resultStr = e.getText();
            Long retCount = getSearchResult(resultStr);
            searchResults.add(retCount);

            System.out.println(searchURL+": "+resultStr);
            System.out.println("--------------------------------------");
        }

    }



    @Test(dependsOnMethods = "crawlDataFromGoogle")
    public void writeToMysql(){
        int size = movieNames.size();
        for (int i=0; i<size; i++){
            String movieName = movieNames.get(i);
            Long searchResult = searchResults.get(i);
            try {
                String sql = "INSERT INTO movie_searchpage_count(chinese_name, page_count) " +
                        "VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, movieName);
                ps.setLong(2, searchResult);
                ps.executeUpdate();
                if(ps != null){
                    ps.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }

    @AfterTest
    public void tearDown(){
        driver.quit();

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

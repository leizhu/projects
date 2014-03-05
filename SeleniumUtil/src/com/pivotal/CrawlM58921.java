package com.pivotal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import core.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import core.BrowserLauncher;
import org.testng.annotations.Test;

public class CrawlM58921 {
	WebDriver driver = null;
    Connection conn = null;
	
	@BeforeTest
	public void setup() {
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
    public void installTempest() throws InterruptedException {
        // first login
        System.out.println("1) Log into PA.");
        LoginM58921 loginM58921 = new LoginM58921(driver);
        loginM58921.login();


        // go to revenue page
        System.out.println("2) Go into revenue.");
        String revenuePage = null;

        for (int i=52; i<76; i++){
            Configuration.getConfigurationInstance().waitForTime(5);
            revenuePage = "http://58921.com/alltime?page="+i;
            System.out.println(revenuePage);
            driver.navigate().to(revenuePage);

            // crawl movie data
            if(conn != null){
                WebElement e = driver.findElement(By.className("table-responsive")).findElement(By.tagName("table"));
                WebElement tbody = e.findElement(By.tagName("tbody"));
                List<WebElement> movie_elements = tbody.findElements(By.tagName("tr"));
                for (WebElement movie : movie_elements){
                    int annual_rank = Integer.parseInt(movie.findElements(By.tagName("td")).get(0).getText());
                    int total_rank = Integer.parseInt(movie.findElements(By.tagName("td")).get(1).getText());
                    String movieName = movie.findElements(By.tagName("td")).get(2).getText();
                    double revenue = Double.parseDouble(movie.findElements(By.tagName("td")).get(3).getText());
                    int show_year = Integer.parseInt(movie.findElements(By.tagName("td")).get(8).getText());

                    System.out.println(movieName+":"+revenue);

                    try {
                        String sql = "INSERT INTO movie_revenue_58921(annual_rank, total_rank, chinese_name, box_office_revenue, audience_account, show_year) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setInt(1, annual_rank);
                        ps.setInt(2, total_rank);
                        ps.setString(3, movieName);
                        ps.setDouble(4, revenue);
                        if(movie.findElements(By.tagName("td")).get(4).getText().equals("--") == false){
                            double audience_account = Double.parseDouble(movie.findElements(By.tagName("td")).get(4).getText());
                            ps.setDouble(5, audience_account);
                        }else{
                            ps.setDouble(5, -1);
                        }
                        ps.setInt(6, show_year);

                        ps.executeUpdate();
                        if(ps != null){
                            ps.close();
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
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

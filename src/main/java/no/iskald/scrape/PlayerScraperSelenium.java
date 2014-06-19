package no.iskald.scrape;


import java.util.List;

import org.hibernate.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import no.iskald.database.Connector;
import no.iskald.model.Player;

public class PlayerScraperSelenium
{
    public static void main(String...args) {
        WebDriver driver = new HtmlUnitDriver(  );

        driver.get( "http://en.wikipedia.org/wiki/2014_FIFA_World_Cup_squads" );

        List<WebElement> teams = driver.findElements( By.xpath( "//h3" ) );

        for (WebElement team : teams) {
            System.out.println(team.getText());
        }

        List<WebElement> players = driver.findElements( By.xpath( "//table/tbody/tr/td/table/tbody/tr" ) );

        Session session = Connector.getSessionFactory().openSession();
        session.beginTransaction();


        for(WebElement playerElement : players ) {
            if ( PlayerScraperSelenium.isPlayer( playerElement.getText() )) {
                List<WebElement> playerData = playerElement.findElements( By.tagName( "td" ) );
                System.out.println( playerElement.getText() );
                int number = Integer.parseInt( playerData.get( 0 ).getText() );
                String pos = playerData.get( 1 ).getText();
                String name = playerData.get( 2 ).getText();
                String age = playerData.get( 3 ).getText();
                int matches = Integer.parseInt( playerData.get( 4 ).getText() );
                String club = playerData.get( 5 ).getText();

                Player p = new Player( number, pos, name, age, matches, club );
                session.save( p );

                if (Integer.parseInt( playerData.get( 0 ).getText() ) == 23) {
                    System.out.println("NEW TEAM");
                }
            }
        }

        session.getTransaction().commit();
        session.close();



    }

    private static boolean isPlayer(String s) {
        try {
            return Character.isDigit( s.charAt( 0 ) );
        } catch ( StringIndexOutOfBoundsException e ) {
            return false;
        }
    }
}

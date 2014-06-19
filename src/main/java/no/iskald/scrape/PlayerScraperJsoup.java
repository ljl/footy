package no.iskald.scrape;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by ljl on 16/06/14.
 */
public class PlayerScraperJsoup
{
    public static void main(String...args)
        throws IOException
    {
        Document doc = Jsoup.connect( "http://en.wikipedia.org/wiki/2014_FIFA_World_Cup_squads" ).get();
        Elements tables = doc.getElementsByClass( "sortable jquery-tablesorter" );


    }
}

package no.iskald.database;

import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Connector {

    private Connection connection;
    private static SessionFactory sessionFactory;

    Connection getConnection() throws Exception{
        if (this.connection == null) {
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection( "jdbc:h2:C:/Users/Lasse/workspace/footy/src/main/resources/db" );
        }
        return this.connection;
    }


    public String getResourcePath() throws Exception {
        URL resource = Connector.class.getResource("");
        System.out.print(resource.toString());
        return Paths.get( resource.toURI() ).toFile().toString();
    }

    public static SessionFactory getSessionFactory() {
        if (Connector.sessionFactory == null) {
            Connector.sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return Connector.sessionFactory;
    }

}


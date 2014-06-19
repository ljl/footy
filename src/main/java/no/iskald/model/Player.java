package no.iskald.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Players")
public class Player
{
    private Long id;
    private int number;
    private String position;
    private String name;
    private String age;
    private int matches;
    private String club;

    public Player( final int number, final String position, final String name, final String age, final int matches, final String club )
    {
        this.number = number;
        this.position = position;
        this.name = name;
        this.age = age;
        this.matches = matches;
        this.club = club;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId()
    {
        return id;
    }

    public void setId( final Long id )
    {
        this.id = id;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber( final int number )
    {
        this.number = number;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition( final String position )
    {
        this.position = position;
    }

    public String getName()
    {
        return name;
    }

    public void setName( final String name )
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge( final String age )
    {
        this.age = age;
    }

    public int getMatches()
    {
        return matches;
    }

    public void setMatches( final int matches )
    {
        this.matches = matches;
    }

    public String getClub()
    {
        return club;
    }

    public void setClub( final String club )
    {
        this.club = club;
    }
}

package com.johnathanmsmith.mvc.web.model;

/**
 * Date:   6/6/13 / 10:09 AM
 * Author: Johnathan Mark Smith
 * Email:  john@johnathanmarksmith.com
 * <p/>
 * Comments:
 * <p/>
 * This is the model that is going to be use for return the JSON data
 */

public class User
{
    private String user;
    private String name;


    public User()
    {
    }

    public User(String user, String name)
    {
        this.user = user;
        this.name = name;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

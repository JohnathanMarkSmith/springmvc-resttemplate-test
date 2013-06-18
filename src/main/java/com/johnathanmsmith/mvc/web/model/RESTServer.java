package com.johnathanmsmith.mvc.web.model;

/**
 * Date:   6/7/13 / 8:29 AM
 * Author: Johnathan Mark Smith
 * Email:  john@johnathanmarksmith.com
 * <p/>
 * Comments:
 * <p/>
 * This bean is used to hold the user name, password and host which we need to make the
 * call to the REST service.
 */

public class RESTServer
{
    private String user;
    private String password;
    private String host;


    public RESTServer(String user, String password, String host)
    {
        this.user = user;
        this.password = password;
        this.host = host;
    }

    public String getUser()
    {
        return user;
    }

    public String getPassword()
    {
        return password;
    }

    public String getHost()
    {
        return host;
    }
}

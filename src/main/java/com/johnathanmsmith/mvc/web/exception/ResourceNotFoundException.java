package com.johnathanmsmith.mvc.web.exception;

/**
 * Date:   6/12/13 / 8:50 AM
 * Author: Johnathan Mark Smith
 * Email:  johnathansmith1969@gmail.com
 * <p/>
 * Comments:
 * <p/>
 * This is used to throw a exception if the resource is not foun
 */


public class ResourceNotFoundException extends Exception
{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}

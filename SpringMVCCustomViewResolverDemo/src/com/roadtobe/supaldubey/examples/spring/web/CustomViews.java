/**
 * 
 */
package com.roadtobe.supaldubey.examples.spring.web;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Supal
 * 
 */
public class CustomViews
{
    private String requestedView;
    private String targetView;

    public String getRequestedView()
    {
	return requestedView;
    }

    @XmlElement(name = "sourcePage")
    public void setRequestedView(String requestedView)
    {
	this.requestedView = requestedView;
    }

    

    @XmlElement(name = "destinationPage")
    public void setTargetView(String targetView)
    {
	this.targetView = targetView;
    }

    public String getTargetView()
    {
	return targetView;
    }
    
    @Override
    public String toString()
    {
	return requestedView + " = " + targetView;
    }

    @Override
    public boolean equals(Object other)
    {
	if (other == null || !other.getClass().equals(getClass()))
	{
	    return false;
	}
	CustomViews customViews = (CustomViews) other;
	return requestedView.equals(customViews.getRequestedView())
		&& targetView.equals(customViews.getTargetView());
    }

    @Override
    public int hashCode()
    {
	//I do not expect them to be null for the example. But please
	// use proper implemetation.
	return requestedView.hashCode() + targetView.hashCode();
    }
}

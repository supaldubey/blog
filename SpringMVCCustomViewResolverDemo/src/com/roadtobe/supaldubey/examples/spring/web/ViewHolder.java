/**
 * 
 */
package com.roadtobe.supaldubey.examples.spring.web;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Supal
 * 
 */
@XmlRootElement(name = "viewMappings")
public class ViewHolder {
	
	private List<CustomViews> customViews;

	
	@XmlElement(name = "viewMapping")
	public void setCustomViews(List<CustomViews> customViews) {
		this.customViews = customViews;
	}

	public List<CustomViews> getCustomViews() {
		return customViews;
	}
	
	@Override
	public String toString()
	{
		return customViews.toString();
	}
}

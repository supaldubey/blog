package com.roadtobe.supaldubey.examples.spring.web;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.JAXB;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;


public class CustomViewResolver extends
		org.springframework.web.servlet.view.InternalResourceViewResolver {

	private static final String VIEW_MAPPING_XML = "/viewMapping.xml";
	private Map<String, String> mapping = new HashMap<String, String>();

	public CustomViewResolver() {
		super();
		ViewHolder viewHolder = JAXB.unmarshal(
				getClass().getResourceAsStream(VIEW_MAPPING_XML),
				ViewHolder.class);
		for (CustomViews view : viewHolder.getCustomViews()) {
			mapping.put(view.getRequestedView(), view.getTargetView());
		}
		viewHolder.getCustomViews().clear();
	}

	@Override
	protected View loadView(String viewName, Locale locale) throws Exception {
		if(mapping.get(viewName) != null)
		{
			viewName = mapping.get(viewName);
		}
		AbstractUrlBasedView view = buildView(viewName);
		View viewObj = (View) getApplicationContext()
				.getAutowireCapableBeanFactory().initializeBean(view, viewName);
		return viewObj;
	}
}

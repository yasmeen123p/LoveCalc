package com.spring.lc.propertyeditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String myconvertedstring= text.toUpperCase();
		setValue(myconvertedstring );
		
	}
	
	
	
}

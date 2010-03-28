/**
 *	This file is part of LiferayUITaglibDemo Liferay plug-in.
 *	
 * LiferayUITaglibDemo Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * LiferayUITaglibDemo Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with LiferayUITaglibDemo Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */

package com.commsen.example.liferay.taglib.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Milen Dyankov
 * 
 */
public class Bean {

	private String stringField;
	private boolean booleanField;
	private int intField;
	private double doubleField;
	private Date dateField;


	private Bean(String stringField, boolean booleanField, int intField, double doubleField, Date dateField) {
		super();
		this.stringField = stringField;
		this.booleanField = booleanField;
		this.intField = intField;
		this.doubleField = doubleField;
		this.dateField = dateField;
	}


	public static final List<Bean> getDummyList() {
		List<Bean> result = new ArrayList<Bean>();
		result.add(new Bean("str1", true, 1, 0.1, new Date()));
		result.add(new Bean("str2", true, 2, 0.2, new Date()));
		result.add(new Bean("str3", true, 3, 0.3, new Date()));
		result.add(new Bean("str4", true, 4, 0.4, new Date()));
		result.add(new Bean("str5", true, 5, 0.5, new Date()));
		result.add(new Bean("str6", true, 6, 0.6, new Date()));
		result.add(new Bean("str7", true, 7, 0.7, new Date()));
		result.add(new Bean("str8", true, 8, 0.8, new Date()));
		result.add(new Bean("str9", true, 9, 0.9, new Date()));
		return result;
	}


	/**
	 * @return the stringField
	 */
	public String getStringField() {
		return this.stringField;
	}


	/**
	 * @param stringField the stringField to set
	 */
	public void setStringField(String stringField) {
		this.stringField = stringField;
	}


	/**
	 * @return the booleanField
	 */
	public boolean isBooleanField() {
		return this.booleanField;
	}


	/**
	 * @param booleanField the booleanField to set
	 */
	public void setBooleanField(boolean booleanField) {
		this.booleanField = booleanField;
	}


	/**
	 * @return the intField
	 */
	public int getIntField() {
		return this.intField;
	}


	/**
	 * @param intField the intField to set
	 */
	public void setIntField(int intField) {
		this.intField = intField;
	}


	/**
	 * @return the doubleField
	 */
	public double getDoubleField() {
		return this.doubleField;
	}


	/**
	 * @param doubleField the doubleField to set
	 */
	public void setDoubleField(double doubleField) {
		this.doubleField = doubleField;
	}


	/**
	 * @return the dateField
	 */
	public Date getDateField() {
		return this.dateField;
	}


	/**
	 * @param dateField the dateField to set
	 */
	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}
}

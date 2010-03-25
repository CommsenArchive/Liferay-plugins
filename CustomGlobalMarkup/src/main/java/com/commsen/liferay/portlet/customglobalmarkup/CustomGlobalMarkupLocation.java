/**
 *	This file is part of CustomGlobalMarkup Liferay plug-in.
 *	
 * CustomGlobalMarkup Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * CustomGlobalMarkup Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with CustomGlobalMarkup Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */

package com.commsen.liferay.portlet.customglobalmarkup;

/**
 * @author Milen Dyankov
 * 
 */
public class CustomGlobalMarkupLocation {

	public static final short TOP = 1;
	public static final short BOTTOM = 2;


	public static final boolean isValid(short location) {
		return location == TOP || location == BOTTOM;
	}
}

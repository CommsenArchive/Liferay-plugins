/**
 *	This file is part of Tailgate Liferay plug-in.
 *	
 * Tailgate Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Tailgate Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Tailgate Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */

package com.commsen.file.monitor;

/**
 * @author Milen Dyankov
 * 
 */
public interface FileBuffer {

	/**
	 * @return the lines
	 */
	public int getMaxSize();


	/**
	 * 
	 * @return
	 */
	public int getSize();


	/**
	 * 
	 */
	public boolean addLine(final String line);


	/**
	 * 
	 */
	public String readLine();


	public void setEnabled(boolean enabled);


	public boolean isEnabled();


	public String getFileName();

}
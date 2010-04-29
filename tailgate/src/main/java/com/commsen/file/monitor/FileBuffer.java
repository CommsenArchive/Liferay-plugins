/**
 * 
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
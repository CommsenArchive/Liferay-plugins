/**
 * 
 */
package com.commsen.file.monitor;

/**
 * @author Milen Dyankov
 * 
 */
public interface FileObserver {

	public boolean addLine(final String line);


	public String getFileName();

}
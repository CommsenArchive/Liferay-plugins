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

package com.commsen.liferay.portlet.tailgate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.commsen.file.monitor.FileBuffer;
import com.commsen.file.monitor.FileMonitoringEngine;

/**
 * @author Milen Dyankov
 * 
 */
public class TestFileTail {
	static boolean runnig = true;


	public static void main(String[] args) throws IOException {
		FileBuffer fileBuffer = FileMonitoringEngine.newFileBuffer("/tmp/buffer", 100);
		startWritingToFile();
		stopOnEnterKey();

		String line;
		while (true) {
			if (runnig) {
				while ((line = fileBuffer.readLine()) != null) {
					System.out.println("<li>" + line + "</li>");
				}
			} else {
				// if (fileTail != null) {
				// fileTail = null;
				// System.out.println("fileTail is now NULL !!!");
				// }
				if (fileBuffer.isEnabled()) {
					fileBuffer.setEnabled(false);
					System.out.println("fileTail is now stopped !!!");
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// wake up
			}
		}

	}


	/**
     * 
     */
	private static void startWritingToFile() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				PrintWriter writer;
				try {
					writer = new PrintWriter(new FileWriter(new File("/tmp/buffer")));
					while (true) {
						writer.println("random number: " + Math.random());
						writer.flush();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}


	/**
     * 
     */
	private static void stopOnEnterKey() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				runnig = false;
			}
		});
		t.start();
	}

}

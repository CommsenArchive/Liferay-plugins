/**
 * 
 */
package com.commsen.file.monitor;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Logger;


/**
 * @author Milen Dyankov
 * 
 */
public class FileMonitoringEngine {

	Logger log = Logger.getLogger(FileMonitoringEngine.class.getName());

	private static final Map<FileObserver, FileMonitor> FILE_BUFFERS = new WeakHashMap<FileObserver, FileMonitor>();


	public static FileBuffer newFileBuffer(String fileName, int maxSize) throws IOException {
		FileTail fileTail = new FileTail(fileName, maxSize);
		register(fileTail);
		return fileTail;
	}


	/**
	 * @throws IOException
	 * 
	 */
	public static void register(final FileObserver fileObserver) {
		if (FILE_BUFFERS.containsKey(fileObserver)) {
			return;
		}

		FileMonitor fileMonitor = null;
		for (FileMonitor fm : FILE_BUFFERS.values()) {
			if (fm != null && fm.getFileName().equals(fileObserver.getFileName())) {
				fileMonitor = fm;
				continue;
			}
		}

		if (fileMonitor == null) {
			fileMonitor = new FileMonitor(fileObserver.getFileName());
			final Thread monitorThread = new Thread(fileMonitor, "FileMonitor(" + fileMonitor.getFileName() + ")");
			monitorThread.start();
		}

		fileMonitor.addObserver(fileObserver);
		FILE_BUFFERS.put(fileObserver, fileMonitor);

	}


	public static void unregister(final FileObserver fileObserver) {
		if (FILE_BUFFERS.containsKey(fileObserver)) {
			final FileMonitor fileMonitor = FILE_BUFFERS.get(fileObserver);
			fileMonitor.removeObserver(fileObserver);
			FILE_BUFFERS.remove(fileObserver);
		}
	}


	public static boolean isRegistered(final FileObserver fileTail) {
		return FILE_BUFFERS.containsKey(fileTail);
	}

}

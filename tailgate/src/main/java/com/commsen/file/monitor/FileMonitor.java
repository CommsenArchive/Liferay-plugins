/**
 * 
 */
package com.commsen.file.monitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Milen Dyankov
 * 
 */
public class FileMonitor implements Runnable {

	Logger log = Logger.getLogger(FileMonitor.class.getName());

	private final Set<FileObserver> observers = Collections.synchronizedSet(newSetFromMap(new WeakHashMap<FileObserver, Boolean>()));
	private final File file;
	private long position = 0;
	RandomAccessFile raf;


	/**
     * 
     */
	FileMonitor(final String fileName) {
		if (fileName == null) throw new IllegalArgumentException("Filane is null");
		this.file = new File(fileName);
		if (file.exists() && file.isDirectory()) throw new IllegalArgumentException("File " + file.getAbsolutePath() + " is directory!");
	}


	/**
	 * @return the position
	 */
	private long getPosition() {
		return this.position;
	}


	/**
	 * @param position the position to set
	 */
	private void setPosition(final long position) {
		this.position = position;
	}


	/**
	 * @return the file
	 * @throws IOException
	 */
	public String getFileName() {
		try {
			return this.file.getCanonicalPath();
		} catch (IOException e) {
			log.log(Level.WARNING, "Filed to get canonical name!", e);
			return null;
		}
	}


	void addObserver(final FileObserver fileObserver) {
		observers.add(fileObserver);
	}


	void removeObserver(final FileObserver fileObserver) {
		observers.remove(fileObserver);
	}


	private void sleep(final long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// wake up
		}
	}


	private boolean haveListeners() {
		if (observers == null || observers.isEmpty()) return false;
		for (FileObserver failObserver : observers) {
			if (failObserver != null) return true;
		}
		return false;
	}


	private void readAndUpdateListeners() {
		try {
			if (file.length() > getPosition()) {
				raf.seek(position);
				String line;
				while ((line = raf.readLine()) != null) {
					for (FileObserver fileObserver : observers) {
						if (fileObserver != null) {
							fileObserver.addLine(line);
						}
					}
				}
				setPosition(raf.length());
			}
		} catch (IOException e) {
			log.log(Level.WARNING, "File not found", e);
			return;
		}
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (!file.exists() && haveListeners()) {
			sleep(100);
		}

		if (file.isDirectory()) throw new IllegalArgumentException("File " + file.getAbsolutePath() + " is directory!");
		try {
			raf = new RandomAccessFile(file, "r");
		} catch (FileNotFoundException e1) {
			log.log(Level.SEVERE, "File not found", e1);
			return;
		}
		while (haveListeners()) {
			readAndUpdateListeners();
			sleep(100);
		}
	}


	/**
	 * Returns a set backed by the specified map. The resulting set displays the same ordering,
	 * concurrency, and performance characteristics as the backing map. In essence, this factory
	 * method provides a {@link Set} implementation corresponding to any {@link Map} implementation.
	 * There is no need to use this method on a {@link Map} implementation that already has a
	 * corresponding {@link Set} implementation (such as {@link HashMap} or {@link TreeMap}).
	 * 
	 * <p>
	 * Each method invocation on the set returned by this method results in exactly one method
	 * invocation on the backing map or its <tt>keySet</tt> view, with one exception. The
	 * <tt>addAll</tt> method is implemented as a sequence of <tt>put</tt> invocations on the
	 * backing map.
	 * 
	 * <p>
	 * The specified map must be empty at the time this method is invoked, and should not be
	 * accessed directly after this method returns. These conditions are ensured if the map is
	 * created empty, passed directly to this method, and no reference to the map is retained, as
	 * illustrated in the following code fragment:
	 * 
	 * <pre>
	 * Set&lt;Object&gt; identityHashSet = Sets.newSetFromMap(new IdentityHashMap&lt;Object, Boolean&gt;());
	 * </pre>
	 * 
	 * This method has the same behavior as the JDK 6 method {@code Collections.newSetFromMap()}.
	 * The returned set is serializable if the backing map is.
	 * 
	 * @param map the backing map
	 * @return the set backed by the map
	 * @throws IllegalArgumentException if <tt>map</tt> is not empty
	 */
	public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
		return new SetFromMap<E>(map);
	}

	private static class SetFromMap<E> extends AbstractSet<E> implements Set<E>, Serializable {
		private final Map<E, Boolean> m; // The backing map
		private transient Set<E> s; // Its keySet


		SetFromMap(Map<E, Boolean> map) {
			if (!map.isEmpty()) throw new IllegalArgumentException("Map is non-empty");
			m = map;
			s = map.keySet();
		}


		@Override
		public void clear() {
			m.clear();
		}


		@Override
		public int size() {
			return m.size();
		}


		@Override
		public boolean isEmpty() {
			return m.isEmpty();
		}


		@Override
		public boolean contains(Object o) {
			return m.containsKey(o);
		}


		@Override
		public boolean remove(Object o) {
			return m.remove(o) != null;
		}


		@Override
		public boolean add(E e) {
			return m.put(e, Boolean.TRUE) == null;
		}


		@Override
		public Iterator<E> iterator() {
			return s.iterator();
		}


		@Override
		public Object[] toArray() {
			return s.toArray();
		}


		@Override
		public <T> T[] toArray(T[] a) {
			return s.toArray(a);
		}


		@Override
		public String toString() {
			return s.toString();
		}


		@Override
		public int hashCode() {
			return s.hashCode();
		}


		@Override
		public boolean equals(Object object) {
			return this == object || this.s.equals(object);
		}


		@Override
		public boolean containsAll(Collection<?> c) {
			return s.containsAll(c);
		}


		@Override
		public boolean removeAll(Collection<?> c) {
			return s.removeAll(c);
		}


		@Override
		public boolean retainAll(Collection<?> c) {
			return s.retainAll(c);
		}

		// addAll is the only inherited implementation

		static final long serialVersionUID = 0;


		private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
			stream.defaultReadObject();
			s = m.keySet();
		}
	}
}

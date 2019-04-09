package xyz.frt.animal;

import java.util.Iterator;
import java.util.List;

public class Utils {


	public static <T> void removeListItem(List<T> items, T item) {
		Iterator<T> it = items.iterator();
		while (it.hasNext()) {
			T t = it.next();
			System.out.println(t == item);
			if (t == item) {
				it.remove();
			}
		}
	}
	
}

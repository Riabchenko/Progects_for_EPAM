package ua.kpi.epam.interfaces;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 13.04.2015
*
*/
public interface MyList {
	
	void add(Object e);
	void add(int index, Object element);
	void addAll(Object[] c);
	void addAll(int index, Object[] c);
	Object get(int index);
	Object remove(int index);
	void set(int index, Object element);
	int indexOf(Object o);// - поиск индекса по значению
	int size();// - размер списка
	Object[] toArray();// - преобразует список в массив объектов
	String str();

}

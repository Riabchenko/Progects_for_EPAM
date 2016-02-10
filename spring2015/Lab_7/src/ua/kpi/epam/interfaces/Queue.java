package ua.kpi.epam.interfaces;

public interface Queue {

	void offer(Object e);// - добавить в конец очереди
	Object peek();// - взять без удаления, элемент из очереди 
	Object poll();// - взять и удалить элемент из очереди

}

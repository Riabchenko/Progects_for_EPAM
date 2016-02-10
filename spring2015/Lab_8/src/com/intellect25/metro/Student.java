package com.intellect25.metro;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 30.04.2015
*
*This class create new Student cards.
*All information stored in the card.
*
*/
import java.util.Calendar;

public class Student extends Cards {
	private int count;
	private Type type = Type.STUDENT;
	private CountAndDays cad;
	private String status = super.status;
	private Calendar dateEnd;
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setId(int)
	 */
	@Override
	void setId(int id) {
		this.id = id;		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	public	void setCount(int count) {
		this.count = count;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	public	void setDateEnd(Calendar dateEnd) {
		this.dateEnd = dateEnd;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	public	String getStatus() {
		return status;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	public	Type getType() {
		return type;	
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	public	Calendar getDateEnd() {
		return dateEnd;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	int getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	public	int getCount() {
		return count;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	public	void setCountAndDays(CountAndDays cad) {
		this.cad = cad;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	CountAndDays getCountAndDays() {
		return cad;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setCount(int)
	 */
	@Override
	void setStatus(String status) {
		this.status = status;	
	}

}

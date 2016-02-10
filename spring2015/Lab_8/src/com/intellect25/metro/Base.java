package com.intellect25.metro;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 30.04.2015
*
*This class create new Base cards.
*All information stored in the card.
*
*/
import java.util.Calendar;

public class Base extends Cards {
	private int count;
	private Type type = Type.BASE;
	private CountAndDays cad;
	private String status = super.status;
	private Calendar dateEnd;
	private float cash;
	
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
	public void setCount(int count) {
		this.count = count;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#setDateEnd(java.util.Calendar)
	 */
	@Override
	public	void setDateEnd(Calendar dateEnd) {
		this.dateEnd = dateEnd;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#getStatus()
	 */
	@Override
	public	String getStatus() {
		return status;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#getType()
	 */
	@Override
	public Type getType() {
		return type;	
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#getDateEnd()
	 */
	@Override
	public	Calendar getDateEnd() {
		return dateEnd;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#getId()
	 */
	@Override
	int getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * @see com.intellect25.metro.Cards#getCount()
	 */
	@Override
	public int getCount() {
		return count;
	}

	/**
	 * Gotten cash divide to price of trip (4grn) and gotten count of trips post to the Count.
	 * This method left cash write to the cash field.
	 * @param cash float
	 */
	 public void addCash(float cash){
		this.cash = cash;
	}
	
	 /**
	  * Getting count of cash
	  * @return cash float
	  */
	 public float getCash(){
		return cash;
	}

	 /*
	  * (non-Javadoc)
	  * @see com.intellect25.metro.Cards#setCountAndDays(com.intellect25.metro.CountAndDays)
	  */
	@Override
	public	void setCountAndDays(CountAndDays cad) {
		this.cad = cad;		
	}
	
	/*
	  * (non-Javadoc)
	  * @see com.intellect25.metro.Cards#setCountAndDays(com.intellect25.metro.CountAndDays)
	  */
	@Override
	CountAndDays getCountAndDays() {
		return cad;
	}
	
	/*
	  * (non-Javadoc)
	  * @see com.intellect25.metro.Cards#setCountAndDays(com.intellect25.metro.CountAndDays)
	  */
	@Override
	void setStatus(String status) {
		this.status = status;	
	}

}

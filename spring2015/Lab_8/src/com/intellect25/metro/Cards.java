package com.intellect25.metro;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 30.04.2015
*
*/
import java.util.Calendar;

public abstract class Cards {
	public String status = "Ok";
	protected int id;
	/**
	 * Setting status for card
	 * @param status String
	 */
	abstract void setStatus(String status);
	
	/**
	 * Setting id for card
	 * @param id int 
	 */
	abstract void setId(int id);
	
	/**
	 * Setting end date
	 * @param dateEnd Calendar 
	 */
	abstract void setDateEnd(Calendar endDay);
	
	/**
	 * Setting count of trips
	 * @param count int 
	 */
	abstract void setCount(int count);
	
	/**
	 * Setting type card (DAY_10, DAY_MONTH, CASH, COUNT_5, COUNT_10)
	 * @param cad class enum CountAndDays
	 */
	abstract void setCountAndDays(CountAndDays cad);
	
	/**
	 * Getting card's id
	 * @return id int
	 */
	abstract int getId();
	/**
	 * Getting count of trips 
	 * @return count int
	 */
	public abstract int getCount();
	
	/**
	 * Getting card's status
	 * @return status String 
	 */
	public abstract String getStatus();
	
	/**
	 * Getting card's type of Type
	 * @return type Type
	 */
	public abstract Type getType();
	
	/**
	 * Getting card's end date
	 * @return dateEnd Calendar 
	 */
	public abstract Calendar getDateEnd();
	
	/**
	 * Getting card's type of CountAndDays
	 * @return
	 */
	abstract CountAndDays getCountAndDays();
}

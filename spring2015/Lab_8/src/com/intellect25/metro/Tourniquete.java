package com.intellect25.metro;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 30.04.2015
*
*This class creates a Tourniquete.
*Tourniquete contains statistics of allowed/notAllowed access
*
*/

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tourniquete {
		private int id; 
		Map<Integer,Type> allowed = new LinkedHashMap <Integer,Type>();
		Map<Integer,Type> notAllowed = new LinkedHashMap <Integer,Type>();

	/**
	 * This method describes enter card to the Tourniquete
	 * @param card Cards
	 * @return String It's result of enter card to the Tourniquete
	 */
	public String enter(Cards card){
		String result = null;
			if (dateOfCard(card)){
				switch(card.getCountAndDays()){
				case COUNT_5:	
					result = countMinus(card);
					return result;
				case COUNT_10:	
					result = countMinus(card);
					return result;
				case CASH:	
					result = countMinus(card);
					return result;
				case DAY_10:	
					result = dayMinus(card);
					return result;
				case DAY_MONTH:	
					result = dayMinus(card);	
					return result;				
				}			
			}else	{
				result = errorCard(card);
			}
		return result;		
	}
	
	/**
	 * This method checks status and end date of card
	 * @param card Cards
	 * @return true or false
	 */
	public boolean dateOfCard(Cards card){
			if(card.getStatus().compareTo("Ok")!=0 || Calendar.getInstance().after(card.getDateEnd())) return false;
		return true;
	}
	
	/**
	 * This method called when card's error 
	 * @param card Cards
	 * @return String It's result of enter card to the Tourniquete when card's error
	 */
	public String errorCard(Cards card){
		String status = "Error";
		card.setStatus(status);
		notAllowed.put(++id,card.getType());
		return "Access denied!";
	}
	
	/**
	 * This method reduces count of trips 
	 * and adds information to the list of statistic 
	 * @param card Cards
	 * @return String It's result of enter card to the Tourniquete
	 */
	public String countMinus(Cards card) {
		if(card.getCount()>0){
			card.setCount(card.getCount()-1);
			allowed.put(++id,card.getType());
			return "Access allowed. On card left "+card.getCount()+" trips";
		}else return errorCard(card);
		 
	}
	
	/**
	 * This method adds information to the list of statistic 
	 * @param card Cards
	 * @return String It's result of enter card to the Tourniquete
	 */
	public String dayMinus(Cards card){
		allowed.put(++id,card.getType());
		return "Access allowed";
	}
	
	/**
	 * This method displays a sum of permissions 
	 * and a sum of not permissions for each type of card
	 * @return String
	 */
	public String showOnDisplay(){
		int [] info = displayPermissions();
		String permission = "---------------------\n"
				+ "Sum of permissions: "+allowed.size()+"\n"+
				"BASE  = "+info[0]+"\n"+"STUDENT = "+info[2]+"\n"+"SCHOOLBOY = "+info[1];
		String notPermission = "---------------------\n"
				+ "Sum of not permissions: "+notAllowed.size()+"\n"+
				"BASE  = "+info[3]+"\n"+"STUDENT = "+info[5]+"\n"+"SCHOOLBOY = "+info[4];
		return permission+"\n"+notPermission;
	}
	
	/**
	 * This method displays a general sum of permissions 
	 * and a general sum of not permissions
	 * @return
	 */
	public String showAllOnDisplay(){
		int [] info = displayPermissions();
		int sumAllowed = info[0]+info[1]+info[2];
		int sumNotAllowed = info[3]+info[4]+info[5];
		return "---------------------\n"
				+"All permissions: "+sumAllowed+"\n"
				+ "All bans: "+sumNotAllowed;
		
	}

	/**
	 * This method for counting statistic
	 * @return int array
	 */
	public int[] displayPermissions(){
		int [] info= new int [6];
		int x = 0;
		int y = 0;
		int z = 0;
		for(Integer c : allowed.keySet()){		
			if(allowed.get(c)==Type.BASE) x++;
			if(allowed.get(c)==Type.SCHOOLBOY) y++;
			if(allowed.get(c)==Type.STUDENT) z++;			
		}
			info[0]=x;
			info[1]=y;
			info[2]=z;
			
		x=0; y=0; z=0;
		for(Integer c : notAllowed.keySet()){		
			if(notAllowed.get(c)==Type.BASE) x++;
			if(notAllowed.get(c)==Type.SCHOOLBOY) y++;
			if(notAllowed.get(c)==Type.STUDENT) z++;			
		}
		info[3]=x;
		info[4]=y;
		info[5]=z;
		
		return info;
	}
	
}

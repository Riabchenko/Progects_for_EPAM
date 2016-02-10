package com.intellect25.metro;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 30.04.2015
*
* * Система турникета метро
Написать программу, которая моделирует работу системы турникета метро.
Турникет контролирует вход пассажиров на перрон. Для прохода на перрон могут использоваться проездные карточки, которые подразделяются на:
1. Ученические, Студенческие, Обычные.
2. По сроку действия: на месяц, на 10 дней.
3. По количеству поездок: на 5, на 10.
4. Накопительные карточки (могут быть только «обычного» типа - не могут быть ученические и
студенческие) - могут пополняться на определенную сумму, с которой при каждой поездке
снимается стоимость проезда. Такие карты не имеют ограничений по сроку действия.
Турникет должен быть связан с системой, в которой ведется реестр выданных карточек. В этой
системе возможно: 1. выпустить карточку.
Данные по карточки хранятся на самой карте, а именно: уникальный идентификатор, тип карты, срок
действия, количество поездок и т.д.
Турникет считывает данные с карты и выполняет ее проверку. Если данные не удалось считать, или
карточка просрочена, или на ней не осталось кредитов для поездок, то проход запрещен. Иначе с карты снимается одна и проход разрешается.
Система осуществляет учет разрешений и отказов прохода. И умеет выдавать по запросу: 1) суммарные данные и 2) данные разбиты по типам карточек.
*
*This class is factory for create cards.
*All created cards save to the ArrayList.
*
*/
import java.util.ArrayList;
import java.util.Calendar;

public class FactoryOfCards {
	private static int id; 
	private static ArrayList<Cards> cardsList = new ArrayList<Cards>();	
	private FactoryOfCards(){};
	
	/**
	 * It's constructor for create Base cards with cash.
	 * It's cards have got end date after 1 year.
	 * The price of one trip is 4grn, because when card get cash
	 * this cash divided on price, and left add to the cash field.
	 * @param t Type of card (receive only BASE card)
	 * @param cash float cash which need putting to the card
	 * @return card Cards
	 */
	public static Cards getInstance(Type t,float cash){
		Cards card = null;	
		if(t == Type.BASE){
			card = new Base();
			card.setId(++id);
			card.setCountAndDays(CountAndDays.CASH);
			int cheeps = (int) cash/4; //price of underground = 4grn
			float coins = cash % 4;
			((Base)card).addCash(coins);
			card.setCount(cheeps);
			Calendar current = Calendar.getInstance();
			current.add(Calendar.YEAR, 1);		
			card.setDateEnd(current);		
			cardsList.add(card);
		}
		return card;
	}

	/**
	 * It's constructor for create cards which haven't got specified date.
	 * 
	 * @param t Type of card (BASE,STUDENT,SCHOOLBOY)
	 * @param cd Type of card (DAY_10, DAY_MONTH, COUNT_5, COUNT_10)
	 * @return card Cards
	 */
	public static Cards getInstance(Type t,CountAndDays cd){
		Cards card = null;
		switch(t){
		case BASE:
			card = new Base();
			countCardAll(cd,card);
			return card;
					
		case SCHOOLBOY:
			card = new Schoolboy();
			countCardAll(cd,card);
			return card;
			
		case STUDENT:
			card = new Student();
			countCardAll(cd,card);
			return card;
		}
		return card;
	}
	
	/**
	 * It's constructor for create cards which have got specified date.
	 * @param t Type of card (BASE,STUDENT,SCHOOLBOY)
	 * @param cd Type of card (DAY_10, DAY_MONTH, COUNT_5, COUNT_10)
	 * @param start It's Calendar date which specified starting of the card
	 * @return card Cards
	 */
	public static Cards getInstance(Type t,CountAndDays cd,Calendar start){
		Cards card = null;
		switch(t){
			
		case BASE:
			card = new Base();
			monthCardAll(cd,card,start);
			return card;

		case SCHOOLBOY:
			card = new Schoolboy();
			monthCardAll(cd,card,start);
			return card;
			
		case STUDENT:
			card = new Student();
			monthCardAll(cd,card,start);
			return card;
		}
		return card;
	}

	/**
	 * This method's helper for create cards with 5 or 10 trips
	 * @param cd Type of card (use only COUNT_5 and COUNT_10)
	 * @param card New empty card of class Cards
	 * @return card Finished card of Cards 
	 */
	public static Cards countCardAll(CountAndDays cd,Cards card) throws NullPointerException{
	try{
		switch (cd){
		case COUNT_5:
			countCard(5,card);
			return card;
		case COUNT_10: 
			countCard(10,card);
			return card;
		}
	}catch(NullPointerException e){
		throw new NullPointerException("Error!The card or the count is null.");
	}
		return card;
	}	
	
	/**
	 * This method's helper for create cards with 5 or 10 trips
	 * in method countCardAll(CountAndDays cd,Cards card)
	 * @param x count of trips (5 or 10)
	 * @param card New empty card of class Cards
	 * @return card Finished card of Cards 
	 */
	public static Cards countCard(int x,Cards card){
		card.setId(++id);
		card.setCount(x); 
		if(x==5) card.setCountAndDays(CountAndDays.COUNT_5);
		else if(x==10) card.setCountAndDays(CountAndDays.COUNT_10);
		Calendar current = Calendar.getInstance();
		current.add(Calendar.YEAR, 1);		
		card.setDateEnd(current);
		cardsList.add(card);
		return card;
	}
	

	/**
	 * This method's helper for create cards which have got 
	 * end date after 10 days or one month.
	 * @param cd Type of card (use only DAY_10 and DAY_MONTH)
	 * @param card New empty card of class Cards
	 * @param start It's Calendar date which specified starting of the card
	 * @return card Finished card of Cards 
	 */
	public static Cards monthCardAll(CountAndDays cd,Cards card,Calendar start){
		switch (cd){
		case DAY_10:
			start.add(Calendar.DAY_OF_MONTH, 10);	
			monthCard(card,start);
			card.setCountAndDays(CountAndDays.DAY_10);
			return card;
		case DAY_MONTH: 
			start.add(Calendar.MONTH, 1);
			monthCard(card,start);
			card.setCountAndDays(CountAndDays.DAY_MONTH);
			return card;
		}
		return card;
	}
	
	/**
	 * This method's helper for create cards which have got 
	 * end date after 10 days or one month.
	 * This method is helper method's monthCardAll(CountAndDays cd,Cards card,Calendar start)
	 * @param card New empty card of class Cards
	 * @param start It's Calendar date which specified starting of the card
	 * @return card Finished card of Cards 
	 */
	public static Cards monthCard(Cards card,Calendar start){
		card.setId(++id);				
		card.setDateEnd(start);
		cardsList.add(card);
		return card;
	}
	
	/**
	 * This method displays count of created cards
	 * @return int
	 */
	public static int countOfCards(){
		return cardsList.size();		
	}
	
	/**
	 * This method displays information of card
	 * @param card Cards 
	 * @return String
	 */
	public static String infoCard(Cards card){
		String info = "ID "+card.getId()+"\n"+
				"Type of card: "+card.getType()+" - "+card.getCountAndDays()+"\n"+
				"Count of passage: "+card.getCount()+"\n"+
				"Status: "+card.getStatus()+"\n"+
				"The end date: "+card.getDateEnd().get(Calendar.DAY_OF_MONTH)+"-"
				+card.getDateEnd().get(Calendar.MONTH)+"-"
				+card.getDateEnd().get(Calendar.YEAR)+" (first month is 0) \n";
		if( card instanceof Base && ((Base) card).getCash()>0)
			info += "Cash: "+((Base) card).getCash();
		return info;
	}
}

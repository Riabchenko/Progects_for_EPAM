package com.intellect25.metro.test;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 30.04.2015
*
*/
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;
import com.intellect25.metro.Cards;
import com.intellect25.metro.CountAndDays;
import com.intellect25.metro.FactoryOfCards;
import com.intellect25.metro.Tourniquete;
import com.intellect25.metro.Type;

public class TourniqueteTest {
	Cards c,c1,c2,c3;
	Tourniquete tur = new Tourniquete();
	private int[] info = null;
	
	
	@Before
	public void initialCardsForTesPassThroughTheTurnslite(){		
		c = FactoryOfCards.getInstance(Type.BASE,CountAndDays.DAY_10, new GregorianCalendar(2015, Calendar.JUNE, 1));		
		c1 = FactoryOfCards.getInstance(Type.SCHOOLBOY,CountAndDays.DAY_MONTH, new GregorianCalendar(2015, Calendar.JUNE, 1));
		c2 = FactoryOfCards.getInstance(Type.BASE,145f);
		c3 = FactoryOfCards.getInstance(Type.STUDENT,CountAndDays.COUNT_10);		
	}
	
	@Test
	/**Create new cards,for example. Use cards for enter*/
	public void tesPassThroughTheTurnslite_True() {
		//DAY_10
		String status = c.status;
		Calendar date = c.getDateEnd();
		tur.enter(c);
		assertEquals(c.getStatus(),status);
		assertEquals(c.getDateEnd(),date);
		
		//DAY_MONTH
		status = c1.status;
		date = c1.getDateEnd();
		tur.enter(c1);
		assertEquals(c1.getStatus(),status);
		assertEquals(c1.getDateEnd(),date);
		
		//145f - cash
		status = c2.status;
		int count = c2.getCount();
		tur.enter(c2);
		String resStatus = c2.status;
		int resCount = c2.getCount();
		assertEquals(resCount,count-1);
		assertEquals(resStatus,status);	
		
		
		//COUNT_10
		status = c3.status;
		count = c3.getCount();
		tur.enter(c3);
		resStatus = c3.status;
		resCount = c3.getCount();
		assertEquals(resCount,count-1);
		assertEquals(resStatus,status);	
			
	}
	
	@Before
	public void initialTestDisplayPermissions(){		
		Cards card = FactoryOfCards.getInstance(Type.BASE,CountAndDays.DAY_10, new GregorianCalendar(2015, Calendar.JUNE, 1));		
		Cards card1 = FactoryOfCards.getInstance(Type.SCHOOLBOY,CountAndDays.DAY_MONTH, new GregorianCalendar(2014, Calendar.JUNE, 1));
		Cards card2 = FactoryOfCards.getInstance(Type.BASE,3f);
		Cards card3 = FactoryOfCards.getInstance(Type.STUDENT,CountAndDays.COUNT_10);	
		
		tur.enter(card); //BASE
		tur.enter(card1); //SCHOOLBOY - the bad card
		tur.enter(card2); //BASE - the bad card
		tur.enter(card2); //BASE - the bad card
		tur.enter(card3); //STUDENT
		
		info = new int[6];
		info[0]= 1; //allowed BASE
		info[1]= 0; //allowed SCHOOLBOY
		info[2]= 1; //allowed STUDENT
		info[3]= 2; //notAllowed BASE
		info[4]= 1; //notAllowed SCHOOLBOY
		info[5]= 0; //notAllowed STUDENT
	}
	
	@Test
	public void testDisplayPermissions_True() {
		int [] resultInfo = tur.displayPermissions();
		assertArrayEquals(info,resultInfo);
	}
	
	@Test
	public void testShowOnDisplayPermissions_ResultAsString() {
		String showResult = tur.showOnDisplay();
		System.out.println(showResult);
	}

	@Test
	public void testShowWholeResultOfPermissionsOnDisplay_ResultAsString() {
		String showWholeResult = tur.showAllOnDisplay();
		System.out.println(showWholeResult);
	}

}

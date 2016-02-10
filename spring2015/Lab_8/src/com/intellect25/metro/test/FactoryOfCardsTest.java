/**
 * 
 */
package com.intellect25.metro.test;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import com.intellect25.metro.Base;
import com.intellect25.metro.Cards;
import com.intellect25.metro.CountAndDays;
import com.intellect25.metro.FactoryOfCards;
import com.intellect25.metro.Schoolboy;
import com.intellect25.metro.Student;
import com.intellect25.metro.Type;

/**
 * @author apple
 *
 */
public class FactoryOfCardsTest {

	
//---------------------------------------------------------------------------------------------------//
 
	@Parameter
	private Base expResultBase = new Base();
	
	@Before
	public void setUpBefor_TestGetInstanceTypeOfCardsIsCashWithFloat(){
		expResultBase.setCount(5);//5*4=20
		expResultBase.addCash(3.4f);//20+3.4=23.4
	}
	@After
	public void clearUpBefor_TestGetInstanceTypeOfCardsIsCashWithFloat(){
	  expResultBase = null;
	}
	/**
	 * Test method for {@link com.intellect25.metro.FactoryOfCards#getInstance(com.intellect25.metro.Type, float)}.
	 */
	@Test
	public void testGetInstanceTypeOfCardsIsCashWithFloat_True() {	
		Cards result = FactoryOfCards.getInstance(Type.BASE, 23.4f); // create new card with  parameters
		assertEquals(expResultBase.getType(), result.getType()); //True if types are equals
		assertEquals(expResultBase.getCount(), result.getCount()); //True if counts of trips are equals
		
		int one = (int) expResultBase.getCash();
		int two = (int) ((Base)result).getCash();
		assertEquals(one, two); //True if cash are equals

	}

//---------------------------------------------------------------------------------------------------//
	@Parameter
  public Base expResultBaseSetCount10 = new Base();
	public Schoolboy expResultSchoolboySetCount10 = new Schoolboy();
	public Student expResultStudentSetCount10 = new Student();
	
  public Base expResultBaseSetCount5 = new Base();
	public Schoolboy expResultSchoolboySetCount5 = new Schoolboy();
	public Student expResultStudentSetCount5 = new Student();
	
	@Before
	public void setUpBefor_TestGetInstanceTypeCount(){		
		expResultBaseSetCount5.setCount(5);
		expResultSchoolboySetCount5.setCount(5);
		expResultStudentSetCount5.setCount(5);
		
		expResultBaseSetCount10.setCount(10);
		expResultSchoolboySetCount10.setCount(10);
		expResultStudentSetCount10.setCount(10);
		
	}

	

	/**
	 * Test method for {@link com.intellect25.metro.FactoryOfCards#getInstance(com.intellect25.metro.Type, com.intellect25.metro.CountAndDays)}.
	 *
	 */
	@Test
	public void testGetInstanceTypeCount_True() {
		//***********count 10*************//
		Cards result = FactoryOfCards.getInstance(Type.BASE,CountAndDays.COUNT_10);
		assertEquals(expResultBaseSetCount10.getType(), result.getType()); //True if types are equals
		assertEquals(expResultBaseSetCount10.getCount(), result.getCount()); //True if counts of trips are equals
		
		Cards resultForSchoolboy = FactoryOfCards.getInstance(Type.SCHOOLBOY,CountAndDays.COUNT_10);
		assertEquals(expResultSchoolboySetCount10.getType(), resultForSchoolboy.getType()); //True if types are equals
		assertEquals(expResultSchoolboySetCount10.getCount(), resultForSchoolboy.getCount()); //True if counts of trips are equals
		
		Cards resultForStudent = FactoryOfCards.getInstance(Type.STUDENT,CountAndDays.COUNT_10);
		assertEquals(expResultStudentSetCount10.getType(), resultForStudent.getType()); //True if types are equals
		assertEquals(expResultStudentSetCount10.getCount(), resultForStudent.getCount()); //True if counts of trips are equals

	//***********count 5*************//
		Cards resultFor5 = FactoryOfCards.getInstance(Type.BASE,CountAndDays.COUNT_5);
		assertEquals(expResultBaseSetCount5.getType(), resultFor5.getType()); //True if types are equals
		assertEquals(expResultBaseSetCount5.getCount(), resultFor5.getCount()); //True if counts of trips are equals
		
		Cards resultForSchoolboyFor5 = FactoryOfCards.getInstance(Type.SCHOOLBOY,CountAndDays.COUNT_5);
		assertEquals(expResultSchoolboySetCount5.getType(), resultForSchoolboyFor5.getType()); //True if types are equals
		assertEquals(expResultSchoolboySetCount5.getCount(), resultForSchoolboyFor5.getCount()); //True if counts of trips are equals
		
		Cards resultForStudentFor5 = FactoryOfCards.getInstance(Type.STUDENT,CountAndDays.COUNT_5);
		assertEquals(expResultStudentSetCount5.getType(), resultForStudentFor5.getType()); //True if types are equals
		assertEquals(expResultStudentSetCount5.getCount(), resultForStudentFor5.getCount()); //True if counts of trips are equals

	}

//---------------------------------------------------------------------------------------------------//
	@Parameter
  public Base expResultBaseSetDays10 = new Base();
	public Schoolboy expResultSchoolboySetDays10 = new Schoolboy();
	public Student expResultStudentSetDays10 = new Student();
	
  public Base expResultBaseSetDaysMonth = new Base();
	public Schoolboy expResultSchoolboySetDaysMonth = new Schoolboy();
	public Student expResultStudentSetDaysMonth = new Student();
	
	@Before
	public void setUpBefor_TestGetInstanceTypeCountAndDays(){
		
		expResultBaseSetDays10.setCountAndDays(CountAndDays.DAY_10);
		expResultSchoolboySetDays10.setCountAndDays(CountAndDays.DAY_10);
		expResultStudentSetDays10.setCountAndDays(CountAndDays.DAY_10);
		
		expResultBaseSetDaysMonth.setCountAndDays(CountAndDays.DAY_MONTH);
		expResultSchoolboySetDaysMonth.setCountAndDays(CountAndDays.DAY_MONTH);
		expResultStudentSetDaysMonth.setCountAndDays(CountAndDays.DAY_MONTH);
	}

	/**
	 * Test method for {@link com.intellect25.metro.FactoryOfCards#getInstance(com.intellect25.metro.Type, com.intellect25.metro.CountAndDays)}.
	 *
	 */
	@Test
	public void testGetInstanceTypeCountAndDays_True() {
		//for 10 days
		Cards result10 = FactoryOfCards.getInstance(Type.BASE,CountAndDays.DAY_10);
		assertEquals(expResultBaseSetDays10.getType(), result10.getType()); //True if types are equals
		assertEquals(expResultBaseSetDays10.getDateEnd(), result10.getDateEnd()); //True if count of days are equals
		
		Cards resultForSchoolboyFor10 = FactoryOfCards.getInstance(Type.SCHOOLBOY,CountAndDays.DAY_10);
		assertEquals(expResultSchoolboySetDays10.getType(), resultForSchoolboyFor10.getType()); //True if types are equals
		assertEquals(expResultSchoolboySetDays10.getDateEnd(), resultForSchoolboyFor10.getDateEnd()); //True if count of days are equals
		
		Cards resultForStudent10 = FactoryOfCards.getInstance(Type.STUDENT,CountAndDays.DAY_10);
		assertEquals(expResultStudentSetDays10.getType(), resultForStudent10.getType()); //True if types are equals
		assertEquals(expResultStudentSetDays10.getDateEnd(), resultForStudent10.getDateEnd()); //True if count of days are equals

		//for month
		Cards resultMonth = FactoryOfCards.getInstance(Type.BASE,CountAndDays.DAY_10);
		assertEquals(expResultBaseSetDaysMonth.getType(), resultMonth.getType()); //True if types are equals
		assertEquals(expResultBaseSetDaysMonth.getDateEnd(), resultMonth.getDateEnd()); //True if count of days are equals
		
		Cards resultForSchoolboyForMonth = FactoryOfCards.getInstance(Type.SCHOOLBOY,CountAndDays.DAY_10);
		assertEquals(expResultSchoolboySetDaysMonth.getType(), resultForSchoolboyForMonth.getType()); //True if types are equals
		assertEquals(expResultSchoolboySetDaysMonth.getDateEnd(), resultForSchoolboyForMonth.getDateEnd()); //True if count of days are equals
		
		Cards resultForStudentMonth = FactoryOfCards.getInstance(Type.STUDENT,CountAndDays.DAY_10);
		assertEquals(expResultStudentSetDaysMonth.getType(), resultForStudentMonth.getType()); //True if types are equals
		assertEquals(expResultStudentSetDaysMonth.getDateEnd(), resultForStudentMonth.getDateEnd()); //True if count of days are equals
	}


//---------------------------------------------------------------------------------------------------//
	@Parameter
  public Base expResultBaseSetDay = new Base();
	public Schoolboy expResultSchoolboySetDay = new Schoolboy();
	public Student expResultStudentSetDay = new Student();
	
	@Before
	public void setUpBefor_TestGetInstanceTypeCountAndDaysCalendar(){
		expResultBaseSetDay.setDateEnd(new GregorianCalendar(2015, Calendar.JUNE, 11));
		expResultSchoolboySetDay.setDateEnd(new GregorianCalendar(2015, Calendar.JUNE, 11));
		expResultStudentSetDay.setDateEnd(new GregorianCalendar(2015, Calendar.JUNE, 11));
	}

	/**
	 * Test method for {@link com.intellect25.metro.FactoryOfCards#getInstance(com.intellect25.metro.Type, com.intellect25.metro.CountAndDays, java.util.Calendar)}.
	 */
	@Test
	public void testGetInstanceTypeCountAndDaysCalendar_True() {
		
		Cards resultForBase = FactoryOfCards.getInstance(Type.BASE,CountAndDays.DAY_10, new GregorianCalendar(2015, Calendar.JUNE, 1));
		assertEquals(expResultBaseSetDay.getDateEnd(), resultForBase.getDateEnd()); //True if days of end are equals
		
		Cards resultForSchoolboy = FactoryOfCards.getInstance(Type.SCHOOLBOY,CountAndDays.DAY_10, new GregorianCalendar(2015, Calendar.JUNE, 1));
		assertEquals(expResultSchoolboySetDay.getDateEnd(), resultForSchoolboy.getDateEnd()); //True if days of end are equals
		
		Cards resultForStudent = FactoryOfCards.getInstance(Type.SCHOOLBOY,CountAndDays.DAY_10, new GregorianCalendar(2015, Calendar.JUNE, 1));
		assertEquals(expResultStudentSetDay.getDateEnd(), resultForStudent.getDateEnd()); //True if days of end are equals
	}

	
//---------------------------------------------------------------------------------------------------//
	@Parameter
	public int countOfCards = 7;

	/**
	 * Test method for {@link com.intellect25.metro.FactoryOfCards#countOfCards()}.
	 */
	@Test
	public void testCountOfCards_True() {
		int result = FactoryOfCards.countOfCards();
		assertEquals(countOfCards,result);

	}


}

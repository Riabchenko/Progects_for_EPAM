package com.intellect25.fruit;
/**
 * 
 * @author Riabchenko Aliona
 * @version 1.0 Build 25.05.2015
 * 
 */
public class Apple extends Fruit{
	
	public Apple(int amount){
		this.amount = amount;
	}
	public Apple(){
		this.amount = 1;
	}

	@Override
	String getFruit() {
		return "Aple";
	}
	@Override
  public int getAmount(){
  	return amount;
  }

}

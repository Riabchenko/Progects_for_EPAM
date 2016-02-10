package com.intellect25.fruit;
/**
 * 
 * @author Riabchenko Aliona
 * @version 1.0 Build 25.05.2015
 * 
 */
public class Melon extends Fruit{

	public Melon(int amount){
		this.amount = amount;
	}
	
	public Melon(){
		this.amount = 1;
	}
	@Override
  public int getAmount(){
  	return amount;
  }
	@Override
	String getFruit() {
		return "Melon";
	}
	

}

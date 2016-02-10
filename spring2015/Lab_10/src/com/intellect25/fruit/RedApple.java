package com.intellect25.fruit;
/**
 * 
 * @author Riabchenko Aliona
 * @version 1.0 Build 25.05.2015
 * 
 */
public class RedApple extends Apple{

	public RedApple(int amount){
		this.amount = amount;
	}
	public RedApple(){
		this.amount = 1;
	}
	@Override
  public int getAmount(){
  	return amount;
  }
	@Override
	String getFruit() {
		return "RedAple";
	}
	

}

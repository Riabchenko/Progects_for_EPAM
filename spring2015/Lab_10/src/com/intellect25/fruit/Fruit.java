package com.intellect25.fruit;
/**
 * 
 * @author Riabchenko Aliona
 * @version 1.0 Build 25.05.2015
 * 
 */
public abstract class Fruit {
	 public static int count;
	 int id = count++;
	 int amount;
	 
	 protected int getId(){
		 return id;
	 }
	 
   public int getAmount() {
     return this.amount;
   }
   abstract String getFruit();
}

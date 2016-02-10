package com.intellect25.task1.characteristicsOfStones;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 11.05.2015
*
*This class enumerates Forms of stones
*
*/
public enum Forma {
	ROUND(0.0018f),OVAL(0.0020f),EMERALD(0.00245f),BAGUETTE(0.0029f),MARQUISE(0.0016f),PEAR(0.00175f),PRINCESS(0.0023f);
	
	float f;
	
	Forma(float f){
		this.f = f;
	}
	
	public float getProperty(){
		return f;
	}
}

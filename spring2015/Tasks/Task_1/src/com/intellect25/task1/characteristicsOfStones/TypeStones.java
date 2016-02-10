package com.intellect25.task1.characteristicsOfStones;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 11.05.2015
*
*This class enumerates types of stones
*
*/
public enum TypeStones {
	DIAMOND(3.52f),SAPPHIRE(3.99f),RUBY(3.99f),ALEXANDRITE(3.71f);
	
	float f;
	
	TypeStones(float f){
		this.f = f;
	}
	
	public float getDensity(){
		return f;
	}
}

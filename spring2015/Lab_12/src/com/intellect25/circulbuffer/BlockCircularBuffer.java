
package com.intellect25.circulbuffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 20.06.2015
*
*
*/
public class BlockCircularBuffer {

	public static StringBuilder sb;
    
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(20);
        new Producer(cb).start();
        new Producer(cb).start();
        new Consumer(cb).start();
        new Consumer(cb).start();
        
        new Producer(cb).start();
        new Producer(cb).start();
        new Consumer(cb).start();
        new Consumer(cb).start();
        
        new Producer(cb).start();
        new Producer(cb).start();
        new Consumer(cb).start();
        new Consumer(cb).start();
      
        writeToFile(sb);

    }
    
    /**
     * This method writes data to file result.txt
     * @param data input information
     */
    public static void writeToFile(StringBuilder data){
      BufferedWriter br;
  		try {
  			br = new BufferedWriter(new FileWriter("result.txt"));
      br.append(data);
      br.close();
  	}
  	catch (IOException e) {
  		e.printStackTrace();
  	}
    }
    
  	public static StringBuilder getSb() {
  		return sb;
  	}

  	public static void setSb(String data) {
  		if(sb == null) sb  = new StringBuilder();
  		BlockCircularBuffer.sb.append(data);
  		BlockCircularBuffer.sb.append("\n");
  		System.out.println(sb);
  	}
}

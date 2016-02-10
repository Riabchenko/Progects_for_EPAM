package com.intellect25.circulbuffer;

import java.util.Random;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 20.06.2015
*
*
*/
public class Producer extends Thread {

  	static final int capacity = 20;
  	Object[] generatedData = generateData();
  	int readIndex = 0;
    private int i = 1;
    private final CircularBuffer cb;
    
    
    public Producer(CircularBuffer cb) {
        this.cb = cb;
    }

    private Object[] generateData() {
        Object[] obj = new Object[capacity];
        Random r = new Random();

        for (int i = 0; i < capacity; i++) {
            Integer next = Integer.valueOf(r.nextInt(1000));
            obj[i] = next;
        }
        return obj;
    }

    public void putToBufferedData(Object next) {
        synchronized (cb) {
            if (cb.add(next)) {

            		cb.notifyAll();
            		String data = getName() + " Producer #" + getId() + " wrote: " + next;
            		BlockCircularBuffer.setSb(data);

            } else {
                try {
                    String data = getName() + " Producer #" + getId() + " will wait";
                    BlockCircularBuffer.sb.append(data);
                    cb.wait();
                    String data1 = getName() + " Producer #" + getId() + " woke up";
                    BlockCircularBuffer.setSb(data1);
                    putToBufferedData(next);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void run() {
        String data3 = getName() + " Producer #" + getId() + " started.";
        BlockCircularBuffer.setSb(data3);
        while (readIndex < capacity) {
            putToBufferedData(generatedData[readIndex++]);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        String data4 = getName() + " Producer #" + getId() + " finished.";
        BlockCircularBuffer.setSb(data4);
    }


}

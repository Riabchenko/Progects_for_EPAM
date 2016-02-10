
package com.intellect25.circulbuffer;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 20.06.2015
*
*
*/
public class Consumer extends Thread {
  private final Object[] dataResult;
  private CircularBuffer cb;
  private int nextIndex = 0;

  Consumer(CircularBuffer buffer, int maxSize) {
      this.dataResult = new Object[maxSize];
      cb = buffer;
  }
  
  Consumer(CircularBuffer buffer) {
    this.dataResult = new Object[10];
    cb = buffer;
  }

  public Object[] getDataResult() {
      return dataResult;
  }

  public void getBufferedData() {
      Object next;
      synchronized (cb) {
          if ((next = cb.peek()) == null) {
              try {
                  String data = getName() + " Consumer #" + getId() + " will wait";
                  BlockCircularBuffer.setSb(data);
                  cb.wait(1000);
                  String data1 = getName() + " Consumer #" + getId() + " woke up";
                  BlockCircularBuffer.setSb(data1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              return;
          }
          cb.notifyAll();
      }

      String data2 = getName() + " #" + getId() + " read: " + next + " size: " + nextIndex;
      BlockCircularBuffer.setSb(data2);
      dataResult[nextIndex++] = next;
  }

  @Override
  public void run() {
      String data3 = "Consumer #" + getId() + " started.";
      BlockCircularBuffer.setSb(data3);
      while (nextIndex < dataResult.length) {
          getBufferedData();
          try {
              sleep(500);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      String data5 = "Consumer #" + getId() + " finished.";
      System.out.println(data5+"finish");
      BlockCircularBuffer.setSb(data5);
  }
}

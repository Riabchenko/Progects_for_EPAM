package com.intellect25.entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Institute which takes  form of entrants who want to enter to Mathematics
 *
 * @author Riabchenko Aliona
 */
public class Mathematics extends Institute {

    /** Store list of form*/
    private Queue<Form> listOfMathematics = new LinkedList<>();

    @Override
    public Form poll() {
        return listOfMathematics.poll();
    }

    @Override
    public void offer(Form form) {
        this.listOfMathematics.offer(form);
    }

    @Override
    public int size(){
        return listOfMathematics.size();
    }

    @Override
    public Queue<Form> getList() {
        return listOfMathematics;
    }
}

package com.intellect25.entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Institute which takes  form of entrants who want to enter to Biology
 *
 * @author Riabchenko Aliona
 */
public class Biology extends Institute{

    /** Store list of form*/
    private Queue<Form> listOfBiologic = new LinkedList<>();

    @Override
    public Form poll() {
        return listOfBiologic.poll();
    }

    @Override
    public void offer(Form form) {
        this.listOfBiologic.offer(form);
    }

    @Override
    public int size(){
        return listOfBiologic.size();
    }

    @Override
    public Queue<Form> getList() {
        return listOfBiologic;
    }
}

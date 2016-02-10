package com.intellect25.entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Institute which takes form of any entrants
 *
 * @author Riabchenko Aliona
 */
public class Anything extends Institute {

    /** Store list of form*/
    private Queue<Form> listOfAnything = new LinkedList<>();

    @Override
    public Form poll() {
        return listOfAnything.poll();
    }

    @Override
    public void offer(Form form) {
        this.listOfAnything.offer(form);
    }

    @Override
    public int size(){
        return listOfAnything.size();
    }

    @Override
    public Queue<Form> getList() {
        return listOfAnything;
    }
}

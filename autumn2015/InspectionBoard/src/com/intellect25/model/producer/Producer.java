package com.intellect25.model.producer;

import com.intellect25.entity.Form;
import com.intellect25.model.Buffer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * One of producer witch gives forms to buffer
 *
 * @author Riabchenko Aliona
 */
public class Producer implements Runnable {

    /** Buffer */
    private final Buffer buffer;

    /** Store list of forms*/
    private Queue<Form> forms = new ArrayDeque<>();

    {
        /** Gets and adds list of forms */
        forms.addAll(GenerationForm.getInstance().generate());
    }

    /**
     * Constructor
     *
     * @param buffer buffer
     */
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (this){
        try {
            while (forms.peek() != null) {
                put(forms.poll());
                Thread.sleep(10);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

    /**
     * Puts form to buffer
     *
     * @param form form
     */
    private void put(Form form){
        buffer.put(form);
    }
}

package com.intellect25.model.consumer;

import com.intellect25.entity.*;
import com.intellect25.model.Buffer;
import com.intellect25.model.producer.FactoryForm;

/**
 * One of consumers witch takes forms and puts them to
 * object of Mathematics (Institute)
 *
 * @author Riabchenko Aliona
 */
public class ConsumerMathematics extends Consumer{

    /** Received Forms puts in this object (Institute) */
    private Mathematics mathematics;

    {
        mathematics = (Mathematics) FactoryEntity.getInstance().create(TypeEntity.MATHEMATICS);
    }

    /** Store received Form which doesn't belong Mathematics Institute*/
    private Form formOfBiology;

    /**
     * Constructor
     *
     * @param buffer buffer
     */
    public ConsumerMathematics(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!buffer.isStopConsumer()) {
                if (!put(buffer.get())) return;
            }
        }
    }

    @Override
    public synchronized Mathematics get() {
        return mathematics;
    }

    /**
     * Puts form to Object of Institute
     *
     * @param form input form
     * @return false or true
     */
    public synchronized boolean put(Form form){
        if (form != null) {

            Form formMathematics = FactoryForm.getInstanceOfForm();
            formMathematics.setExamFirst(TypeSubject.MATHEMATICS);
            formMathematics.setExamSecond(TypeSubject.PHYSICS);
            formMathematics.setExamThird(TypeSubject.UKRAINE_LANGUAGE);

            if (form.equals(formMathematics)) {
                mathematics.offer(form);
                return true;
            } else {
                setFormOfBiology(form);
                return false;
            }

        } return false;
    }

    /**
     * Get form of biology
     *
     * @return form
     */
    public synchronized Form getFormOfBiology() {
        Form temp = formOfBiology;
        formOfBiology = null;
        return temp;
    }

    /**
     * Set form of biology
     *
     * @param formOfBiology form
     */
    public void setFormOfBiology(Form formOfBiology) {
        this.formOfBiology = formOfBiology;
    }
}

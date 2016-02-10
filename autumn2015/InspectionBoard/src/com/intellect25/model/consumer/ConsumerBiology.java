package com.intellect25.model.consumer;

import com.intellect25.entity.*;
import com.intellect25.model.Buffer;
import com.intellect25.model.producer.FactoryForm;

/**
 * One of consumers witch takes forms and puts them to
 * object of Biology (Institute)
 *
 * @author Riabchenko Aliona
 */
public class ConsumerBiology extends Consumer{

    /** Received Forms puts in this object (Institute) */
    private Biology biology;

    {
        biology = (Biology) FactoryEntity.getInstance().create(TypeEntity.BIOLOGY);
    }

    /** Store received Form which doesn't belong Biology Institute*/
    private Form formOfMathematics;

    /**
     * Constructor
     *
     * @param buffer buffer
     */
    public ConsumerBiology(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!buffer.isStopConsumer()) {
                if (!put( buffer.get())) return;
            }
        }
    }

    @Override
    public synchronized Biology get() {
        return biology;
    }

    /**
     * Puts form to Object of Institute
     *
     * @param form input form
     * @return false or true
     */
    public synchronized boolean put(Form form){
        if (form != null) {
            Form formBiology = FactoryForm.getInstanceOfForm();
            formBiology.setExamFirst(TypeSubject.BIOLOGY);
            formBiology.setExamSecond(TypeSubject.CHEMISTRY);
            formBiology.setExamThird(TypeSubject.UKRAINE_LANGUAGE);

            if (form.equals(formBiology)) {
                biology.offer(form);
                return true;
            } else {
                setFormOfMathematics(form);
                return false;
            }

        } return false;
    }

    /**
     * Get form of mathematics
     *
     * @return form
     */
    public synchronized Form getFormOfMathematics() {
        Form temp = formOfMathematics;
        formOfMathematics = null;
        return temp;
    }

    /**
     *  Set form of mathematics
     *
     * @param formOfMathematics form
     */
    private synchronized  void setFormOfMathematics(Form formOfMathematics) {
        this.formOfMathematics = formOfMathematics;
    }
}

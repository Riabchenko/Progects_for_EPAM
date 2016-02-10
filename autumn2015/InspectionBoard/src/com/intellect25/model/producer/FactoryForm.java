package com.intellect25.model.producer;

import com.intellect25.entity.Form;

/**
 * Factory for forms
 *
 * @author Riabchenko Aliona
 */
public class FactoryForm {

    public static Form getInstanceOfForm(){
        return new Form();
    }
}

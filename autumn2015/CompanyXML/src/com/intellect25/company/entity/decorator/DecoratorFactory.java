package com.intellect25.company.entity.decorator;

import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.object.TypeEmployee;

/**
 * Created by apple on 1/12/16.
 */
public class DecoratorFactory {
    private static DecoratorFactory decoratorFactory;

    private DecoratorFactory() {
    }

    public static DecoratorFactory getInstance(){
        if (decoratorFactory == null)
            decoratorFactory = new DecoratorFactory();
        return decoratorFactory;
    }

    public Employee createEmployee(TypeEmployee type,Employee employee){
        switch (type){
            case MANAGER:
                return new DecoratorManager(employee);
            case WORKER:
                return new DecoratorWorker(employee);
            case OTHER:
                return new DecoratorOther(employee);

            default:
                throw new NullPointerException("");
        }
    }
}

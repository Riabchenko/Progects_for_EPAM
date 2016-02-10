package com.intellect25.entity;

/**
 * Factory for Entity
 *
 * @author Riabchenko Aliona
 */
public class FactoryEntity {

    /** Instance of this class */
    private static FactoryEntity factoryEntity;

    /**
     * Private constructor
     */
    private FactoryEntity() {
    }

    /**
     * Get instance of this class
     *
     * @return FactoryEntity
     */
    public static FactoryEntity getInstance(){
        if (factoryEntity == null)
            factoryEntity = new FactoryEntity();
        return factoryEntity;
    }

    /**
     * Create need object
     *
     * @param typeEntity type
     * @return object
     */
    public Object create(TypeEntity typeEntity){
        switch (typeEntity){
            case BIOLOGY:
                return new Biology();
            case MATHEMATICS:
                return new Mathematics();
            case ANYTHING:
                return new Anything();
            case CONCLUSION:
                return new Conclusion();

            default:
                throw new NullPointerException("");
        }

    }
}

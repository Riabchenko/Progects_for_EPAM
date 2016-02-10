package com.intellect25.model.producer;

import com.intellect25.entity.Form;
import com.intellect25.entity.TypeSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generate some forms
 *
 * @author Riabchenko Aliona
 */
public class GenerationForm {

    /** Max count of biologic*/
    private static final int COUNT_OF_BIOLOGIC = 200;

    /** Max count of mathematics*/
    private static final int COUNT_OF_MATHEMATICS = 250;

    /** Count of biologic*/
    private int countBiologic;

    /** Count of mathematics*/
    private int countMathematics;

    /** List of some first names */
    private List<String> firstNames = new ArrayList<>();

    /** List of some last names */
    private List<String> lastNames = new ArrayList<>();

    /**
     * List of generated forms
     */
    private List<Form> forms = new ArrayList<>();

    {
        firstNames.add("Александр");
        firstNames.add("Михаил");
        firstNames.add("Максим");
        firstNames.add("Даниил");
        firstNames.add("Валентин");
        firstNames.add("Марина");
        firstNames.add("Наталья");
        firstNames.add("Ольга");
        firstNames.add("Елена");

        lastNames.add("Никулин");
        lastNames.add("Пушкин");
        lastNames.add("Левков");
        lastNames.add("Литвинов");
        lastNames.add("Захарченко");
        lastNames.add("Пушкарев");
        lastNames.add("Семенов");
        lastNames.add("Гагарин");
    }

    /**
     * Private constructor
     */
    private GenerationForm() {
    }

    /**
     * Get instance of this class
     *
     * @return GenerationForm
     */
    public static GenerationForm getInstance(){
        return new GenerationForm();
    }

    /**
     * Generate form
     *
     * @return list of form
     */
    public List<Form> generate(){
        while (forms.size() < COUNT_OF_BIOLOGIC + COUNT_OF_MATHEMATICS) {

            Random random = new Random();
            String firstName = firstNames.get(random.nextInt(firstNames.size()));
            String lastName = lastNames.get(random.nextInt(lastNames.size()));

            boolean isBiology = random.nextBoolean();

            if (countBiologic >= COUNT_OF_BIOLOGIC) isBiology = false;
            if (countMathematics >= COUNT_OF_MATHEMATICS) isBiology = true;

            Form newForm = createForm(isBiology, firstName, lastName);

            /* Set id of student */
            newForm.setId(forms.size());

            forms.add(newForm);

        }
//        Collections.shuffle(forms);
        return forms;
    }

    /**
     * Create forms
     *
     * @param isBiologic boolean value
     * @param firstName first name
     * @param lastName last name
     * @return form
     */
    private Form createForm(boolean isBiologic,String firstName,String lastName){

        /* Create form */
        Form form = FactoryForm.getInstanceOfForm();
        form.setFirstName(firstName);
        form.setLastName(lastName);

        /* Set exam (for different institute, different exam) */
        form.setExamFirst(TypeSubject.UKRAINE_LANGUAGE);

        if (isBiologic) {
            form.setExamSecond(TypeSubject.BIOLOGY);
            form.setExamThird(TypeSubject.CHEMISTRY);
            countBiologic++;
        } else {
            form.setExamSecond(TypeSubject.MATHEMATICS);
            form.setExamThird(TypeSubject.PHYSICS);
            countMathematics++;
        }

        return form;
    }



}

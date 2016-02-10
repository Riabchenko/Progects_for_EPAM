package com.intellect25.entity;

/**
 * Form of entrant
 *
 * @author Riabchenko Aliona
 */
public class Form {

	/** Id of entrant*/
	private int id;

	/**  First name */
	private String firstName;

	/** Last Name */
	private String lastName;

	/** Field for first exam */
	private TypeSubject examFirst;

	/** Field for second exam */
	private TypeSubject examSecond;

	/** Field for third exam */
	private TypeSubject examThird;


	@Override
	public boolean equals(Object o) {
		return ((Form)o).getHash() - getHash() == 0;
	}

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result * getExamFirst().getCode();
        result = 31 * result * getExamSecond().getCode();
        result = 31 * result * getExamThird().getCode();
        return result;
    }

    public int getHash() {
        return hashCode();
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public TypeSubject getExamFirst() {
		return examFirst;
	}

	public void setExamFirst(TypeSubject examFirst) {
		this.examFirst = examFirst;
	}

	public TypeSubject getExamSecond() {
		return examSecond;
	}

	public void setExamSecond(TypeSubject examSecond) {
		this.examSecond = examSecond;
	}

	public TypeSubject getExamThird() {
		return examThird;
	}

	public void setExamThird(TypeSubject examThird) {
		this.examThird = examThird;
	}
}

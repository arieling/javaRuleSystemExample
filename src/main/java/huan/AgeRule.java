package huan;

import org.easyrules.core.BasicRule;


public class AgeRule extends BasicRule implements AgeJmxRule{

    private int ADULT_AGE = 18;

    private Person person;

    public AgeRule(Person person) {
        super("AgeRule",
              "Check if person's age is > 18 and marks the person as adult", 1);
        this.person = person;
    }

    @Override
    public boolean evaluate() {
        return person.getAge() > ADULT_AGE;
    }

    @Override
    public void execute() {
        person.setAdult(true);
        System.out.printf("Person %s has been marked as adult",
                            person.getName());
    }

	@Override
	public int getAdultAge() {
		return ADULT_AGE;
	}

	@Override
	public void setAdultAge(int adultAge) {
		this.ADULT_AGE = adultAge;
		
	}

}
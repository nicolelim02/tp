package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
/**
 *
 */
public class Calorie {
    public static final String VALIDATION_REGEX = "\\d+";
    public static final String MESSAGE_CONSTRAINTS = "Calorie must take on a positive number that is not too large.";
    public final String value;


    /**
     * Initialises a Calorie object.
     */
    public Calorie() {
        this.value = "2000";
    }

    /**
     * @param calorie
     */
    public Calorie(String calorie) {
        requireNonNull(calorie);
        checkArgument(isValidCalorie(calorie), MESSAGE_CONSTRAINTS);
        value = calorie;
    }

    /**
     * Returns true if a given string is a valid calorie value.
     */
    public static boolean isValidCalorie(String calorie) {
        if (!calorie.isEmpty() && calorie.matches(VALIDATION_REGEX)) {
            try {
                Integer calorieValue = Integer.parseInt(calorie);
                return calorieValue >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return value + " calories";
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Calorie) {
            return this.value.equals(((Calorie) other).value);
        }
        return false;
    }
}

package ir.ac.kntu.logic;

/**
 * @author sina rostami
 *
 */
public class Calculator {

    /**
     * @param operand1 left-handed-side operand.
     * @param operand2 right-handed-side operand.
     * @param operator operator to apply on operands.
     * @return result of the calculation
     */
    public static Integer calculate(StringBuilder operand1, StringBuilder operand2, StringBuilder operator) {
        switch (Operator.valueOf(operator.toString())) {
            case PLUS:
                return Integer.parseInt(operand1.toString()) + Integer.parseInt(operand2.toString());
            case MINUS:
                return Integer.parseInt(operand1.toString()) - Integer.parseInt(operand2.toString());
            case DIVIDE:
                return Integer.parseInt(operand1.toString()) / Integer.parseInt(operand2.toString());
            case MULTIPLY:
                return Integer.parseInt(operand1.toString()) * Integer.parseInt(operand2.toString());
            case UNKNOWN:
            default:
                return 0;
        }
    }
}
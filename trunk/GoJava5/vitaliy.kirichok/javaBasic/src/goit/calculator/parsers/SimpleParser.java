package goit.calculator.parsers;

import goit.calculator.operations.Operation;
import goit.calculator.operations.OperationFactory;
import goit.common.ParseException;

public class SimpleParser implements Parser {

    private boolean isValid(String text) {
        return text.matches("^[\\+|\\-]?\\d+[\\+|\\-|\\*|\\/]{1}\\d+$");
    }

    public Operation parse(String input) throws ParseException {
        String result = input.replaceAll("\\s", "");
        if (!isValid(result)) {
            throw new ParseException("Error when parsing string: ".concat("\"").concat(input).concat("\"."));
        }

        String firstOperandSign = "+";
        if (result.matches("^[\\+|\\-]{1}.*$")) {
            firstOperandSign = result.substring(0, 1);
            result = result.substring(1);
        }
        String[] operand = result.split("[\\+|\\-|\\*|\\/]");
        String operation = result.substring(operand[0].length(), operand[0].length() + 1);
        operand[0] = firstOperandSign.concat(operand[0]);

        return OperationFactory.getOperation(Integer.parseInt(operand[0]), Integer.parseInt(operand[1]), operation);
    }
}
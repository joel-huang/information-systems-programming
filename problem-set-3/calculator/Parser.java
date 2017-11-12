import Lexer.Token;
import java.util.LinkedList;
import java.Math;

class Parser {
	
	@SuppressWarnings("serial")
	static class ParserException extends RuntimeException {
	}

	private enum ValueType {
		POINTS, INCHES, SCALAR
	}

	public class Value {
		final double value;
		final ValueType type;

		Value(double value, ValueType type) {
			this.value = value;
			this.type = type;
		}

		@Override
		public String toString() {
			final double divide = 10000;
			double x;

			if (type==ValueType.INCHES){
				x = Math.round(value/PT_PER_IN*divide)/divide;
			} else {
				x = Math.round(value*div)/div;
			}

            switch (type) {
                case INCHES:
                    return val + " in";
                case POINTS:
                    return val + " pt";
                default:
                    return "" + val;
            }

		}
	}

	private static final double PT_PER_IN = 72;

	private Token tk;

	// TODO write method spec
	Parser(Lexer lexer) {
		this.tokenList = new LinkedList<Token>(lexer.getTokenList());
		this.tk = tokenList.getFirst();
	}
	private void nextToken() {
    	tokenList.pop();
        if (!tokenList.isEmpty()) {
            tk = tokenList.getFirst();
        } else {
            tk = new Token(Type.EPSILON, "");
        }
    }

    public Value evaluate() throws ParserException{

        Value result;

        if (tk.type == Type.NUMBER || tk.type == Type.L_PAREN) {
            result = expression();
        } else {
            throw new ParserException("\nInvalid starting symbol: " + tk.type);
        }
        if (tokenList.isEmpty()) {
            return result;
        }
        throw new ParserException("\nOrder not explicit.");
    }

    private Value expression() {
        Value t1 = term();
        if (tk.type == Type.EPSILON) {
            return t1;
        }
        Type operation = operator();
        if (operation == Type.R_PAREN) {
            return t1;
        }
        Value t2 = term();
        return operate(t1, t2, operation);
    }

    private Value term() throws ParserException {
        if (tk.type == Type.NUMBER) {
            double value = Double.parseDouble(tk.text);
            nextToken();

            ValueType unit = units();
            if (unit == ValueType.INCHES) {
                value *= PT_PER_IN;
            }

            return new Value(value, unit);
        }

        if (tk.type == Type.L_PAREN) {
            Value arg = argument();
            nextToken();
            ValueType unit = units();

            if (arg.type == ValueType.SCALAR && unit == ValueType.INCHES) {
                return new Value(arg.value * PT_PER_IN, unit);
            }

            if (unit == ValueType.SCALAR) {
                return arg;
            }

            return new Value(arg.value, unit);
        }
        throw new ParserException("\nUnknown term: " + tk.type);
    }

    private Value argument() throws ParserException {
        nextToken();
        Value arg = expression();

        if (tk.type == Type.R_PAREN) {
            return arg;
        }

        throw new ParserException("\nNot closing (): " + tk.type);
    }

    private ValueType units() {
        switch (tk.type) {
            case INCH:
                nextToken();
                return ValueType.INCHES;
            case POINT:
                nextToken();
                return ValueType.POINTS;
            default:
                return ValueType.SCALAR;
        }
    }

    private Type operator() throws ParserException {
        if (tk.type == Type.PLUS || tk.type == Type.MINUS || tk.type == Type.TIMES || tk.type == Type.DIVIDE) {
            Type output = tk.type;
            nextToken();
            return output;
        }

        if (tk.type == Type.R_PAREN) {
            return Type.R_PAREN;
        }

        throw new ParserException("\nNot operator: " + tk.type);
    }

    private Value operate(Value v1, Value v2, Type operation)
            throws ArithmeticException, ParserException {
        ValueType resultType = decideType(v1.type, v2.type, operation);
        double resultValue = 0;

        switch (operation) {
            case PLUS:
                resultValue = v1.value + v2.value;
                break;

            case MINUS:
                resultValue = v1.value - v2.value;
                break;

            case TIMES:
                if (v1.type != v2.type
                        && v1.type != ValueType.SCALAR && v2.type != ValueType.SCALAR) {
                	resultValue = v1.value * v2.value;

                } else {
                    resultValue = v1.value * v2.value;
                }

                if (v1.type == v2.type && v1.type == ValueType.INCHES) {
                    resultValue /= PT_PER_IN;
                }
                break;

            case DIVIDE:
                if (v2.value == 0) {
                    throw new ArithmeticException("\nDivision by 0.");
                }

                if (v1.type != v2.type && v1.type != ValueType.SCALAR && v2.type != ValueType.SCALAR) {
                    resultValue = v1.value / v2.value;
                } else {
                    resultValue = v1.value / v2.value;
                }

                break;

            default:
                throw new ParserException("\nUnknown operation: " + operation);
        }
        return new Value(resultValue, resultType);
    }

    private ValueType decideType(ValueType t1, ValueType t2, Type operation) {
        if (operation == Type.DIVIDE) {
            if (t1 == t2) {
                return ValueType.SCALAR;
            }

            if (t1 != ValueType.SCALAR && t2 != ValueType.SCALAR) {
                return ValueType.SCALAR;
            }
        }

        if (t1 == ValueType.SCALAR) {
            return t2;
        }

        return t1;
    }

    // Do test case.
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("(2in*5)pt");
            Parser parser = new Parser(lexer);
            System.out.println(parser.evaluate().toString());
        } catch (Lexer.TokenMismatchException | ParserException ex) {
            System.out.println(ex);
        }
    }
}
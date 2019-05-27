package Interpreter;

abstract class Expression {
    public abstract boolean interpret(String str);
}

class SplitExpression extends Expression {

    private String target;

    public SplitExpression(String str) {
        this.target = str;
    }

    @Override
    public boolean interpret(String str) {
        for (String s : str.split(" ")) {
            if (s.equals(target)) {
                return true;
            }
        }

        return false;
    }
}

class AndExpression extends Expression {

    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) && expression2.interpret(str);
    }
}

class OrExpression extends Expression {

    private Expression expression1;
    private Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) || expression2.interpret(str);
    }
}

public class Interpreter {

    private static Expression buildExpressionTree() {
        SplitExpression expression1 = new SplitExpression("A");
        SplitExpression expression2 = new SplitExpression("B");
        SplitExpression expression3 = new SplitExpression("C");
        SplitExpression expression4 = new SplitExpression("D");

        // B C
        Expression alternation1 = new OrExpression(expression2, expression3);
        // A Or (B C)
        Expression alternation2 = new OrExpression(expression1, alternation1);
        // D And (A Or (B C))
        return new AndExpression(expression4, alternation2);
    }

    public static void main(String[] args) {
        Expression expression = buildExpressionTree();

        String s1 = "D A", s2 = "A B";

        System.out.println(expression.interpret(s1));
        System.out.println(expression.interpret(s2));
    }
}

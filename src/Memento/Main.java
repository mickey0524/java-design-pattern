/**
 * 备忘录模式
 * 可以暂存某个时间点的对象状态
 * 之后可以通过这个快照恢复当时的对象状态
 */
package Memento;

interface Calculator {

    // Create Memento
    PreviousCalculationToCareTaker backupLastCalculation();

    // setMemento
    void restorePreviousCalculation(PreviousCalculationToCareTaker memento);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);
}

class CalculatorImp implements Calculator {

    private int firstNumber;
    private int secondNumber;

    @Override
    public PreviousCalculationToCareTaker backupLastCalculation() {
        // create a memento object used for restoring two numbers
        return new PreviousCalculationImp(firstNumber, secondNumber);
    }

    @Override
    public void restorePreviousCalculation(PreviousCalculationToCareTaker memento) {
        this.firstNumber = ((PreviousCalculationToOriginator) memento).getFirstNumber();
        this.secondNumber = ((PreviousCalculationToOriginator) memento).getSecondNumber();
    }

    @Override
    public int getCalculationResult() {
        // result is adding two numbers
        return firstNumber + secondNumber;
    }

    @Override
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Override
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
}

interface PreviousCalculationToOriginator {
    int getFirstNumber();
    int getSecondNumber();
}

interface PreviousCalculationToCareTaker {}

class PreviousCalculationImp implements PreviousCalculationToCareTaker,
        PreviousCalculationToOriginator {

    private int firstNumber;
    private int secondNumber;

    public PreviousCalculationImp(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int getFirstNumber() {
        return firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return secondNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImp();

        calculator.setFirstNumber(10);
        calculator.setSecondNumber(100);
        System.out.println(calculator.getCalculationResult());

        PreviousCalculationToCareTaker previousCalculationImp = calculator.backupLastCalculation();

        calculator.setFirstNumber(100);
        calculator.setSecondNumber(200);
        System.out.println(calculator.getCalculationResult());

        calculator.restorePreviousCalculation(previousCalculationImp);

        System.out.println(calculator.getCalculationResult());
    }
}

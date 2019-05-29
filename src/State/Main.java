/**
 * 当所有的操作在一个流程图中打转的时候
 * 可以使用 State 这种设计模式
 * 让状态自己决定转移
 */

package State;

interface State {

    void addOne();

    void reduceOne();

}

/**
 * 模 3 余 0
 */
class ZeroState implements State {

    private ModuloThree moduloThree;

    public ZeroState(ModuloThree moduloThree) {
        this.moduloThree = moduloThree;
    }

    @Override
    public void addOne() {
        this.moduloThree.setState(this.moduloThree.getOneState());
    }

    @Override
    public void reduceOne() {
        this.moduloThree.setState(this.moduloThree.getTwoState());
    }
}

/**
 * 模 3 余 1
 */
class OneState implements State {

    private ModuloThree moduloThree;

    public OneState(ModuloThree moduloThree) {
        this.moduloThree = moduloThree;
    }

    @Override
    public void addOne() {
        this.moduloThree.setState(this.moduloThree.getTwoState());
    }

    @Override
    public void reduceOne() {
        this.moduloThree.setState(this.moduloThree.getZeroState());
    }
}

/**
 * 模 3 余 2
 */
class TwoState implements State {

    private ModuloThree moduloThree;

    public TwoState(ModuloThree moduloThree) {
        this.moduloThree = moduloThree;
    }

    @Override
    public void addOne() {
        this.moduloThree.setState(this.moduloThree.getZeroState());
    }

    @Override
    public void reduceOne() {
        this.moduloThree.setState(this.moduloThree.getOneState());
    }
}

class ModuloThree {
    private ZeroState zeroState;
    private OneState oneState;
    private TwoState twoState;
    private State state;

    public ModuloThree() {
        this.zeroState = new ZeroState(this);
        this.oneState = new OneState(this);
        this.twoState = new TwoState(this);
        this.state = zeroState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ZeroState getZeroState() {
        return zeroState;
    }

    public OneState getOneState() {
        return oneState;
    }

    public TwoState getTwoState() {
        return twoState;
    }

    public void addOne() {
        this.state.addOne();
    }

    public void reduceOne() {
        this.state.reduceOne();
    }
}

public class Main {
    public static void main(String[] args) {
        ModuloThree moduloThree = new ModuloThree();

        moduloThree.addOne();
        moduloThree.reduceOne();
    }
}

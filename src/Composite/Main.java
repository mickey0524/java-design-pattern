package Composite;

import java.util.ArrayList;

abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public void print() {
        print(0);
    }

    abstract void print(int level);

    abstract void addComponent(Component component);

    abstract void removeComponent(Component component);
}

class TreeNode extends Component {

    private ArrayList<Component> components;

    public TreeNode(String name) {
        super(name);
        this.components = new ArrayList<>();
    }

    @Override
    void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }

        System.out.println(this.name);

        for (Component component : components) {
            component.print(level + 1);
        }
    }

    @Override
    void addComponent(Component component) {
        components.add(component);
    }

    @Override
    void removeComponent(Component component) {
        components.remove(component);
    }
}

class TreeLeaf extends Component {

    public TreeLeaf(String name) {
        super(name);
    }

    @Override
    void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }

        System.out.println(this.name);
    }

    @Override
    void addComponent(Component component) {
        throw new UnsupportedOperationException("");
    }

    @Override
    void removeComponent(Component component) {
        throw new UnsupportedOperationException("");
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode("root");
        Component node1 = new TreeLeaf("1");
        Component node2 = new TreeNode("2");
        Component node3 = new TreeLeaf("3");
        root.addComponent(node1);
        root.addComponent(node2);
        root.addComponent(node3);
        Component node21 = new TreeLeaf("21");
        Component node22 = new TreeNode("22");
        node2.addComponent(node21);
        node2.addComponent(node22);
        Component node221 = new TreeLeaf("221");
        node22.addComponent(node221);
        root.print();
    }
}

/**
 * 命令模式，这里虚拟出两个命令
 * 开灯和关灯
 *
 * 命令模式其实就是虚拟出一个个命令
 * 然后用一个 Invoke 来管理执行这些命令
 */

package Command;

import java.util.LinkedList;

interface Command {
    void execute();
}

class Light {

    void open() {
        System.out.println("开灯");
    }

    void close() {
        System.out.println("关灯");
    }
}

class CommandOpenLight implements Command {

    Light light;

    public CommandOpenLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.open();
    }
}

class CommandCloseLight implements Command {

    Light light;

    public CommandCloseLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.close();
    }
}

class Invoker {

    private LinkedList<Command> commands;

    Invoker() {
        this.commands = new LinkedList<Command>();
    }

    void addCommand(Command command) {
        commands.add(command);
    }

    void executeCommand() {
        if (!this.commands.isEmpty()) {
            this.commands.pollFirst().execute();
        }
    }
}

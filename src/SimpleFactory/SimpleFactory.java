/**
 * 工厂相关的设计模式的前题是有一个 Product 的顶层类，然后有各种各样的 Product 的子类
 * 我们需要根据不同的环境来创建不同的 Product 子类
 * 简单工厂是直接根据输入的 type 来返回对应的类
 */

package SimpleFactory;

interface Product {}

class ConcreteProduct1 implements Product{}

class ConcreteProduct2 implements Product{}

class ConcreteProduct3 implements Product{}

public class SimpleFactory {
    public Product createProduct(int type) {
        if (type == 1) {
            return new ConcreteProduct1();
        } else if (type == 2) {
            return new ConcreteProduct2();
        }
        return new ConcreteProduct3();
    }
}



package create.FactoryMethod;

/**
 * 产品抽象类 定义产品
 */
public abstract class AbstractProduct {

    //产品名字
    private String name;

    public AbstractProduct() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

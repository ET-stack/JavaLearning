package create.FactoryMethod;

public class Customer implements IPackageFactory {


    //客户使用皮包
    @Override
    public AbstractProduct createPackage() {
        return new PackageProduct();
    }
}

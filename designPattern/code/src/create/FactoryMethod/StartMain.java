package create.FactoryMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StartMain {
    public static void main(String[] args) {
        //创建客户
        IPackageFactory iPackageFactory = new Customer();
        //获得产品
        AbstractProduct product = iPackageFactory.createPackage();
        //使用产品
        System.out.println(product.getName() + "皮包");

        int[] nums = {3, 5, 1};
        Arrays.sort(nums);
        System.out.println(Arrays.copyOfRange(nums, 0, 2)[0]);
//        Stream.of(nums).filter(e -> e.equals(10)).forEach(System.out::println);

        String sumStr = "";


        String strArray[] = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);


        Arrays.sort(strArray, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder s = new StringBuilder();
        Stream.of(strArray).forEach(s::append);

//        System.out.println(s);


    }

}

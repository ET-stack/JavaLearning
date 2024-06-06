package com.reptile;

/**
 * @className: EchartsMap
 * @description: TODO 类描述
 * @author: 
 * @date: 2022/11/29
 **/
public class EchartsMap implements Comparable<EchartsMap> {
    String name;
    String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int compareTo(EchartsMap o) {
        return this.value.compareTo(o.getValue());
    }
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        final EchartsMap std = (EchartsMap) obj;
        if (this == std) {
            return true;
        } else {
            return (this.name.equals(std.name));
        }
    }
    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
        return hashno;
    }
}

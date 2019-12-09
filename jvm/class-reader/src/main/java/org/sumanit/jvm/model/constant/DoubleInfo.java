package org.sumanit.jvm.model.constant;

/**
 * Created by 苏曼 on 2019/12/2.
 * 双精度浮点类型字面量
 */
public class DoubleInfo extends Constant {
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public String getTypeName() {
        return "Double";
    }
}

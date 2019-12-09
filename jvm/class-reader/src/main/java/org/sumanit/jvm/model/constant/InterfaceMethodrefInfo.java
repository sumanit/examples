package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 接口中方法的符号引用
 */
public class InterfaceMethodrefInfo extends Constant {
    /**
     * 指向声明方法的接口描述符 也就是定义方法的接口是哪个
     */
    private short classInfoIndex;
    /**
     * 指向方法的名称和类型
     */
    private short nameAndTypeIndex;

    public short getClassInfoIndex() {
        return classInfoIndex;
    }

    public void setClassInfoIndex(short classInfoIndex) {
        this.classInfoIndex = classInfoIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    public String toString() {
        return "{" +
                "classInfoIndex=" + index2Str(classInfoIndex) +
                ", nameAndTypeIndex=" + index2Str(nameAndTypeIndex) +
                '}';
    }

    public String getTypeName() {
        return "InterfaceMethodref";
    }
}

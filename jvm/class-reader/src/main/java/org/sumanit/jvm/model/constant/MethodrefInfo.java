package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 标识方法类型
 */
public class MethodrefInfo extends Constant {
    /**
     * 指向声明方法的类或者接口描述符 也就是定义字段的类或接口是哪个
     */
    private short classInfoIndex = -1;
    /**
     * 指向方法的名称和类型
     */
    private short nameAndTypeIndex =-1;

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
                "classInfo=" + index2Str(classInfoIndex) +
                ", nameAndType=" + index2Str(nameAndTypeIndex) +
                '}';
    }

    public String getTypeName() {
        return "Methodref";
    }
}

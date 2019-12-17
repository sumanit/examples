package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 字段的符号引用，主要有两个属性
 */
public class FieldrefInfo extends Constant {
    /**
     * 指向声明字段的类或者接口描述符 也就是说明了字段定义在哪个类或接口里
      */
    private short classInfoIndex;
    /**
     * 指向字段描述符，里面记录了字段的类型和名字
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
        return "{"+
                "classInfo=" + index2Str(classInfoIndex) +
                ", nameAndType=" + index2Str(nameAndTypeIndex)+'}';
    }

    public String getTypeName() {
        return "Fieldref";
    }
}

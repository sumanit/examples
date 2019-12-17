package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 表示一个动态方法调用点
 */
public class InvokeDynamicInfo extends Constant {
    private short bootstrapMethodAttrIndex;
    private short nameAndTypeIndex;

    public short getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public void setBootstrapMethodAttrIndex(short bootstrapMethodAttrIndex) {
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
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
                "bootstrapMethodAttr=" + index2Str(bootstrapMethodAttrIndex) +
                ", nameAndTypeIndex=" + index2Str(nameAndTypeIndex) +
                '}';
    }

    public String getTypeName() {
        return "InvokeDynamic";
    }
}

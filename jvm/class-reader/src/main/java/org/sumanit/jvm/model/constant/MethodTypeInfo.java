package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 标志方法类型
 */
public class MethodTypeInfo extends Constant {
    private short descriptorIndex;

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    @Override
    public String toString() {
        return "{" +
                "descriptor=" + index2Str(descriptorIndex) +
                '}';
    }

    public String getTypeName() {
        return "MethodType";
    }
}

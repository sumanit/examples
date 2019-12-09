package org.sumanit.jvm.model.attribute;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class ConstantValue extends Attribute {
    private short constantValueIndex;

    public short getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(short constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }
}

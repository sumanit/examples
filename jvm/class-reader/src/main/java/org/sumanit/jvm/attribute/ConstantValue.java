package org.sumanit.jvm.attribute;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class ConstantValue extends Attribute{
    private short constantValueIndex;
    @Override
    public void readBody(ByteBuffer buf) {
        constantValueIndex = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public String toString() {
        return "ConstantValue{" +
                "constantValueIndex=" + constantValueIndex +
                '}';
    }
}

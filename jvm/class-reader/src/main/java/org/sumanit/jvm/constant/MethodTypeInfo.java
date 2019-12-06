package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class MethodTypeInfo extends Constant{
    private short descriptorIndex;
    @Override
    public void read(ByteBuffer buf) {
        descriptorIndex = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public String toString() {
        return "MethodTypeInfo{" +
                "descriptorIndex=" + descriptorIndex +
                '}';
    }
}

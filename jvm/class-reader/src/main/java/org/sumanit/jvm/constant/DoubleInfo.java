package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class DoubleInfo extends Constant{
    private double value;
    @Override
    public void read(ByteBuffer buf) {
        value = ByteBufferReaderUtil.readDouble(buf);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

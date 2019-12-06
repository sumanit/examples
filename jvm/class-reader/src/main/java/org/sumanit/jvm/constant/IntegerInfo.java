package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class IntegerInfo extends Constant{
    private int value;

    @Override
    public void read(ByteBuffer buf) {
        value = ByteBufferReaderUtil.readInt(buf);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

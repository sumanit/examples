package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class FloatInfo extends Constant{
    private float value;

    @Override
    public void read(ByteBuffer buf) {
        value = ByteBufferReaderUtil.readFloat(buf);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

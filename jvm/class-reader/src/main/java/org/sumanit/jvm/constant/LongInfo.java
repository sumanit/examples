package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class LongInfo extends Constant{
    private long value;
    @Override
    public void read(ByteBuffer buf) {
       value =  ByteBufferReaderUtil.readLong(buf);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

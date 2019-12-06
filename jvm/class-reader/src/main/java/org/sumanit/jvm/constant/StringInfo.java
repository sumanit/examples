package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class StringInfo extends Constant{
    private short index;
    @Override
    public void read(ByteBuffer buf) {
        index = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }
}

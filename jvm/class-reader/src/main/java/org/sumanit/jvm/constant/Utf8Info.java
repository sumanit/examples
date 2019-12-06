package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class Utf8Info extends Constant {
    String value = null;
    @Override
    public void read(ByteBuffer buf) {
        short i = ByteBufferReaderUtil.readShort(buf);
        value = ByteBufferReaderUtil.readStr(buf, i);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

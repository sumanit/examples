package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */

public class MethodHandleInfo extends Constant {
    private byte referenceKind;
    private short referenceIndex;

    @Override
    public void read(ByteBuffer buf) {
        referenceKind = buf.get();
        referenceIndex = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public String toString() {
        return "MethodHandleInfo{" +
                "referenceKind=" + referenceKind +
                ", referenceIndex=" + referenceIndex +
                '}';
    }
}


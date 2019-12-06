package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class NameAndTypeInfo extends Constant{
    private short nameIndex;
    private short descriptionIndex;
    @Override
    public void read(ByteBuffer buf) {
        nameIndex = ByteBufferReaderUtil.readShort(buf);
        descriptionIndex = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public String toString() {
        return "NameAndTypeInfo{" +
                "nameIndex=" + nameIndex +
                ", descriptionIndex=" + descriptionIndex +
                '}';
    }
}

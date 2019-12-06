package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class MethodrefInfo extends Constant{
    short classInfoIndex = -1;
    short nameAndTypeIndex =-1;
    @Override
    public void read(ByteBuffer buf) {
         classInfoIndex = ByteBufferReaderUtil.readShort(buf);
         nameAndTypeIndex = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public String toString() {
        return "MethodrefInfo{" +
                "classInfoIndex=" + classInfoIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                '}';
    }
}

package org.sumanit.jvm.constant;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class InterfaceMethodrefInfo extends Constant {
    private short classInfoIndex;
    private short nameAndTypeIndex;
    @Override
    public void read(ByteBuffer buf) {
        classInfoIndex = ByteBufferReaderUtil.readShort(buf);
        nameAndTypeIndex = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public String toString() {
        return "InterfaceMethodrefInfo{" +
                "classInfoIndex=" + classInfoIndex +
                ", nameAndTypeIndex=" + nameAndTypeIndex +
                '}';
    }
}

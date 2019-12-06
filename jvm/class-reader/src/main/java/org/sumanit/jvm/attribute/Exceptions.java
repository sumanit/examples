package org.sumanit.jvm.attribute;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class Exceptions extends Attribute{

    private short numberOfExceptions;
    private short[] exceptionIndexTable;
    @Override
    public void readBody(ByteBuffer buf) {
        numberOfExceptions = ByteBufferReaderUtil.readShort(buf);
        exceptionIndexTable = new short[numberOfExceptions];
        for(int i=0;i<numberOfExceptions;i++){
            exceptionIndexTable[i] = ByteBufferReaderUtil.readShort(buf);
        }
    }
}

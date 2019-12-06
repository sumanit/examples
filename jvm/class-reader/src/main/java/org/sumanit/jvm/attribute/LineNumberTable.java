package org.sumanit.jvm.attribute;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class LineNumberTable extends Attribute {

    private short lineNumberTableLength;
    private short[] exceptionIndexTable;
    @Override
    public void readBody(ByteBuffer buf) {
        lineNumberTableLength = ByteBufferReaderUtil.readShort(buf);
        exceptionIndexTable = new short[lineNumberTableLength];
        for (int i=0;i<lineNumberTableLength;i++){
            exceptionIndexTable[i] = ByteBufferReaderUtil.readShort(buf);
        }
    }
}

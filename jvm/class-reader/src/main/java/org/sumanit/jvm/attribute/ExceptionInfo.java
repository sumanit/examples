package org.sumanit.jvm.attribute;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class ExceptionInfo {
    private short startPc;
    private short endPc;
    private short handlerPc;
    private short catchType;
    public void read(ByteBuffer buf) {
        startPc = ByteBufferReaderUtil.readShort(buf);
        endPc = ByteBufferReaderUtil.readShort(buf);
        handlerPc = ByteBufferReaderUtil.readShort(buf);
        catchType = ByteBufferReaderUtil.readShort(buf);
    }

}

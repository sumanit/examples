package org.sumanit.jvm.model.attribute;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class Exceptions extends Attribute {

    private short numberOfExceptions;
    private short[] exceptionIndexTable;

    public short getNumberOfExceptions() {
        return numberOfExceptions;
    }

    public void setNumberOfExceptions(short numberOfExceptions) {
        this.numberOfExceptions = numberOfExceptions;
    }

    public short[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }

    public void setExceptionIndexTable(short[] exceptionIndexTable) {
        this.exceptionIndexTable = exceptionIndexTable;
    }
}

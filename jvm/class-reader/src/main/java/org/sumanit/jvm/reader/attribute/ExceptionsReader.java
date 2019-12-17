package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.Exceptions;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class ExceptionsReader extends AttributeReader<Exceptions> {

    @Override
    public void readBody(ByteBuffer buf, Exceptions exceptions) {
        short numberOfExceptions = ByteBufferReaderUtil.readShort(buf);
        short[] exceptionIndexTable = new short[numberOfExceptions];
        for(int i=0;i<numberOfExceptions;i++){
            exceptionIndexTable[i] = ByteBufferReaderUtil.readShort(buf);
        }
        exceptions.setNumberOfExceptions(numberOfExceptions);
        exceptions.setExceptionIndexTable(exceptionIndexTable);
    }

    @Override
    public Exceptions createAttribute() {
        return new Exceptions();
    }
}

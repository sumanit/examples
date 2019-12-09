package org.sumanit.jvm.model.attribute;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class StackMapTable extends Attribute {
    private short numberOfEntries;

    public short getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(short numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    class StackMapFrame{

    }

}

package org.sumanit.jvm.attribute;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class StackMapTable extends Attribute {
    private short numberOfEntries;
    @Override
    public void readBody(ByteBuffer buf) {
        numberOfEntries = ByteBufferReaderUtil.readShort(buf);
        for (int i = 0; i < numberOfEntries; i++) {

        }
    }


    class StackMapFrame{

    }

}

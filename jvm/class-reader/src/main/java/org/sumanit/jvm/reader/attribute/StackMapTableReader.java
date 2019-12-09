package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.StackMapTable;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class StackMapTableReader extends AttributeReader<StackMapTable> {
    private short numberOfEntries;
    @Override
    public void readBody(ByteBuffer buf,StackMapTable stackMapTable) {
        numberOfEntries = ByteBufferReaderUtil.readShort(buf);
        for (int i = 0; i < numberOfEntries; i++) {

        }
    }

    @Override
    public StackMapTable createAttribute() {
        return new StackMapTable();
    }

    class StackMapFrame{

    }

}

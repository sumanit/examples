package org.sumanit.jvm.reader;

import org.sumanit.jvm.reader.constant.ConstantReader;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class AttributesReader {
    Map<String, ConstantReader> constantMap = new HashMap<String, ConstantReader>();
    private short attributeNameIndex;
    private int attributeLength;
    public void read(ByteBuffer buf){
        attributeNameIndex = ByteBufferReaderUtil.readShort(buf);
        attributeLength = ByteBufferReaderUtil.readInt(buf);

    }
}

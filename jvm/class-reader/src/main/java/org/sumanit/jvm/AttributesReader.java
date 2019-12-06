package org.sumanit.jvm;

import org.sumanit.jvm.constant.Constant;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class AttributesReader {
    Map<String, Constant> constantMap = new HashMap<String, Constant>();
    private short attributeNameIndex;
    private int attributeLength;
    public void read(ByteBuffer buf){
        attributeNameIndex = ByteBufferReaderUtil.readShort(buf);
        attributeLength = ByteBufferReaderUtil.readInt(buf);


    }
}

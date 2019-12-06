package org.sumanit.jvm.attribute;


import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class InnerClasses extends Attribute {
    private short numberOfClasses;
    private InnerClassInfo[] innerClassInfos;
    @Override
    public void readBody(ByteBuffer buf) {
        numberOfClasses = ByteBufferReaderUtil.readShort(buf);
        innerClassInfos = new InnerClassInfo[numberOfClasses];

    }
    class InnerClassInfo{
        private short innerClassInfoIndex;
        private short outerClassInfoIndex;
        private short innerNameIndex;
        private String innerClassAccessFlags;

        public void read(ByteBuffer buf){
            innerClassInfoIndex = ByteBufferReaderUtil.readShort(buf);
            outerClassInfoIndex = ByteBufferReaderUtil.readShort(buf);
            innerNameIndex = ByteBufferReaderUtil.readShort(buf);
            innerClassAccessFlags = ByteBufferReaderUtil.readHexStr(buf,2);

        }

        @Override
        public String toString() {
            return "InnerClassInfo{" +
                    "innerClassInfoIndex=" + innerClassInfoIndex +
                    ", outerClassInfoIndex=" + outerClassInfoIndex +
                    ", innerNameIndex=" + innerNameIndex +
                    ", innerClassAccessFlags='" + innerClassAccessFlags + '\'' +
                    '}';
        }
    }
}

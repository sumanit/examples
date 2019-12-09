package org.sumanit.jvm.reader.attribute;


import org.sumanit.jvm.model.attribute.InnerClasses;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class InnerClassesReader extends AttributeReader<InnerClasses> {
    private short numberOfClasses;
    private InnerClassInfo[] innerClassInfos;
    @Override
    public void readBody(ByteBuffer buf,InnerClasses innerClasses) {
        numberOfClasses = ByteBufferReaderUtil.readShort(buf);
        innerClassInfos = new InnerClassInfo[numberOfClasses];

    }

    @Override
    public InnerClasses createAttribute() {
        return new InnerClasses();
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

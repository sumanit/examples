package org.sumanit.jvm.reader.attribute;


import org.sumanit.jvm.model.attribute.InnerClasses;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class InnerClassesReader extends AttributeReader<InnerClasses> {

    @Override
    public void readBody(ByteBuffer buf,InnerClasses innerClasses) {
        short numberOfClasses = ByteBufferReaderUtil.readShort(buf);
        InnerClasses.InnerClassInfo[] innerClassInfos = new InnerClasses.InnerClassInfo[numberOfClasses];
        InnerClassInfoReader innerClassInfoReader = new InnerClassInfoReader();
        for (int i = 0; i < numberOfClasses; i++) {
            InnerClasses.InnerClassInfo innerClassInfo = innerClassInfoReader.read(buf);
            innerClassInfos[i] = innerClassInfo;
        }
    }

    @Override
    public InnerClasses createAttribute() {
        return new InnerClasses();
    }

    class InnerClassInfoReader{
        public InnerClasses.InnerClassInfo read(ByteBuffer buf){
            short innerClassInfoIndex = ByteBufferReaderUtil.readShort(buf);
            short outerClassInfoIndex = ByteBufferReaderUtil.readShort(buf);
            short innerNameIndex = ByteBufferReaderUtil.readShort(buf);
            String innerClassAccessFlags = ByteBufferReaderUtil.readHexStr(buf,2);
            InnerClasses.InnerClassInfo innerClassInfo = new InnerClasses.InnerClassInfo();
            innerClassInfo.setInnerClassInfoIndex(innerClassInfoIndex);
            innerClassInfo.setOuterClassInfoIndex(outerClassInfoIndex);
            innerClassInfo.setInnerNameIndex(innerNameIndex);
            innerClassInfo.setInnerClassAccessFlags(innerClassAccessFlags);
            return innerClassInfo;
        }

    }
}

package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.ClassInfo;
import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 类或接口的符号引用
 */
public class ClassInfoReader extends ConstantReader<ClassInfo> {
    @Override
    public ClassInfo read(ByteBuffer buf) {
        ClassInfo classInfo = new ClassInfo();
        short index = ByteBufferReaderUtil.readShort(buf);
        classInfo.setIndex(index);
        return classInfo;
    }
}

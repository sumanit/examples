package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.MethodHandleInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 表示方法句柄
 */

public class MethodHandleInfoReader extends ConstantReader {

    @Override
    public MethodHandleInfo read(ByteBuffer buf) {
        MethodHandleInfo methodHandleInfo = new MethodHandleInfo();
        byte referenceKind = buf.get();
        short referenceIndex = ByteBufferReaderUtil.readShort(buf);
        methodHandleInfo.setReferenceKind(referenceKind);
        methodHandleInfo.setReferenceIndex(referenceIndex);
        return methodHandleInfo;
    }

}


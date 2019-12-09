package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.MethodTypeInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 标志方法类型
 */
public class MethodTypeInfoReader extends ConstantReader<MethodTypeInfo> {
    @Override
    public MethodTypeInfo read(ByteBuffer buf) {
        short descriptorIndex = ByteBufferReaderUtil.readShort(buf);
        MethodTypeInfo methodTypeInfo = new MethodTypeInfo();
        methodTypeInfo.setDescriptorIndex(descriptorIndex);
        return methodTypeInfo;
    }

}

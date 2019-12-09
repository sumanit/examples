package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.InvokeDynamicInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 表示一个动态方法调用点
 */
public class InvokeDynamicInfoReader extends ConstantReader {

    @Override
    public Constant read(ByteBuffer buf) {
        short bootstrapMethodAttrIndex = ByteBufferReaderUtil.readShort(buf);
        short nameAndTypeIndex = ByteBufferReaderUtil.readShort(buf);
        InvokeDynamicInfo invokeDynamicInfo = new InvokeDynamicInfo();
        invokeDynamicInfo.setBootstrapMethodAttrIndex(bootstrapMethodAttrIndex);
        invokeDynamicInfo.setNameAndTypeIndex(nameAndTypeIndex);
        return invokeDynamicInfo;
    }
}

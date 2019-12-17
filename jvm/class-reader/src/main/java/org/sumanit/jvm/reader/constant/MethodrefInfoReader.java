package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.MethodrefInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 标识方法类型
 */
public class MethodrefInfoReader extends ConstantReader<MethodrefInfo> {
    @Override
    public MethodrefInfo read(ByteBuffer buf) {
        short classInfoIndex = ByteBufferReaderUtil.readShort(buf);
        short nameAndTypeIndex = ByteBufferReaderUtil.readShort(buf);
        MethodrefInfo methodrefInfo = new MethodrefInfo();
        methodrefInfo.setClassInfoIndex(classInfoIndex);
        methodrefInfo.setNameAndTypeIndex(nameAndTypeIndex);
        return methodrefInfo;
    }

}

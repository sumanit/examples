package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.StringInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 字符串类型字面量
 */
public class StringInfoReader extends ConstantReader<StringInfo> {

    @Override
    public StringInfo read(ByteBuffer buf) {
        short index = ByteBufferReaderUtil.readShort(buf);
        StringInfo stringInfo = new StringInfo();
        stringInfo.setIndex(index);
        return stringInfo;
    }

}

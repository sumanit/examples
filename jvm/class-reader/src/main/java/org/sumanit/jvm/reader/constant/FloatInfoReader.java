package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.FloatInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 浮点型字面量
 */
public class FloatInfoReader extends ConstantReader<FloatInfo> {

    @Override
    public FloatInfo read(ByteBuffer buf) {
        FloatInfo floatInfo = new FloatInfo();
        float value = ByteBufferReaderUtil.readFloat(buf);
        floatInfo.setValue(value);
        return floatInfo;
    }
}

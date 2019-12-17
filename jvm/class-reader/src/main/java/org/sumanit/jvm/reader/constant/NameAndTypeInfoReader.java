package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.NameAndTypeInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 字段或方法的部分符号引用
 *
 * 该数据结构定义了 字段的 字段名 字段类型
 *
 * 该数据结构定义了 方法的 方法名 参数类型  返回值类型
 */
public class NameAndTypeInfoReader extends ConstantReader<NameAndTypeInfo> {
    public NameAndTypeInfo read(ByteBuffer buf) {
        short nameIndex = ByteBufferReaderUtil.readShort(buf);
        short descriptionIndex = ByteBufferReaderUtil.readShort(buf);
        NameAndTypeInfo nameAndTypeInfo = new NameAndTypeInfo();
        nameAndTypeInfo.setNameIndex(nameIndex);
        nameAndTypeInfo.setDescriptionIndex(descriptionIndex);
        return nameAndTypeInfo;
    }

}

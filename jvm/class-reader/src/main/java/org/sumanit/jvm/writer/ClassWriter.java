package org.sumanit.jvm.writer;

import org.sumanit.jvm.model.Clazz;
import org.sumanit.jvm.model.FieldInfo;
import org.sumanit.jvm.model.MethodInfo;
import org.sumanit.jvm.model.constant.Constant;

public class ClassWriter {
    private Writer writer;

    public ClassWriter(Writer writer) {
        this.writer = writer;
    }

    public void write(Clazz clazz){
        writer.write("magic: 0x"+clazz.getMagic().toUpperCase());
        writer.write("major version: "+clazz.getMajorVersion());
        writer.write("minor version: "+clazz.getMinorVersion());
        writer.write("access flags: "+clazz.getAccessFlags());
        Constant[] constantPool = clazz.getConstantPool();
        for (int i = 0; i < constantPool.length; i++) {
            Constant constant = constantPool[i];
            StringBuilder stringBuilder = new StringBuilder("constantPool #");
            int indexMaxLength = String.valueOf(constantPool.length).length();

            stringBuilder.append(String.format("%-"+indexMaxLength+"d", i+1));
            stringBuilder.append(" : ");
            stringBuilder.append(String.format("%-20s",constant.getTypeName()));
            stringBuilder.append(constant);
            writer.write(stringBuilder.toString());
        }

        FieldInfo[] fieldInfos = clazz.getFieldInfos();
        for (int i = 0; i < fieldInfos.length; i++) {
            FieldInfo fieldInfo = fieldInfos[i];
            writer.write(fieldInfo);
        }
        MethodInfo[] methodInfos = clazz.getMethodInfos();
        for (MethodInfo methodInfo : methodInfos) {
            writer.write(methodInfo);
        }
    }
}

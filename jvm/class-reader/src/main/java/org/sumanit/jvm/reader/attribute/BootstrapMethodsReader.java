package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.BootstrapMethods;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

public class BootstrapMethodsReader  extends  AttributeReader<BootstrapMethods>{
    @Override
    public void readBody(ByteBuffer buf, BootstrapMethods attribute) {
        short bootstrapMethodsNum = ByteBufferReaderUtil.readShort(buf);
        attribute.setBootstrapMethodsNum(bootstrapMethodsNum);
        BootstrapMethods.BootstrapMethod[] bootstrapMethods = new BootstrapMethods.BootstrapMethod[bootstrapMethodsNum];
        BootstrapMethodReader bootstrapMethodReader = new BootstrapMethodReader();
        for (int i = 0; i < bootstrapMethodsNum; i++) {
            bootstrapMethods[i] = bootstrapMethodReader.read(buf);
        }
        attribute.setBootstrapMethods(bootstrapMethods);
    }

    @Override
    public BootstrapMethods createAttribute() {
        return new BootstrapMethods();
    }
    
    class BootstrapMethodReader{
        public BootstrapMethods.BootstrapMethod read(ByteBuffer buf) {
            BootstrapMethods.BootstrapMethod bootstrapMethod = new BootstrapMethods.BootstrapMethod();
            short bootstrapMethodRef = ByteBufferReaderUtil.readShort(buf);
            bootstrapMethod.setBootstrapMethodRef(bootstrapMethodRef);
            short bootstrapArgumentsNum = ByteBufferReaderUtil.readShort(buf);
            bootstrapMethod.setBootstrapArgumentsNum(bootstrapArgumentsNum);
            short[] bootstrapArguments = new short[bootstrapArgumentsNum];
            for (int i = 0; i < bootstrapArgumentsNum; i++) {
                bootstrapArguments[i] = ByteBufferReaderUtil.readShort(buf);
            }
            bootstrapMethod.setBootstrapArguments(bootstrapArguments);
            return bootstrapMethod;

        }
    }
}

package org.sumanit.jvm.model.attribute;

public class BootstrapMethods extends Attribute {
    private short bootstrapMethodsNum;
    private BootstrapMethod[] bootstrapMethods;

    public BootstrapMethod[] getBootstrapMethods() {
        return bootstrapMethods;
    }

    public void setBootstrapMethods(BootstrapMethod[] bootstrapMethods) {
        this.bootstrapMethods = bootstrapMethods;
    }

    public short getBootstrapMethodsNum() {
        return bootstrapMethodsNum;
    }

    public void setBootstrapMethodsNum(short bootstrapMethodsNum) {
        this.bootstrapMethodsNum = bootstrapMethodsNum;
    }

    public static class BootstrapMethod{
        private short bootstrapMethodRef;
        private short bootstrapArgumentsNum;
        private short[] bootstrapArguments;

        public short getBootstrapMethodRef() {
            return bootstrapMethodRef;
        }

        public void setBootstrapMethodRef(short bootstrapMethodRef) {
            this.bootstrapMethodRef = bootstrapMethodRef;
        }

        public short getBootstrapArgumentsNum() {
            return bootstrapArgumentsNum;
        }

        public void setBootstrapArgumentsNum(short bootstrapArgumentsNum) {
            this.bootstrapArgumentsNum = bootstrapArgumentsNum;
        }

        public short[] getBootstrapArguments() {
            return bootstrapArguments;
        }

        public void setBootstrapArguments(short[] bootstrapArguments) {
            this.bootstrapArguments = bootstrapArguments;
        }
    }
}

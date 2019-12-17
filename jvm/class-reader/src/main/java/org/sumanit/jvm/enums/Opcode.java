package org.sumanit.jvm.enums;

/**
 * Created by 苏曼 on 2019/12/9.
 */
public enum Opcode {
    /**
     * 什么都不做
     */
    nop(0x00),
    /**
     * 将null推至栈顶
     */
    aconst_null(0x01),
    /**
     * 将int类型的 -1 推至栈顶
     */
    iconst_m1(0x02),
    /**
     * 将int类型的 0 推至栈顶
     */
    iconst_0(0x03),
    /**
     * 将int类型的 1 推至栈顶
     */
    iconst_1(0x04),
    /**
     * 将int类型的 2 推至栈顶
     */
    iconst_2(0x05),
    /**
     * 将int类型的 3 推至栈顶
     */
    iconst_3(0x06),
    /**
     * 将int类型的 4 推至栈顶
     */
    iconst_4(0x07),
    /**
     * 将int类型的 5 推至栈顶
     */
    iconst_5(0x08),
    /**
     * 将long类型的 0 推至栈顶
     */
    lconst_0(0x09),
    /**
     * 将long类型的 1 推至栈顶
     */
    lconst_1(0x0a),
    /**
     * 将float类型的 0 推至栈顶
     */
    fconst_0(0x0b),
    /**
     * 将float类型的 1 推至栈顶
     */
    fconst_1(0x0c),
    /**
     * 将float类型的 2 推至栈顶
     */
    fconst_2(0x0d),
    /**
     * 将double类型的 0 推至栈顶
     */
    dconst_0(0x0e),
    /**
     * 将double类型的 1 推至栈顶
     */
    dconst_1(0x0f),
    /**
     * 将单字节的常量 (-128-127) 推至栈顶
     */
    bipush(0x10),
    /**
     * 将short类型的常量 (-128-127) 推至栈顶
     */
    sipush(0x11),
    /**
     * 将int float 或String 型常量值从常量池中推至栈顶
     */
    ldc(0x12),
    /**
     * 将int float 或String 型常量值从常量池中推至栈顶(宽索引)
     */
    ldc_w(0x13),
    /**
     * 将long 或 Double 型常量值从常量池中推至栈顶(宽索引)
     */
    ldc2_w(0x14),
    /**
     * 将指定的 int 型本地变量推至栈顶
     */
    iload(0x15),
    /**
     * 将指定的 long 型本地变量推至栈顶
     */
    lload(0x16),
    /**
     * 将指定的 flaot 型本地变量推至栈顶
     */
    fload(0x17),
    /**
     * 将指定的 double 型本地变量推至栈顶
     */
    dload(0x18),
    /**
     * 将指定的 引用类型 本地变量推至栈顶
     */
    aload(0x19),
    /**
     * 将第一个 int 型本地变量推至栈顶
     */
    iload_0(0x1a),
    /**
     * 将第二个 int 型本地变量推至栈顶
     */
    iload_1(0x1b),
    /**
     * 将第三个 int 型本地变量推至栈顶
     */
    iload_2(0x1c),
    /**
     * 将第四个 int 型本地变量推至栈顶
     */
    iload_3(0x1d),
    /**
     * 将第一个 long 型本地变量推至栈顶
     */
    lload_0(0x1e),
    /**
     * 将第二个 long 型本地变量推至栈顶
     */
    lload_1(0x1f),
    /**
     * 将第三个 long 型本地变量推至栈顶
     */
    lload_2(0x20),
    /**
     * 将第四个 long 型本地变量推至栈顶
     */
    lload_3(0x21),
    /**
     * 将第一个 float 型本地变量推至栈顶
     */
    fload_0(0x22),
    /**
     * 将第二个 float 型本地变量推至栈顶
     */
    fload_1(0x23),
    /**
     * 将第三个 float 型本地变量推至栈顶
     */
    fload_2(0x24),
    /**
     * 将第四个 float 型本地变量推至栈顶
     */
    load_3(0x25),
    /**
     * 将第一个 double 型本地变量推至栈顶
     */
    dload_0(0x26),
    /**
     * 将第二个 double 型本地变量推至栈顶
     */
    dload_1(0x27),
    /**
     * 将第三个 double 型本地变量推至栈顶
     */
    dload_2(0x28),
    /**
     * 将第四个 double 型本地变量推至栈顶
     */
    dload_3(0x29),
    /**
     * 将第一个 引用 型本地变量推至栈顶
     */
    aload_0(0x2a),
    /**
     * 将第二个 引用 型本地变量推至栈顶
     */
    aload_1(0x2b),
    /**
     * 将第三个 引用 型本地变量推至栈顶
     */
    aload_2(0x2c),
    /**
     * 将第四个 引用 型本地变量推至栈顶
     */
    aload_3(0x2d),
    /**
     *  将 int 型数组指定索引的值推至栈顶
     */
    iaload(0x2e),
    /**
     *  将 long 型数组指定索引的值推至栈顶
     */
    laload(0x2f),
    /**
     *  将 float 型数组指定索引的值推至栈顶
     */
    faload(0x30),
    /**
     *  将 double 型数组指定索引的值推至栈顶
     */
    daload(0x31),
    /**
     *  将 float 型数组指定索引的值推至栈顶
     */
    aaload(0x32),
    /**
     *  将 boolean或byte 型数组指定索引的值推至栈顶
     */
    baload(0x33),
    /**
     *  将 char 型数组指定索引的值推至栈顶
     */
    caload(0x34),
    /**
     *  将 short 型数组指定索引的值推至栈顶
     */
    saload(0x35),
    /**
     * 将栈顶 int 型数值存入指定本地变量
     */
    istore(0x36),
    /**
     *
     */
    lstore(0x37)

    ;

    Opcode(int code) {
    }
}

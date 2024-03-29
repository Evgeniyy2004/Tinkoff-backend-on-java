/*package edu.hw11;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task3 {

    @Test
    void fib() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException,
        IOException, ClassNotFoundException {
        var appender =  new ByteCodeAppender() {
            @Override
            public Size apply(
                MethodVisitor methodVisitor,
                Implementation.Context context,
                MethodDescription methodDescription
            ) {
                methodVisitor.visitCode();
                Label l = new Label();
                Label l1 = new Label();
                Label l2 = new Label();
                Label l3 = new Label();
                //methodVisitor.visitLabel(l);
                methodVisitor.visitCode();
                methodVisitor.visitVarInsn(Opcodes.ILOAD,0);
                methodVisitor.visitVarInsn(Opcodes.IFNE,1);
                methodVisitor.visitInsn(Opcodes.LCONST_0);
                methodVisitor.visitInsn(Opcodes.LRETURN);


                methodVisitor.visitInsn(Opcodes.F_SAME);
                methodVisitor.visitVarInsn(Opcodes.ILOAD,0);
                methodVisitor.visitInsn(Opcodes.ICONST_1);
                methodVisitor.visitVarInsn(Opcodes.IF_ICMPNE, 2);
                methodVisitor.visitInsn(Opcodes.LCONST_1);
                methodVisitor.visitLabel(l1);
                methodVisitor.visitInsn(Opcodes.LRETURN);

                methodVisitor.visitLabel(l2);
                methodVisitor.visitInsn(Opcodes.F_SAME);
                methodVisitor.visitVarInsn(Opcodes.ILOAD,0);
                methodVisitor.visitInsn(Opcodes.ICONST_1);
                methodVisitor.visitInsn(Opcodes.ISUB);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC,"OneMethodClass","fib","(I)J",false);
                methodVisitor.visitVarInsn(Opcodes.ILOAD,0);
                methodVisitor.visitInsn(Opcodes.ICONST_2);
                methodVisitor.visitInsn(Opcodes.ISUB);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC,"OneMethodClass","fib","(I)J",false);
                methodVisitor.visitInsn(Opcodes.LADD);
                methodVisitor.visitInsn(Opcodes.LRETURN);

                methodVisitor.visitLabel(l3);
                methodVisitor.visitEnd();
                *//*L0
                LINENUMBER 5 L0
                ILOAD 0
                IFNE L1
                LCONST_0
                    LRETURN
                L1
                LINENUMBER 6 L1
                FRAME SAME
                ILOAD 0
                ICONST_1
                IF_ICMPNE L2
                LCONST_1
                    LRETURN
                L2
                LINENUMBER 7 L2
                FRAME SAME
                ILOAD 0
                ICONST_1
                    ISUB
                INVOKESTATIC edu/hw11/FibClass.fib (I)J
                ILOAD 0
                ICONST_2
                    ISUB
                INVOKESTATIC edu/hw11/FibClass.fib (I)J
                    LADD
                LRETURN
                    L3
                LOCALVARIABLE n I L0 L3 0
                MAXSTACK = 4
                MAXLOCALS = 1*//*
                System.out.println(methodVisitor.);
                return new Size(4, 1);
            }
        };

        var loaded =
            new ByteBuddy().subclass(Object.class).name("OneMethodClass")
                .defineMethod("fib", long.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
                .withParameter(int.class, "n")
                .intercept(new Implementation.Simple(appender))
                .make()
                .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.INJECTION).getLoaded();
        for (int y =0; y< 100; y++) {
            var number = ThreadLocalRandom.current().nextInt(50);
            loaded.getMethods()[0].toGenericString();
            var object = loaded.getMethods()[0].invoke(this,number);
            assertThat(object).isEqualTo(FibClass.fib(number));
        }
    }
}*/

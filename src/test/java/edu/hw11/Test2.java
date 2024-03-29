package edu.hw11;

import java.util.UUID;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test2 {
    @Test
    @DisplayName("При вызове minutesToSeconds из-за  переопределения  метода происходит не парсинг строки формата mm:ss," +
        " а возврат длины данной строки")
    void redefine() {
        ByteBuddyAgent.install();
        new ByteBuddy()
            .redefine(edu.hw11.TestClass.class)
            .method(named("minutesToSeconds")).intercept(MethodDelegation.to(edu.hw11.ClassForDelegate.class))
            .make().load(TestClass.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());;
        for (int y = 0; y < 100; y++) {
            var currStr = UUID.randomUUID().toString();
            assertThat(new TestClass().minutesToSeconds(currStr)).isEqualTo(currStr.length());
        }
    }

    @Test
    @DisplayName("Изменение поведения статического метода")
    void redefineStatic() {
        ByteBuddyAgent.install();


        new ByteBuddy()
            .redefine(edu.hw11.TestClass.class)
            .method(named("staticCount"))
            .intercept(MethodDelegation.to(edu.hw11.ClassForDelegate.class))
            .make()
            .load(getClass().getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        for (int y = 0; y < 100; y++) {
            var currStr = UUID.randomUUID().toString();
            assertThat(TestClass.staticCount(currStr)).isEqualTo(currStr.length());
        }
    }
}

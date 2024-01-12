package edu.hw11;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("HideUtilityClassConstructor")
public class ClassForDelegate {
    public static int length(@NotNull String count) {
        return count.length();
    }
}

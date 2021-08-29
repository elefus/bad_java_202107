package com.bad_java.lectures._03;

import lombok.NonNull;

/**
 * @deprecated 1.6
 * @see String#repeat(int)
 * @author Николай
 */
@Deprecated
public class NullableExample {

    public static void main(String[] args) {
        Integer count = null;
        if (args.length > 2) {
            count = 5;
        }
        System.out.println(duplicate("", count));
    }

    /**
     * Common description of the {@link Object#toString()} method
     * <br/>
     * <br/>
     * <br/>
     * <ol>
     *     <li>1</li>
     *     <li>1</li>
     *     <li>1</li>
     *     <li>1</li>
     * </ol>
     *
     * @param str String to be duplicated
     * @param count How many time we need to duplicate
     * @throws IllegalArgumentException if count less then 1
     * @return Duplicated string
     * @see <a href="https://google.com">Link to external documentaion</a>
     * @see Object#toString()
     * @see Object#toString()
     * @see Object#toString()
     * @since 1.0
     */
    public static String duplicate(String str, @NonNull Integer count) throws IllegalArgumentException {
        if (count < 1) {
            throw new IllegalArgumentException();
        }
        return str.repeat(count);
    }
}

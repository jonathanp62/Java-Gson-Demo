package net.jmp.demo.gson.demos;

/*
 * (#)TestTypeTokenDemo.java    0.5.0   10/06/2024
 *
 * MIT License
 *
 * Copyright (c) 2024 Jonathan M. Parker
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import net.jmp.util.extra.WrappedObject;

import static net.jmp.util.testing.testutil.TestUtils.castToType;
import static net.jmp.util.testing.testutil.TestUtils.listToTypedList;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

/// The test class for TypeTokenDemo.
///
/// @version    0.5.0
/// @since      0.5.0
public final class TestTypeTokenDemo {
    @Test
    public void testToWrappedStringObject() throws Exception {
        final var demo = new TypeTokenDemo();
        final var method = TypeTokenDemo.class.getDeclaredMethod("toWrappedStringObject");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("{\"object\":\"Hello, world\"}", json);
    }

    @Test
    public void testFromWrappedStringObject() throws Exception {
        final var demo = new TypeTokenDemo();
        final var method = TypeTokenDemo.class.getDeclaredMethod("fromWrappedStringObject");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String unwrapped = castToType(String.class, o);

        assertNotNull(unwrapped);
        assertEquals("Some string content", unwrapped);
    }

    @Test
    public void testToWrappedIntegerObject() throws Exception {
        final var demo = new TypeTokenDemo();
        final var method = TypeTokenDemo.class.getDeclaredMethod("toWrappedIntegerObject");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("{\"object\":12345}", json);
    }

    @Test
    public void testFromWrappedIntegerObject() throws Exception {
        final var demo = new TypeTokenDemo();
        final var method = TypeTokenDemo.class.getDeclaredMethod("fromWrappedIntegerObject");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final Integer unwrapped = castToType(Integer.class, o);

        assertNotNull(unwrapped);
        assertEquals(12345, (long) unwrapped);
    }

    @Test
    public void testToListOfStrings() throws Exception {
        final var demo = new TypeTokenDemo();
        final var method = TypeTokenDemo.class.getDeclaredMethod("toListOfStrings");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("[\"one\",\"two\",\"three\",\"four\",\"five\"]", json);
    }

    @Test
    public void testFromListOfStrings() throws Exception {
        final var demo = new TypeTokenDemo();
        final var method = TypeTokenDemo.class.getDeclaredMethod("fromListOfStrings");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final List<?> list = castToType(List.class, o);
        final List<String> strings = listToTypedList(list, String.class);

        assertNotNull(strings);

        final List<String> expected = List.of("one", "two", "three", "four", "five");

        assertEquals(expected, strings);
    }

    @Test
    public void testToListOfWrappedIntegers() throws Exception {
        final var demo = new TypeTokenDemo();
        final var method = TypeTokenDemo.class.getDeclaredMethod("toListOfWrappedIntegers");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("[{\"object\":1},{\"object\":2},{\"object\":3},{\"object\":4},{\"object\":5}]", json);
    }

    @Test
    public void testFromListOfWrappedIntegers() throws Exception {
        final var demo = new TypeTokenDemo();
        final var method = TypeTokenDemo.class.getDeclaredMethod("fromListOfWrappedIntegers");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final List<?> list = castToType(List.class, o);
        final List<WrappedObject> objects = listToTypedList(list, WrappedObject.class);

        assertNotNull(objects);

        final List<WrappedObject<Integer>> expected = List.of(
                WrappedObject.of(1),
                WrappedObject.of(2),
                WrappedObject.of(3),
                WrappedObject.of(4),
                WrappedObject.of(5)
        );

        assertEquals(expected, objects);
    }

    @Test
    public void testToMap() throws Exception {

    }

    @Test
    public void testFromMap() throws Exception {

    }
}

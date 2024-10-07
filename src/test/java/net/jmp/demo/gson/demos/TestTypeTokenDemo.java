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

import static net.jmp.util.testing.testutil.TestUtils.castToType;

import static org.junit.Assert.*;

import org.junit.Test;

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
        final String wrapped = castToType(String.class, o);

        assertNotNull(wrapped);
        assertEquals("Some string content", wrapped);
    }

    @Test
    public void testToWrappedIntegerObject() throws Exception {

    }

    @Test
    public void testFromWrappedIntegerObject() throws Exception {

    }

    @Test
    public void testToListOfStrings() throws Exception {

    }

    @Test
    public void testFromListOfStrings() throws Exception {

    }

    @Test
    public void testToListOfWrappedIntegers() throws Exception {

    }

    @Test
    public void testFromListOfWrappedIntegers() throws Exception {

    }

    @Test
    public void testToMap() throws Exception {

    }

    @Test
    public void testFromMap() throws Exception {

    }
}

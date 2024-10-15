package net.jmp.demo.gson.demos;

/*
 * (#)TestDataBindingDemo.java  0.9.0   10/15/2024
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

import com.google.gson.Gson;

import static net.jmp.util.testing.testutil.TestUtils.castToType;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/// The test class for DataBindingDemo.
///
/// @version    0.9.0
/// @since      0.9.0
public final class TestDataBindingDemo {
    private Gson gson;

    @Before
    public void before() {
        this.gson = new Gson();
    }

    @Test
    public void testToString() throws Exception {
        final var demo = new DataBindingDemo();
        final var method = DataBindingDemo.class.getDeclaredMethod("toString", Gson.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.gson);
        final String string = castToType(String.class, o);

        assertEquals("Jonathan Parker", string);
    }

    @Test
    public void testToLong() throws Exception {
        final var demo = new DataBindingDemo();
        final var method = DataBindingDemo.class.getDeclaredMethod("toLong", Gson.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.gson);
        final Long number = castToType(Long.class, o);

        assertEquals(62, (long) number);
    }

    @Test
    public void testToBoolean() throws Exception {
        final var demo = new DataBindingDemo();
        final var method = DataBindingDemo.class.getDeclaredMethod("toBoolean", Gson.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.gson);
        final Boolean bool = castToType(Boolean.class, o);

        assertTrue(bool);
    }

    @Test
    public void testToIntegerArray() throws Exception {
        final var demo = new DataBindingDemo();
        final var method = DataBindingDemo.class.getDeclaredMethod("toIntegerArray", Gson.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.gson);
        final int[] integers = castToType(int[].class, o);

        assertArrayEquals(new int[]{100, 90, 85}, integers);
    }

    @Test
    public void testFromString() throws Exception {
        final var demo = new DataBindingDemo();
        final var method = DataBindingDemo.class.getDeclaredMethod("fromString", Gson.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.gson);
        final String string = castToType(String.class, o);

        assertEquals("\"Jonathan Parker\"", string);
    }

    @Test
    public void testFromLong() throws Exception {
        final var demo = new DataBindingDemo();
        final var method = DataBindingDemo.class.getDeclaredMethod("fromLong", Gson.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.gson);
        final String string = castToType(String.class, o);

        assertEquals("62", string);
    }

    @Test
    public void testFromBoolean() throws Exception {
        final var demo = new DataBindingDemo();
        final var method = DataBindingDemo.class.getDeclaredMethod("fromBoolean", Gson.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.gson);
        final String string = castToType(String.class, o);

        assertEquals("true", string);
    }

    @Test
    public void testFromIntegerArray() throws Exception {
        final var demo = new DataBindingDemo();
        final var method = DataBindingDemo.class.getDeclaredMethod("fromIntegerArray", Gson.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.gson);
        final String string = castToType(String.class, o);

        assertEquals("[100,90,95]", string);
    }
}

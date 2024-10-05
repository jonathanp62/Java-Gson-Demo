package net.jmp.demo.gson.demos;

/*
 * (#)TestNullDemo.java 0.3.0   10/04/2024
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

import net.jmp.demo.gson.classes.Student;

import static net.jmp.util.testing.testutil.TestUtils.castToType;

import static org.junit.Assert.*;

import org.junit.Test;

/// The test class for NullDemo.
///
/// @version    0.3.0
/// @since      0.3.0
public final class TestNullDemo {
    @Test
    public void testToJsonWithoutNulls() throws Exception {
        final var demo = new NullDemo();
        final var method = NullDemo.class.getDeclaredMethod("toJsonWithoutNulls");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("{\"rollNo\":2}", json);
    }

    @Test
    public void testToJsonWithoutNullsUsingAdapter() throws Exception {
        final var demo = new NullDemo();
        final var method = NullDemo.class.getDeclaredMethod("toJsonWithoutNullsUsingAdapter");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("{\"rollNo\":3}", json);
    }

    @Test
    public void testToJsonWithNulls() throws Exception {
        final var demo = new NullDemo();
        final var method = NullDemo.class.getDeclaredMethod("toJsonWithNulls");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("{\"rollNo\":4,\"name\":null}", json);
    }

    @Test
    public void testToJsonWithNullsUsingAdapter() throws Exception {
        final var demo = new NullDemo();
        final var method = NullDemo.class.getDeclaredMethod("toJsonWithNullsUsingAdapter");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("{\"name\":null,\"rollNo\":5}", json);
    }

    @Test
    public void testFromJsonWithoutNulls() throws Exception {
        final var demo = new NullDemo();
        final var method = NullDemo.class.getDeclaredMethod("fromJsonWithoutNulls");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final Student student = castToType(Student.class, o);

        assertNotNull(student);

        final Student expected = new Student();

        expected.setRollNo(7);

        assertEquals(expected, student);
    }

    @Test
    public void testFromJsonWithNulls() throws Exception {
        final var demo = new NullDemo();
        final var method = NullDemo.class.getDeclaredMethod("fromJsonWithNulls");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final Student student = castToType(Student.class, o);

        assertNotNull(student);

        final Student expected = new Student();

        expected.setRollNo(6);

        assertEquals(expected, student);
    }
}

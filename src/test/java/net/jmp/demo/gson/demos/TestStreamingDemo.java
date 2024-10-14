package net.jmp.demo.gson.demos;

/*
 * (#)TestStreamingDemo.java    0.8.0   10/13/2024
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

import java.util.List;

import net.jmp.demo.gson.classes.Developer;

import static net.jmp.util.testing.testutil.TestUtils.castToType;

import static org.junit.Assert.*;

import org.junit.Test;

/// The test class for StreamingDemo.
///
/// @version    0.8.0
/// @since      0.8.0
public final class TestStreamingDemo {
    @Test
    public void testDeveloper() throws Exception {
        final var demo = new StreamingDemo();
        final var method = StreamingDemo.class.getDeclaredMethod("fromDeveloperJson");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final Developer developer = castToType(Developer.class, o);

        assertNotNull(developer);

        final Developer expected = new Developer();
        final Developer.Name name = new Developer.Name();

        name.setFirstName("Jonathan");
        name.setLastName("Parker");

        expected.setName(name);
        expected.setLanguage("Java");

        assertEquals(expected, developer);
    }

    @Test
    public void testElements() throws Exception {
        final var demo = new StreamingDemo();
        final var method = StreamingDemo.class.getDeclaredMethod("fromArrayJson");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final StreamingDemo.Elements elements = castToType(StreamingDemo.Elements.class, o);

        assertNotNull(elements);

        final StreamingDemo.Elements expected = new StreamingDemo.Elements();
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        expected.name = "my-elements";
        expected.numbers = numbers;

        assertEquals(expected, elements);
    }
}

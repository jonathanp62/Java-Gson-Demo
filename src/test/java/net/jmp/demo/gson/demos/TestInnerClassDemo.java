package net.jmp.demo.gson.demos;

/*
 * (#)TestInnerClassDemo.java   0.6.0   10/10/2024
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

import net.jmp.demo.gson.classes.Developer;
import org.junit.Test;

/// The test class for InnerClassDemo.
///
/// @version    0.6.0
/// @since      0.6.0
public final class TestInnerClassDemo {
    @Test
    public void testToJsonInner() throws Exception {
        final var demo = new InnerClassDemo();
        final var method = InnerClassDemo.class.getDeclaredMethod("toJsonInner");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("{\"first-name\":\"Jonathan\",\"last-name\":\"Parker\"}", json);
    }

    @Test
    public void testFromJsonInner() throws Exception {
        final var demo = new InnerClassDemo();
        final var method = InnerClassDemo.class.getDeclaredMethod("fromJsonInner");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final Developer.Name name = castToType(Developer.Name.class, o);
        final Developer.Name expected = new Developer.Name();

        expected.setFirstName("Jonathan");
        expected.setLastName("Parker");

        assertNotNull(name);
        assertEquals(expected, name);
    }

    @Test
    public void testToJsonOuter() throws Exception {
        final var demo = new InnerClassDemo();
        final var method = InnerClassDemo.class.getDeclaredMethod("toJsonOuter");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);

        assertNotNull(json);
        assertEquals("{\"name\":{\"first-name\":\"Jonathan\",\"last-name\":\"Parker\"},\"language\":\"Java\"}", json);
    }

    @Test
    public void testFromJsonOuter() throws Exception {
        final var demo = new InnerClassDemo();
        final var method = InnerClassDemo.class.getDeclaredMethod("fromJsonOuter");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final Developer developer = castToType(Developer.class, o);
        final Developer expected = new Developer();
        final Developer.Name expectedName = new Developer.Name();

        expectedName.setFirstName("Jonathan");
        expectedName.setLastName("Parker");

        expected.setLanguage("Java");
        expected.setName(expectedName);

        assertNotNull(developer);
        assertEquals(expected, developer);
    }
}

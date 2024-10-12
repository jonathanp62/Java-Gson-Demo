package net.jmp.demo.gson.demos;

/*
 * (#)TestExposeDemo.java   0.7.0   10/12/2024
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

import net.jmp.demo.gson.classes.User;

import static net.jmp.util.testing.testutil.TestUtils.castToType;

import static org.junit.Assert.*;

import org.junit.Test;

/// The test class for ExposeDemo.
///
/// @version    0.7.0
/// @since      0.7.0
public final class TestExposeDemo {
    @Test
    public void testToJsonIgnoreExpose() throws Exception {
        final var demo = new ExposeDemo();
        final var method = ExposeDemo.class.getDeclaredMethod("toJsonIgnoreExpose");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);
        final String expected = "{\"firstName\":\"Jonathan\",\"lastName\":\"Parker\",\"emailAddress\":\"me@domain.com\",\"password\":\"my-secret-password\"}";

        assertNotNull(json);
        assertEquals(expected, json);
    }

    @Test
    public void testToJson() throws Exception {
        final var demo = new ExposeDemo();
        final var method = ExposeDemo.class.getDeclaredMethod("toJson");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final String json = castToType(String.class, o);
        final String expected = "{\"firstName\":\"Jonathan\"}";

        assertNotNull(json);
        assertEquals(expected, json);
    }

    @Test
    public void testFromJson() throws Exception {
        final var demo = new ExposeDemo();
        final var method = ExposeDemo.class.getDeclaredMethod("fromJson");

        method.setAccessible(true);

        final Object o = method.invoke(demo);
        final User user = castToType(User.class, o);
        final User expected = new User();

        expected.setFirstName("Jonathan");
        expected.setLastName("Parker");

        assertNotNull(user);
        assertEquals(expected, user);
    }
}

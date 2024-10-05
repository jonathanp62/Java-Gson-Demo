package net.jmp.demo.gson.demos;

/*
 * (#)TestVersioningDemo.java   0.4.0   10/05/2024
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

import net.jmp.demo.gson.classes.Person;

import static net.jmp.util.testing.testutil.TestUtils.castToType;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/// The test class for VersioningDemo.
///
/// @version    0.4.0
/// @since      0.4.0
public final class TestVersioningDemo {
    private Person person;
    private String json;

    @Before
    public void before() {
        this.person = new Person();

        this.person.setAddress("Lantana Drive");
        this.person.setAge(62);
        this.person.setGender(Person.Gender.MALE);
        this.person.setName("Jonathan");
        this.person.setPhone("555-123-4567");

        this.json = "{\"name\":\"Jonathan\",\"address\":\"Lantana Drive\",\"age\":62,\"phone\":\"555-123-4567\",\"gender\":\"MALE\"}";
    }

    @Test
    public void testToJsonV04() throws Exception {
        final var demo = new VersioningDemo();
        final var method = VersioningDemo.class.getDeclaredMethod("toJsonV04", Person.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.person);
        final String jsonResult = castToType(String.class, o);

        assertNotNull(jsonResult);
        assertEquals("{\"name\":\"Jonathan\",\"address\":\"Lantana Drive\",\"age\":62}", jsonResult);
    }

    @Test
    public void testToJsonV041() throws Exception {
        final var demo = new VersioningDemo();
        final var method = VersioningDemo.class.getDeclaredMethod("toJsonV041", Person.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.person);
        final String jsonResult = castToType(String.class, o);

        assertNotNull(jsonResult);
        assertEquals("{\"name\":\"Jonathan\",\"address\":\"Lantana Drive\",\"age\":62,\"phone\":\"555-123-4567\",\"gender\":\"MALE\"}", jsonResult);
    }

    @Test
    public void testFromJsonV04() throws Exception {
        final var demo = new VersioningDemo();
        final var method = VersioningDemo.class.getDeclaredMethod("fromJsonV04", String.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.json);
        final Person personResult = castToType(Person.class, o);

        assertNotNull(personResult);
        assertEquals("Jonathan", personResult.getName());
        assertEquals("Lantana Drive", personResult.getAddress());
        assertEquals(62, personResult.getAge());
        assertNull(personResult.getPhone());
        assertNull(personResult.getGender());
    }

    @Test
    public void testFromJsonV041() throws Exception {
        final var demo = new VersioningDemo();
        final var method = VersioningDemo.class.getDeclaredMethod("fromJsonV041", String.class);

        method.setAccessible(true);

        final Object o = method.invoke(demo, this.json);
        final Person personResult = castToType(Person.class, o);

        assertNotNull(personResult);
        assertEquals("Jonathan", personResult.getName());
        assertEquals("Lantana Drive", personResult.getAddress());
        assertEquals(62, personResult.getAge());
        assertEquals("555-123-4567", personResult.getPhone());
        assertEquals(Person.Gender.MALE, personResult.getGender());
    }
}

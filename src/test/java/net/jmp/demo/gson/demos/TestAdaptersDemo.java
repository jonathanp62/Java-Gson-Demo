package net.jmp.demo.gson.demos;

/*
 * (#)TestAdaptersDemo.java 0.2.0   09/28/2024
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

import net.jmp.demo.gson.classes.Club;
import net.jmp.demo.gson.classes.GoldMember;
import net.jmp.demo.gson.classes.SilverMember;
import net.jmp.demo.gson.classes.Student;

import static net.jmp.util.testing.testutil.TestUtils.castToType;

import static org.junit.Assert.*;

import org.junit.Test;

/// The test class for AdaptersDemo.
///
/// @version    0.2.0
/// @since      0.2.0
public final class TestAdaptersDemo {
    @Test
    public void testToStudent() throws Exception {
        final var demo = new AdaptersDemo();
        final var method = AdaptersDemo.class.getDeclaredMethod("deserializeStudent", String.class);

        method.setAccessible(true);

        final String json = "{\"name\":\"Jonathan\",\"rollNo\":1}";

        final Object o = method.invoke(demo, json);
        final Student student = castToType(Student.class, o);
        final Student expected = new Student();

        expected.setName("Jonathan");
        expected.setRollNo(1);

        assertNotNull(student);
        assertEquals(expected, student);
    }

    @Test
    public void testFromStudent() throws Exception {
        final var demo = new AdaptersDemo();
        final var method = AdaptersDemo.class.getDeclaredMethod("serializeStudent", Student.class);

        method.setAccessible(true);

        final Student student = new Student();

        student.setName("Jonathan");
        student.setRollNo(1);

        final Object o = method.invoke(demo, student);
        final String json = castToType(String.class, o);
        final String expected = "{\n  \"name\": \"Jonathan\",\n  \"rollNo\": 1\n}";

        assertNotNull(student);
        assertEquals(expected, json);
    }

    @Test
    public void testClub() throws Exception {
        final var demo = new AdaptersDemo();
        final var serializeMethod = AdaptersDemo.class.getDeclaredMethod("serializeClub", Club.class);
        final var deserializeMethod = AdaptersDemo.class.getDeclaredMethod("deserializeClub", String.class);

        serializeMethod.setAccessible(true);
        deserializeMethod.setAccessible(true);

        final Club myClub = new Club();

        myClub.addMember(new SilverMember("Jamie", 39));
        myClub.addMember(new GoldMember("Jonathan", 62));
        myClub.addMember(new SilverMember("Kelli", 44));

        Object o = serializeMethod.invoke(demo, myClub);

        final String json = castToType(String.class, o);

        assertNotNull(json);

        o = deserializeMethod.invoke(demo, json);

        final Club club = castToType(Club.class, o);

        assertNotNull(club);
        assertEquals(myClub, club);
    }
}

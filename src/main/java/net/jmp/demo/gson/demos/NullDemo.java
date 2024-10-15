package net.jmp.demo.gson.demos;

/*
 * (#)NullDemo.java 0.3.0   10/01/2024
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
import com.google.gson.GsonBuilder;

import net.jmp.demo.gson.adapters.StudentAdapter;

import net.jmp.demo.gson.annotations.Version;

import net.jmp.demo.gson.classes.Student;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A class that demonstrates Gson null object support.
///
/// @version    0.3.0
/// @since      0.3.0
@Version(0.3)
public final class NullDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public NullDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        if (this.logger.isInfoEnabled()) {
            this.logger.info("No nulls: {}", this.toJsonWithoutNulls());
            this.logger.info("No nulls: {}", this.toJsonWithoutNullsUsingAdapter());
            this.logger.info("Nulls:    {}", this.toJsonWithNulls());
            this.logger.info("Nulls:    {}", this.toJsonWithNullsUsingAdapter());

            this.logger.info("No nulls: {}", this.fromJsonWithoutNulls().toString());
            this.logger.info("Nulls:    {}", this.fromJsonWithNulls().toString());
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Return a string of JSON without null serialization.
    ///
    /// @return java.lang.String
    private String toJsonWithoutNulls() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Student student = new Student();

        student.setRollNo(2);

        final String json = gson.toJson(student);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return a string of JSON without null
    /// serialization using the type adapter.
    ///
    /// @return java.lang.String
    private String toJsonWithoutNullsUsingAdapter() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Student.class, new StudentAdapter());

        final Gson gson = builder.create();

        final Student student = new Student();

        student.setRollNo(3);

        final String json = gson.toJson(student);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return a string of JSON with null serialization.
    ///
    /// @return java.lang.String
    private String toJsonWithNulls() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.serializeNulls();

        final Gson gson = builder.create();

        final Student student = new Student();

        student.setRollNo(4);

        final String json = gson.toJson(student);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return a string of JSON with null
    /// serialization using the type adapter.
    ///
    /// @return java.lang.String
    private String toJsonWithNullsUsingAdapter() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.serializeNulls();
        builder.registerTypeAdapter(Student.class, new StudentAdapter());

        final Gson gson = builder.create();

        final Student student = new Student();

        student.setRollNo(5);

        final String json = gson.toJson(student);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return a student built with nulls.
    ///
    /// @return net.jmp.demo.gson.classes.Student
    private Student fromJsonWithNulls() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Student.class, new StudentAdapter());

        final Gson gson = builder.create();

        final String json = "{\"rollNo\":6,\"name\":null}";
        final Student student = gson.fromJson(json, Student.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(student));
        }

        return student;
    }

    /// Return a student built without nulls.
    ///
    /// @return net.jmp.demo.gson.classes.Student
    private Student fromJsonWithoutNulls() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Student.class, new StudentAdapter());

        final Gson gson = builder.create();

        final String json = "{\"rollNo\":7}";
        final Student student = gson.fromJson(json, Student.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(student));
        }

        return student;
    }
}

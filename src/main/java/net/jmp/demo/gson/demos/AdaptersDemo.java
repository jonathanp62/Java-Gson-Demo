package net.jmp.demo.gson.demos;

/*
 * (#)AdaptersDemo.java 0.2.0   09/28/2024
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

import net.jmp.demo.gson.classes.Student;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A class that demonstrates Gson type adapters.
///
/// @version    0.2.0
/// @since      0.2.0
public final class AdaptersDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public AdaptersDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final String json = "{\"name\":\"Jonathan\",\"rollNo\":1}";
        final Student student = new Student();

        student.setName("Jonathan");
        student.setRollNo(1);

        if (this.logger.isInfoEnabled()) {
            this.logger.info(this.deserializeStudent(json).toString());
            this.logger.info(this.serializeStudent(student));
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Deserialize the JSON into a Student object.
    ///
    /// @param  json    java.lang.String
    /// @return         net.jmp.demo.gson.classes.Student
    private Student deserializeStudent(final String json) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(json));
        }

        final Gson gson = this.getGson();
        final Student student = gson.fromJson(json, Student.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(student));
        }

        return student;
    }

    /// Serialize the Student object into JSON.
    ///
    /// @param  student net.jmp.demo.gson.classes.Student
    /// @return         java.lang.String
    private String serializeStudent(final Student student) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(student));
        }

        final Gson gson = this.getGson();
        final String json = gson.toJson(student);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Build and return a configured Gson object.
    ///
    /// @return com.google.gson.Gson
    private Gson getGson() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Student.class, new StudentAdapter());
        builder.setPrettyPrinting();

        final Gson gson = builder.create();

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(gson));
        }

        return gson;
    }
}

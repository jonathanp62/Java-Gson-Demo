package net.jmp.demo.gson.adapters;

/*
 * (#)StudentAdapter.java   0.3.0   10/04/2024
 * (#)StudentAdapter.java   0.2.0   09/28/2024
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

import com.google.gson.TypeAdapter;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import net.jmp.demo.gson.classes.Student;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A Gson type adapter for the Student class.
///
/// @version    0.3.0
/// @since      0.2.0
public final class StudentAdapter extends TypeAdapter<Student> {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public StudentAdapter() {
        super();
    }

    /// Read (deserialize) the JSON and return a new Student.
    ///
    /// @param reader   com.google.gson.stream.JsonReader
    /// @return         net.jmp.demo.gson.classes.Student
    @Override
    public Student read(final JsonReader reader) throws IOException {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(reader));
        }

        final Student student = new Student();

        reader.beginObject();

        String currentFieldName = null;

        while (reader.hasNext()) {
            JsonToken token = reader.peek();                // Get current token

            if (token.equals(JsonToken.NAME)) {
                // The current token is the field name
                // Read it and move to the next token
                // Which should be a value

                currentFieldName = reader.nextName();
            }

            if ("name".equals(currentFieldName)) {
                token = reader.peek();                      // Get current token

                if (token.equals(JsonToken.STRING)) {
                    // The current token is a string value
                    // Read it and move to the next token
                    // Which should be a field name

                    student.setName(reader.nextString());   // Set the value
                }

                if (token.equals(JsonToken.NULL)) {
                    // The current token is a null
                    // Read it and move to the next token
                    // Which should be a field name

                    this.logger.debug("Null token: {}", token);
                    reader.nextNull();                      // No value to set
                }
            }

            if ("rollNo".equals(currentFieldName)) {
                token = reader.peek();                      // Get current token

                if (token.equals(JsonToken.NUMBER)) {
                    // The current token is a numeric value
                    // Read it and move to the next token
                    // Which should be a field name

                    student.setRollNo(reader.nextInt());    // Set the value
                }
            }
        }

        reader.endObject();

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(reader));
        }

        return student;
    }

    /// Write (serialize) the Student into JSON.
    ///
    /// @param  writer  com.google.gson.stream.JsonWriter
    /// @param  student net.jmp.demo.gson.classes.Student
    @Override
    public void write(final JsonWriter writer, final Student student) throws IOException {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(writer, student));
        }

        writer.beginObject();

        if (student.getName() == null) {
            this.logger.debug("'name' was null");
        }

        writer.name("name");
        writer.value(student.getName());

        writer.name("rollNo");
        writer.value(student.getRollNo());

        writer.endObject();

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }
}

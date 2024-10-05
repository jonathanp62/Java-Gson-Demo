package net.jmp.demo.gson.adapters;

/*
 * (#)PersonAdapter.java    0.4.0   10/05/2024
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

import com.google.gson.annotations.Since;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import net.jmp.demo.gson.classes.Person;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A GsonType adapter for the Person class. It is
/// possible to set a version in a constructor. If
/// the version is 0, then all fields are included.
/// If the version is greater than 0, then fields
/// annotated with @Since will only be included if
/// the @Since value is less than or equal to the
/// version. In other words, if specified, the version
/// is the highest @Since value allowed for field to
/// be included.
///
/// @version    0.4.0
/// @since      0.4.0
public class PersonAdapter extends TypeAdapter<Person> {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The version.
    private double version;

    /// The default constructor.
    public PersonAdapter() {
        super();
    }

    /// A constructor that takes a version.
    ///
    /// @param  version double
    public PersonAdapter(final double version) {
        super();

        this.version = version;
    }

    /// Read (deserialize) the JSON and return a new Person.
    ///
    /// @param reader   com.google.gson.stream.JsonReader
    /// @return         net.jmp.demo.gson.classes.Person
    @Override
    public Person read(final JsonReader reader) throws IOException {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(reader));
        }

        final Person person = new Person();

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

                    final double nameVersion = this.getFieldSince("name");
                    final String value = reader.nextString();

                    if (this.version == 0 || nameVersion <= this.version) {
                        person.setName(value);              // Set the value
                    }
                }

                if (token.equals(JsonToken.NULL)) {
                    // The current token is a null
                    // Read it and move to the next token
                    // Which should be a field name

                    this.logger.debug("Null token: {}", token);
                    reader.nextNull();                      // No value to set
                }
            }

            if ("address".equals(currentFieldName)) {
                token = reader.peek();                      // Get current token

                if (token.equals(JsonToken.STRING)) {
                    // The current token is a string value
                    // Read it and move to the next token
                    // Which should be a field name

                    final double addressVersion = this.getFieldSince("address");
                    final String value = reader.nextString();

                    if (this.version == 0 || addressVersion <= this.version) {
                        person.setAddress(value);           // Set the value
                    }
                }

                if (token.equals(JsonToken.NULL)) {
                    // The current token is a null
                    // Read it and move to the next token
                    // Which should be a field name

                    this.logger.debug("Null token: {}", token);
                    reader.nextNull();                      // No value to set
                }
            }

            if ("age".equals(currentFieldName)) {
                token = reader.peek();                      // Get current token

                if (token.equals(JsonToken.NUMBER)) {
                    // The current token is a numeric value
                    // Read it and move to the next token
                    // Which should be a field name

                    final double ageVersion = this.getFieldSince("age");
                    final int value = reader.nextInt();

                    if (this.version == 0 || ageVersion <= this.version) {
                        person.setAge(value);               // Set the value
                    }
                }
            }

            if ("phone".equals(currentFieldName)) {
                token = reader.peek();                      // Get current token

                if (token.equals(JsonToken.STRING)) {
                    // The current token is a string value
                    // Read it and move to the next token
                    // Which should be a field name

                    final double phoneVersion = this.getFieldSince("phone");
                    final String value = reader.nextString();

                    if (this.version == 0 || phoneVersion <= this.version) {
                        person.setPhone(value);             // Set the value
                    }
                }

                if (token.equals(JsonToken.NULL)) {
                    // The current token is a null
                    // Read it and move to the next token
                    // Which should be a field name

                    this.logger.debug("Null token: {}", token);
                    reader.nextNull();                      // No value to set
                }
            }

            if ("gender".equals(currentFieldName)) {
                token = reader.peek();                      // Get current token

                if (token.equals(JsonToken.STRING)) {
                    // The current token is a string value
                    // Read it and move to the next token
                    // Which should be a field name

                    final double genderVersion = this.getFieldSince("gender");
                    final String value = reader.nextString();

                    if (this.version == 0 || genderVersion <= this.version) {
                        if (value.equals("FEMALE")) {
                            person.setGender(Person.Gender.FEMALE);
                        } else if (value.equals("MALE")) {
                            person.setGender(Person.Gender.MALE);
                        }
                    }
                }

                if (token.equals(JsonToken.NULL)) {
                    // The current token is a null
                    // Read it and move to the next token
                    // Which should be a field name

                    this.logger.debug("Null token: {}", token);
                    reader.nextNull();                      // No value to set
                }
            }
        }

        reader.endObject();

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(reader));
        }

        return person;
    }

    /// Write (serialize) the Person into JSON.
    ///
    /// @param  writer  com.google.gson.stream.JsonWriter
    /// @param  person net.jmp.demo.gson.classes.Person
    @Override
    public void write(final JsonWriter writer, final Person person) throws IOException {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(writer, person));
        }

        writer.beginObject();

        if (person.getName() == null) {
            this.logger.debug("'name' was null");
        }

        writer.name("name");
        writer.value(person.getName());

        if (person.getAddress() == null) {
            this.logger.debug("'address' was null");
        }

        writer.name("address");
        writer.value(person.getAddress());

        writer.name("age");
        writer.value(person.getAge());

        if (person.getPhone() == null) {
            this.logger.debug("'phone' was null");
        }

        writer.name("phone");
        writer.value(person.getPhone());

        if (person.getGender() == null) {
            this.logger.debug("'gender' was null");
        }

        writer.name("gender");
        writer.value(person.getGender().toString());

        writer.endObject();

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Return the value of the Gson @Since
    /// annotation is one is present.
    ///
    /// @param  fieldName   java.lang.String
    /// @return             double
    private double getFieldSince(final String fieldName) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(fieldName));
        }

        double result = 0;

        try {
            final var field = Person.class.getDeclaredField(fieldName);

            if (field.isAnnotationPresent(Since.class)) {
                final var since = field.getAnnotation(Since.class);

                result = since.value();
            }
        } catch (final NoSuchFieldException nsfe) {
            this.logger.error(catching(nsfe));
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(result));
        }

        return result;
    }
}

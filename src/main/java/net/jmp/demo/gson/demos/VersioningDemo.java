package net.jmp.demo.gson.demos;

/*
 * (#)NullDemo.java 0.4.0   10/05/2024
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

import net.jmp.demo.gson.adapters.PersonAdapter;

import net.jmp.demo.gson.classes.Person;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A class that demonstrates Gson versioning support.
///
/// @version    0.4.0
/// @since      0.4.0
public final class VersioningDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public VersioningDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Person person = new Person();

        person.setAddress("Lantana Drive");
        person.setAge(62);
        person.setGender(Person.Gender.MALE);
        person.setName("Jonathan");
        person.setPhone("555-123-4567");

        final String json = "{\"name\":\"Jonathan\",\"address\":\"Lantana Drive\",\"age\":62,\"phone\":\"555-123-4567\",\"gender\":\"MALE\"}";

        if (this.logger.isInfoEnabled()) {
            this.logger.info("V04:  {}", this.toJsonV04(person));
            this.logger.info("V04:  {}", this.toJsonV04UsingAdapter(person));
            this.logger.info("V041: {}", this.toJsonV041(person));
            this.logger.info("V04:  {}", this.fromJsonV04(json));
            this.logger.info("V04:  {}", this.fromJsonV04UsingAdapter(json));
            this.logger.info("V041: {}", this.fromJsonV041(json));
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Return person 0.4 JSON.
    ///
    /// @param  person  net.jmp.demo.gson.classes.Person
    /// @return         java.lang.String
    private String toJsonV04(final Person person) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(person));
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.setVersion(0.4);

        final Gson gson = builder.create();
        final String json = gson.toJson(person);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return person 0.4 JSON using an adapter.
    ///
    /// @param  person  net.jmp.demo.gson.classes.Person
    /// @return         java.lang.String
    private String toJsonV04UsingAdapter(final Person person) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(person));
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Person.class, new PersonAdapter());

        final Gson gson = builder.create();
        final String json = gson.toJson(person);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return person 0.41 JSON.
    ///
    /// @param  person  net.jmp.demo.gson.classes.Person
    /// @return         java.lang.String
    private String toJsonV041(final Person person) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(person));
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.setVersion(0.41);

        final Gson gson = builder.create();
        final String json = gson.toJson(person);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return a person 0.4 object.
    ///
    /// @param  json    java.lang.String
    /// @return         net.jmp.demo.gson.classes.Person
    private Person fromJsonV04(final String json) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(json));
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.setVersion(0.4);

        final Gson gson = builder.create();
        final Person person = gson.fromJson(json, Person.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(person));
        }

        return person;
    }

    /// Return a person 0.4 object using an adapter.
    ///
    /// @param  json    java.lang.String
    /// @return         net.jmp.demo.gson.classes.Person
    private Person fromJsonV04UsingAdapter(final String json) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(json));
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Person.class, new PersonAdapter(0.4));

        final Gson gson = builder.create();
        final Person person = gson.fromJson(json, Person.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(person));
        }

        return person;
    }

    /// Return a person 0.41 object.
    ///
    /// @param  json    java.lang.String
    /// @return         net.jmp.demo.gson.classes.Person
    private Person fromJsonV041(final String json) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(json));
        }

        final GsonBuilder builder = new GsonBuilder();

        builder.setVersion(0.41);

        final Gson gson = builder.create();
        final Person person = gson.fromJson(json, Person.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(person));
        }

        return person;
    }
}

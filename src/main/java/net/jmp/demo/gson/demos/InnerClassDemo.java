package net.jmp.demo.gson.demos;

/*
 * (#)InnerClassDemo.java   0.6.0   10/10/2024
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

import net.jmp.demo.gson.classes.Developer;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The class that demonstrates serializing/deserializing an inner class.
///
/// @version    0.6.0
/// @since      0.6.0
public final class InnerClassDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public InnerClassDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        if (this.logger.isInfoEnabled()) {
            this.logger.info("inner: {}", this.toJsonInner());
            this.logger.info("inner: {}", this.fromJsonInner());
            this.logger.info("outer: {}", this.toJsonOuter());
            this.logger.info("outer: {}", this.fromJsonOuter());
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Return a JSON string representation
    /// of a developer name.
    ///
    /// @return java.lang.String
    private String toJsonInner() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Developer.Name name = new Developer.Name();

        name.setFirstName("Jonathan");
        name.setLastName("Parker");

        final Gson gson = new Gson();
        final String json = gson.toJson(name);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return the developer name object
    /// from a string of JSON.
    ///
    /// @return net.jmp.demo.gson.classes.Developer.Name
    private Developer.Name fromJsonInner() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final String json = "{\"first-name\":\"Jonathan\",\"last-name\":\"Parker\"}";
        final Gson gson = new Gson();
        final Developer.Name name = gson.fromJson(json, Developer.Name.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(name));
        }

        return name;
    }

    /// Return a JSON string representation
    /// of a developer.
    ///
    /// @return java.lang.String
    private String toJsonOuter() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Developer developer = new Developer();
        final Developer.Name name = new Developer.Name();

        name.setFirstName("Jonathan");
        name.setLastName("Parker");

        developer.setLanguage("Java");
        developer.setName(name);

        final Gson gson = new Gson();
        final String json = gson.toJson(developer);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return the developer object
    /// from a string of JSON.
    ///
    /// @return net.jmp.demo.gson.classes.Developer.Name
    private Developer fromJsonOuter() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final String json = "{\"name\":{\"first-name\":\"Jonathan\",\"last-name\":\"Parker\"},\"language\":\"Java\"}";
        final Gson gson = new Gson();
        final Developer developer = gson.fromJson(json, Developer.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(developer));
        }

        return developer;
    }
}

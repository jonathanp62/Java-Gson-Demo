package net.jmp.demo.gson.demos;

/*
 * (#)DataBindingDemo.java  0.9.0   10/15/2024
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

import net.jmp.demo.gson.annotations.Version;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A class that demonstrates the Gson data binding.
///
/// @version    0.9.0
/// @since      0.9.0
@Version(0.9)
public final class DataBindingDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public DataBindingDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();

        if (this.logger.isInfoEnabled()) {
            this.logger.info("string : {}", this.toString(gson));
            this.logger.info("json   : {}", this.fromString(gson));
            this.logger.info("long   : {}", this.toLong(gson));
            this.logger.info("json   : {}", this.fromLong(gson));
            this.logger.info("boolean: {}", this.toBoolean(gson));
            this.logger.info("json   : {}", this.fromBoolean(gson));
            this.logger.info("int[]  : {}", this.toIntegerArray(gson));
            this.logger.info("json   : {}", this.fromIntegerArray(gson));
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Return a string from JSON.
    ///
    /// @param  gson    com.google.gson.Gson
    /// @return         java.lang.String
    private String toString(final Gson gson) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(gson));
        }

        final String string = gson.fromJson("\"Jonathan Parker\"", String.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(string));
        }

        return string;
    }

    /// Return JSON from a string.
    ///
    /// @param  gson    com.google.gson.Gson
    /// @return         java.lang.String
    private String fromString(final Gson gson) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(gson));
        }

        final String string = gson.toJson("Jonathan Parker");

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(string));
        }

        return string;
    }

    /// Return a long from JSON.
    ///
    /// @param  gson    com.google.gson.Gson
    /// @return         java.lang.Long
    private Long toLong(final Gson gson) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(gson));
        }

        final Long number = gson.fromJson("62", Long.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(number));
        }

        return number;
    }

    /// Return JSON from a long.
    ///
    /// @param  gson    com.google.gson.Gson
    /// @return         java.lang.String
    private String fromLong(final Gson gson) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(gson));
        }

        final String string = gson.toJson(62);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(string));
        }

        return string;
    }

    /// Return a boolean from JSON.
    ///
    /// @param  gson    com.google.gson.Gson
    /// @return         java.lang.Boolean
    private Boolean toBoolean(final Gson gson) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(gson));
        }

        final Boolean bool = gson.fromJson("true", Boolean.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(bool));
        }

        return bool;
    }

    /// Return JSON from a boolean.
    ///
    /// @param  gson    com.google.gson.Gson
    /// @return         java.lang.String
    private String fromBoolean(final Gson gson) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(gson));
        }

        final String string = gson.toJson(true);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(string));
        }

        return string;
    }

    /// Return an array of integers from JSON.
    ///
    /// @param  gson    com.google.gson.Gson
    /// @return         int[]
    private int[] toIntegerArray(final Gson gson) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(gson));
        }

        final int[] integers = gson.fromJson("[100, 90, 85]", int[].class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(integers));
        }

        return integers;
    }

    /// Return JSON from an array of integers.
    ///
    /// @param  gson    com.google.gson.Gson
    /// @return         java.lang.String
    private String fromIntegerArray(final Gson gson) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(gson));
        }

        final int[] array = { 100, 90, 95 };

        final String string = gson.toJson(array);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(string));
        }

        return string;
    }
}

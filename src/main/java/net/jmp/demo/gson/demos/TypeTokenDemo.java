package net.jmp.demo.gson.demos;

/*
 * (#)TypeTokenDemo.java    0.5.0   10/06/2024
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

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import net.jmp.util.extra.WrappedObject;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A class that demonstrates Gson type tokens.
///
/// @version    0.5.0
/// @since      0.5.0
public final class TypeTokenDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public TypeTokenDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        if (this.logger.isInfoEnabled()) {
            this.logger.info("wrapped: {}", this.toWrappedStringObject());
            this.logger.info("object: {}", this.fromWrappedStringObject());
        }

        Date date = new Date();

        this.logger.info(date.toString());

        // Specify the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        // Convert Date to Instant
        Instant instant = date.toInstant();

        // Convert Instant to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Format LocalDateTime to string
        String formattedDate = localDateTime.format(formatter);

        this.logger.info(formattedDate);

        LocalDateTime reconstructed = LocalDateTime.parse(formattedDate, formatter);
        ZonedDateTime zonedDateTime = reconstructed.atZone(ZoneId.systemDefault());
        Date reconstructedDate = Date.from(zonedDateTime.toInstant());

        if (date.equals(reconstructedDate)) {
            this.logger.info("reconstructedDate == date");
        } else {
            this.logger.info(reconstructedDate.toString());
        }

        this.logger.info(String.valueOf(date.compareTo(reconstructedDate)));

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Serialize a wrapped object
    /// to JSON and return it. The
    /// JSON key for a wrapped
    /// object is 'object'.
    ///
    /// @return java.lang.String
    private String toWrappedStringObject() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<WrappedObject<String>>() {}.getType();
        final WrappedObject<String> string = new WrappedObject<>("Hello, world");
        final String json = gson.toJson(string, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Deserialize a wrapped object
    /// from JSON and return it. The
    /// JSON key for a wrapped object
    /// is 'object'.
    ///
    /// @return java.lang.String
    private String fromWrappedStringObject() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<WrappedObject<String>>() {}.getType();
        final String json = "{\"object\":\"Some string content\"}";
        final WrappedObject<String> wrapped = gson.fromJson(json, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(wrapped.get()));
        }

        return wrapped.get();
    }
}

package net.jmp.demo.gson.demos;

/*
 * (#)StreamingDemo.java    0.8.0   10/13/2024
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

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;

import net.jmp.demo.gson.classes.Developer;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A class that demonstrates streaming using JsonReader.
///
/// @version    0.8.0
/// @since      0.8.0
public final class StreamingDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public StreamingDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        if (this.logger.isInfoEnabled()) {
            this.logger.info("developer: {}", this.fromJson());
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Return a developer object from a string of JSON.
    ///
    /// @return net.jmp.demo.gson.classes.Developer
    private Developer fromJson() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final String json = "{\"name\":{\"first-name\":\"Jonathan\",\"last-name\":\"Parker\"},\"language\":\"Java\"}";
        final JsonReader reader = new JsonReader(new StringReader(json));
        final Developer developer = this.handleDeveloperObject(reader);

        try {
            reader.close();
        } catch (final IOException ioe) {
            this.logger.error(catching(ioe));
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(developer));
        }

        return developer;
    }

    /// Stream and return the developer object.
    ///
    /// @param  reader  com.google.gson.stream.JsonReader
    /// @return         net.jmp.demo.gson.classes.Developer
    private Developer handleDeveloperObject(final JsonReader reader) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(reader));
        }

        final Developer developer = new Developer();

        try {
            String currentFieldName = null;

            reader.beginObject();

            while (reader.hasNext()) {
                JsonToken token = reader.peek();

                switch (token) {
                    case JsonToken.BEGIN_OBJECT:
                        if ("name".equals(currentFieldName)) {
                            developer.setName(this.handleDeveloperNameObject(reader));
                        }

                        break;
                    case JsonToken.NAME:
                        currentFieldName = reader.nextName();
                        break;
                    case JsonToken.STRING:
                        if ("language".equals(currentFieldName)) {
                            developer.setLanguage(reader.nextString());
                        }
                        break;
                    default:
                        break;
                }
            }

            reader.endObject();
        } catch (final IOException ioe) {
            this.logger.error(catching(ioe));
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(developer));
        }

        return developer;
    }

    /// Stream and return the developer name object.
    ///
    /// @param  reader  com.google.gson.stream.JsonReader
    /// @return         net.jmp.demo.gson.classes.Developer.Name
    private Developer.Name handleDeveloperNameObject(final JsonReader reader) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(reader));
        }

        final Developer.Name name = new Developer.Name();

        try {
            String currentFieldName = null;

            reader.beginObject();

            while (reader.hasNext()) {
                JsonToken token = reader.peek();

                switch (token) {
                    case JsonToken.NAME:
                        currentFieldName = reader.nextName();
                        break;
                    case JsonToken.STRING:
                        if ("first-name".equals(currentFieldName)) {
                            name.setFirstName(reader.nextString());
                        }

                        if ("last-name".equals(currentFieldName)) {
                            name.setLastName(reader.nextString());
                        }

                        break;
                    default:
                        break;
                }
            }

            reader.endObject();
        } catch (final IOException ioe) {
            this.logger.error(catching(ioe));
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(name));
        }

        return name;
    }
}

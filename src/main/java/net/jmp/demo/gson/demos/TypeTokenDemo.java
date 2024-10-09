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

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
            this.logger.info("wrapped: {}", this.toWrappedIntegerObject());
            this.logger.info("object: {}", this.fromWrappedIntegerObject());
            this.logger.info("list: {}", this.toListOfStrings());
            this.logger.info("list: {}", this.fromListOfStrings());
            this.logger.info("list: {}", this.toListOfWrappedIntegers());
            this.logger.info("list: {}", this.fromListOfWrappedIntegers());
            this.logger.info("map: {}", this.toMap());
            this.logger.info("map: {}", this.fromMap());
        }

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

    /// Serialize a wrapped object
    /// to JSON and return it. The
    /// JSON key for a wrapped
    /// object is 'object'.
    ///
    /// @return java.lang.String
    private String toWrappedIntegerObject() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<WrappedObject<Integer>>() {}.getType();
        final WrappedObject<Integer> integer = new WrappedObject<>(12345);
        final String json = gson.toJson(integer, typeToken);

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
    /// @return java.lang.Integer
    private Integer fromWrappedIntegerObject() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<WrappedObject<Integer>>() {}.getType();
        final String json = "{\"object\":12345}";
        final WrappedObject<Integer> wrapped = gson.fromJson(json, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(wrapped.get()));
        }

        return wrapped.get();
    }

    /// Serialize a list of strings
    /// to JSON and return it.
    ///
    /// @return java.lang.String
    private String toListOfStrings() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<List<String>>() {}.getType();
        final List<String> strings = List.of("one", "two", "three", "four", "five");
        final String json = gson.toJson(strings, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Deserialize a list of strings
    /// from JSON and return it.
    ///
    /// @return java.util.List<java.lang.String>
    private List<String> fromListOfStrings() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<List<String>>() {}.getType();
        final String json = "[\"one\",\"two\",\"three\",\"four\",\"five\"]";
        final List<String> list = gson.fromJson(json, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(list));
        }

        return list;
    }

    /// Serialize a list of wrapped integers
    /// to JSON and return it.
    ///
    /// @return java.lang.String
    private String toListOfWrappedIntegers() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<List<WrappedObject<Integer>>>() {}.getType();

        final List<WrappedObject<Integer>> list = List.of(
                WrappedObject.of(1),
                WrappedObject.of(2),
                WrappedObject.of(3),
                WrappedObject.of(4),
                WrappedObject.of(5)
        );

        final String json = gson.toJson(list, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Deserialize a list of wrapped integers
    /// from JSON and return it.
    ///
    /// @return java.util.List<net.jmp.util.extra.WrappedObject<java.lang.Integer>>
    private List<WrappedObject<Integer>> fromListOfWrappedIntegers() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<List<WrappedObject<Integer>>>() {}.getType();
        final String json = "[{\"object\":1},{\"object\":2},{\"object\":3},{\"object\":4},{\"object\":5}]";
        final List<WrappedObject<Integer>> list = gson.fromJson(json, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(list));
        }

        return list;
    }

    /// Serialize a map of integers and
    /// strings to JSON and return it.
    ///
    /// @return java.lang.String
    private String toMap() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<TreeMap<Integer, String>>() {}.getType();
        final Map<Integer, String> map = new TreeMap<>();   // Used to order the key set

        map.put(1, "Ada");
        map.put(2, "Glenn");
        map.put(3, "Jonathan");
        map.put(4, "Timothy");
        map.put(5, "Tweety");

        final String json = gson.toJson(map, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Deserialize a map of integers and
    /// strings from JSON and return it.
    ///
    /// @return java.util.Map<java.lang.Integer, java.lang.String>>
    private Map<Integer, String> fromMap() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Gson gson = new Gson();
        final Type typeToken = new TypeToken<Map<Integer, String>>() {}.getType();
        final String json = "{\"3\":\"Jonathan\",\"2\":\"Glenn\",\"1\":\"Ada\",\"5\":\"Tweety\",\"4\":\"Timothy\"}";
        final Map<Integer, String> map = gson.fromJson(json, typeToken);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(map));
        }

        return map;
    }
}

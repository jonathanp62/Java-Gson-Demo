package net.jmp.demo.gson.demos;

/*
 * (#)ExposeDemo.java   0.7.0   10/12/2024
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

import net.jmp.demo.gson.classes.User;

import net.jmp.util.extra.demo.Demo;
import net.jmp.util.extra.demo.DemoClass;
import net.jmp.util.extra.demo.DemoVersion;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A class that demonstrates the Expose annotation.
///
/// @version    0.7.0
/// @since      0.7.0
@DemoClass
@DemoVersion(0.7)
public final class ExposeDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public ExposeDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        if (this.logger.isInfoEnabled()) {
            this.logger.info("Ignored: {}", this.toJsonIgnoreExpose());
            this.logger.info("Exposed: {}", this.toJson());
            this.logger.info("Exposed: {}", this.fromJson());
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Return a string of JSON representing
    /// the serialized user ignoring the @Expose
    /// annotations.
    ///
    /// @return java.lang.String
    private String toJsonIgnoreExpose() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final User user = new User();

        user.setFirstName("Jonathan");
        user.setLastName("Parker");
        user.setEmailAddress("me@domain.com");
        user.setPassword("my-secret-password");

        final Gson gson = new Gson();
        final String json = gson.toJson(user);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return a string of JSON representing
    /// the serialized user not ignoring the
    /// Expose annotations.
    ///
    /// @return java.lang.String
    private String toJson() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final User user = new User();

        user.setFirstName("Jonathan");
        user.setLastName("Parker");
        user.setEmailAddress("me@domain.com");
        user.setPassword("my-secret-password");

        final GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = gsonBuilder.create();
        final String json = gson.toJson(user);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(json));
        }

        return json;
    }

    /// Return a user object from a JSON representation
    /// of a serialized user not ignoring the Expose
    /// annotations.
    ///
    /// @return net.jmp.demo.gson.classes.User
    private User fromJson() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final String json = "{\"firstName\":\"Jonathan\",\"lastName\":\"Parker\",\"emailAddress\":\"me@domain.com\",\"password\":\"my-secret-password\"}";
        final GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = gsonBuilder.create();
        final User user = gson.fromJson(json, User.class);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(user));
        }

        return user;
    }
}

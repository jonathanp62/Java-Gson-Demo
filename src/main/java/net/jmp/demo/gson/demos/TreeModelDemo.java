package net.jmp.demo.gson.demos;

/*
 * (#)TreeModelDemo.java    0.9.0   10/15/2024
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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.jmp.demo.gson.classes.User;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// A class that demonstrates the Gson tree model.
///
/// @version    0.9.0
/// @since      0.9.0
public final class TreeModelDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public TreeModelDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        if (this.logger.isInfoEnabled()) {
            this.logger.info("user: {}", this.toUser());
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Return a user object from a string of JSON.
    ///
    /// @return net.jmp.demo.gson.classes.User
    private User toUser() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final String json = "{\"firstName\":\"Jonathan\",\"lastName\":\"Parker\",\"emailAddress\":\"me@domain.com\",\"password\":\"secret\"}";
        final JsonElement rootNode = JsonParser.parseString(json);
        final JsonObject object = rootNode.getAsJsonObject();

        final JsonElement firstNameNode = object.get("firstName");
        final JsonElement lastNameNode = object.get("lastName");
        final JsonElement emailAddressNode = object.get("emailAddress");
        final JsonElement passwordNode = object.get("password");

        final User user = new User();

        user.setFirstName(firstNameNode.getAsString());
        user.setLastName(lastNameNode.getAsString());
        user.setEmailAddress(emailAddressNode.getAsString());
        user.setPassword(passwordNode.getAsString());

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(user));
        }

        return user;
    }
}

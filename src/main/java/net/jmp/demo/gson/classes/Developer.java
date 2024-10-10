package net.jmp.demo.gson.classes;

/*
 * (#)Developer.java    0.6.0   10/10/2024
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

import java.util.Objects;

/// The developer class.
///
/// @version    0.6.0
/// @since      0.6.0
public class Developer {
    /// The name.
    private Name name;

    /// The language.
    private String language;

    /// The default constructor.
    public Developer() {
        super();
    }

    /// Get the name.
    ///
    /// @return net.jmp.demo.gson.classes.Developer.Name
    public Name getName() {
        return this.name;
    }

    /// Set the name.
    ///
    /// @param  name    net.jmp.demo.gson.classes.Developer.Name
    public void setName(final Name name) {
        this.name = name;
    }

    /// Get the language.
    ///
    /// @return java.lang.String
    public String getLanguage() {
        return this.language;
    }

    /// Set the language.
    ///
    /// @param  language    java.lang.String
    public void setLanguage(String language) {
        this.language = language;
    }

    /// The equals method.
    ///
    /// @param  o   java.lang.Object
    /// @return     boolean
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Developer developer = (Developer) o;

        return Objects.equals(this.name, developer.name) && Objects.equals(this.language, developer.language);
    }

    /// The hash-code method.
    ///
    /// @return int
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.language);
    }

    /// The to-string method.
    ///
    /// @return java.lang.String
    @Override
    public String toString() {
        return "Developer{" +
                "name=" + this.name +
                ", language='" + this.language + '\'' +
                '}';
    }

    /// The name class.
    public static class Name {
        /// The first name.
        private String firstName;

        /// The last name.
        private String lastName;

        /// The default constructor.
        public Name() {
            super();
        }

        /// Get the first name.
        ///
        /// @return java.lang.String
        public String getFirstName() {
            return this.firstName;
        }

        /// Set the first name.
        ///
        /// @param  firstName   java.lang.String
        public void setFirstName(final String firstName) {
            this.firstName = firstName;
        }

        /// Get the last name.
        ///
        /// @return java.lang.String
        public String getLastName() {
            return this.lastName;
        }

        /// Set the last name.
        ///
        /// @param  lastName    java.lang.String
        public void setLastName(final String lastName) {
            this.lastName = lastName;
        }

        /// The equals method.
        ///
        /// @param  o   java.lang.Object
        /// @return     boolean
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            final Name name = (Name) o;

            return Objects.equals(this.firstName, name.firstName) && Objects.equals(this.lastName, name.lastName);
        }

        /// The hash-code method.
        ///
        /// @return int
        @Override
        public int hashCode() {
            return Objects.hash(this.firstName, this.lastName);
        }

        /// The to-string method.
        ///
        /// @return java.lang.String
        @Override
        public String toString() {
            return "Name{" +
                    "firstName='" + this.firstName + '\'' +
                    ", lastName='" + this.lastName + '\'' +
                    '}';
        }
    }
}

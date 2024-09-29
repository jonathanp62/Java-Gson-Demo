package net.jmp.demo.gson.classes;

/*
 * (#)Member.java   0.2.0   09/29/2024
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

/// An abstract member class.
///
/// @version    0.2.0
/// @since      0.2.0
public abstract class Member {
    /// An enumeration of membership types.
    public enum Type {
        /// Silver.
        SILVER,

        /// Gold.
        GOLD
    }

    /// The type.
    private Type type;

    /// The description.
    private String description;

    /// The name.
    private String name;

    /// The age.
    private int age;

    /// The default constructor.
    protected Member() {
        super();
    }

    /// Get the type.
    ///
    /// @return net.jmp.demo.gson.classes.Member.Type
    public Type getType() {
        return this.type;
    }

    /// Set the type.
    ///
    /// @param  type    net.jmp.demo.gson.classes.Member.Type
    public void setType(final Type type) {
        this.type = type;
    }

    /// Get the description.
    ///
    /// @return java.lang.String
    public String getDescription() {
        return this.description;
    }

    /// Set the description.
    ///
    /// @param  description java.lang.String
    public void setDescription(final String description) {
        this.description = description;
    }

    /// Get the name.
    ///
    /// @return java.lang.String
    public String getName() {
        return this.name;
    }

    /// Set the name.
    ///
    /// @param  name    java.lang.String
    public void setName(final String name) {
        this.name = name;
    }

    /// Get the age.
    ///
    /// @return int
    public int getAge() {
        return this.age;
    }

    /// Set the age.
    ///
    /// @param  age java.lang.String
    public void setAge(final int age) {
        this.age = age;
    }

    /// The equals method.
    ///
    /// @param  o   java.lang.Object
    /// @return     boolean
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Member member = (Member) o;

        return this.age == member.age &&
                this.type == member.type &&
                Objects.equals(this.name, member.name) &&
                Objects.equals(this.description, member.description);
    }

    /// The hash-code method.
    ///
    /// @return int
    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.description, this.name, this.age);
    }

    /// The to-string method.
    ///
    /// @return java.lang.String
    @Override
    public String toString() {
        return "Member{" +
                "type=" + this.type +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", age=" + this.age +
                '}';
    }
}

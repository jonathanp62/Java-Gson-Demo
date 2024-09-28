package net.jmp.demo.gson.classes;

/*
 * (#)Student.java  0.2.0   09/28/2024
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

/// The student class.
///
/// @version    0.2.0
/// @since      0.2.0
public class Student {
    /// The roll number.
    private int rollNo;

    /// The name.
    private String name;

    /// The default constructor.
    public Student() {
        super();
    }

    /// Get the roll number.
    ///
    /// @return int
    public int getRollNo() {
        return this.rollNo;
    }

    /// Set the roll number.
    ///
    /// @param  rollNo  int
    public void setRollNo(final int rollNo) {
        this.rollNo = rollNo;
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

    /// The to-string method.
    ///
    /// @return java.lang.String
    @Override
    public String toString() {
        return "Student[ name = "+name+", roll no: "+rollNo+ "]";
    }

    /// The equals method.
    ///
    /// @param  o   java.lang.Object
    /// @return     boolean
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Student student = (Student) o;

        return this.rollNo == student.rollNo && Objects.equals(this.name, student.name);
    }

    /// The hash-code method.
    ///
    /// @return int
    @Override
    public int hashCode() {
        return Objects.hash(this.rollNo, this.name);
    }
}

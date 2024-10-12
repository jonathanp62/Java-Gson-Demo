package net.jmp.demo.gson.classes;

/*
 * (#)Pet.java  0.7.0   10/12/2024
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

import com.google.gson.annotations.JsonAdapter;

import java.util.Objects;

import net.jmp.demo.gson.adapters.PetAdapter;

/// The pet class. The annotation
/// specified that the PetAdapter
/// Gson type adapter will be used.
///
/// @version    0.7.0
/// @since      0.7.0
@JsonAdapter(PetAdapter.class)
public class Pet {
    /// The name.
    private String name;

    /// The type.
    private String type;

    /// The age.
    private int age;

    /// The default constructor.
    public Pet() {
        super();
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

    /// Get the type.
    ///
    /// @return java.lang.String
    public String getType() {
        return this.type;
    }

    /// Set the type.
    ///
    /// @param  type    java.lang.String
    public void setType(final String type) {
        this.type = type;
    }

    /// Get the age.
    ///
    /// @return int
    public int getAge() {
        return this.age;
    }

    /// Set the age.
    ///
    /// @param  age int
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

        final Pet pet = (Pet) o;

        return this.age == pet.age && Objects.equals(this.name, pet.name) && Objects.equals(this.type, pet.type);
    }

    /// The hash-code method.
    ///
    /// @return int
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.type, this.age);
    }

    /// The to-string method.
    ///
    /// @return java.lang.String
    @Override
    public String toString() {
        return "Pet{" +
                "name='" + this.name + '\'' +
                ", type='" + this.type + '\'' +
                ", age=" + this.age +
                '}';
    }
}

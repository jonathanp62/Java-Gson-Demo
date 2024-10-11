package net.jmp.demo.gson.classes;

/*
 * (#)Person.java   0.7.0   10/11/2024
 * (#)Person.java   0.4.0   10/05/2024
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

import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

import java.util.Objects;

/// The person class.
///
/// @version    0.7.0
/// @since      0.4.0
public class Person {
    /// An enumeration of genders.
    public enum Gender {
        /// Female.
        FEMALE,

        /// Male.
        MALE
    }

    /// The name.
    @Since(0.4)
    private String name;

    /// The address.
    @Since(0.4)
    private String address;

    /// The age.
    @Since(0.4)
    private int age;

    /// The phone number.
    @Since(0.41)
    private String phone;

    /// The gender.
    @Since(0.41)
    private Gender gender;

    /// True when Ronin. This field
    /// is handled up until version
    /// 3.1, exclusive.
    ///
    /// @since  0.7.0
    @Until(0.31)
    private boolean ronin;

    /// The default constructor.
    public Person() {
        super();
    }

    /// Get the name.
    ///
    /// @return java.lang.String
    public String getName() {
        return this.name;
    }

    /// Set the address.
    ///
    /// @param  address java.lang.String
    public void setAddress(final String address) {
        this.address = address;
    }

    /// Get the address.
    ///
    /// @return java.lang.String
    public String getAddress() {
        return this.address;
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
    /// @param  age int
    public void setAge(final int age) {
        this.age = age;
    }

    /// Set the phone number.
    ///
    /// @param  phone   java.lang.String
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /// Get the phone number.
    ///
    /// @return java.lang.String
    public String getPhone() {
        return this.phone;
    }

    /// Get the gender.
    ///
    /// @return net.jmp.demo.gson.classes.Person.Gender
    public Gender getGender() {
        return this.gender;
    }

    /// Set the gender.
    ///
    /// @param  gender  net.jmp.demo.gson.classes.Person.Gender
    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    /// Get the Ronin status.
    ///
    /// @return boolean
    /// @since  0.7.0
    public boolean isRonin() {
        return this.ronin;
    }

    /// Set the Ronin status.
    ///
    /// @param  ronin   boolean
    /// @since          0.7.0
    public void setRonin(final boolean ronin) {
        this.ronin = ronin;
    }

    /// The to-string method.
    ///
    /// @return java.lang.String
    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.name + '\'' +
                ", address='" + this.address + '\'' +
                ", age=" + this.age +
                ", phone='" + this.phone + '\'' +
                ", gender=" + this.gender +
                ", ronin=" + this.ronin +
                '}';
    }

    /// The equals method.
    ///
    /// @param  o   java.lang.Object
    /// @return     boolean
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Person person = (Person) o;

        return this.age == person.age
                && this.gender == person.gender
                && Objects.equals(this.address, person.address)
                && Objects.equals(this.phone, person.phone)
                && Objects.equals(this.name, person.name)
                && this.ronin == person.ronin;
    }

    /// The hash-code method.
    ///
    /// @return int
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.address, this.age, this.phone, this.gender, this.ronin);
    }
}

package net.jmp.demo.gson.classes;

/*
 * (#)User.java 0.7.0   10/12/2024
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

import com.google.gson.annotations.Expose;

import java.util.Objects;

/// The user class.
///
/// If you created Gson with new Gson(), the toJson() and fromJson()
/// methods will use the password field along-with firstName, lastName,
/// and emailAddress for serialization and deserialization. However, if
/// you created Gson with Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
/// then the toJson() and fromJson() methods of Gson will exclude the password
/// field. This is because the password field is not marked with the @Expose
/// annotation. Gson will also exclude lastName and emailAddress from serialization
/// since serialize is set to false. Similarly, Gson will exclude emailAddress
/// from deserialization since deserialize is set to false.
///
/// @version    0.7.0
/// @since      0.7.0
public class User {
    /// The first name.
    @Expose
    private String firstName;

    /// The last name.
    @Expose(serialize = false)
    private String lastName;

    /// The email address.
    @Expose(serialize = false, deserialize = false)
    private String emailAddress;

    /// The password.
    private String password;

    /// The default constructor.
    public User() {
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

    /// Get the email address.
    ///
    /// @return java.lang.String
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /// Set the email address.
    ///
    /// @param  emailAddress    java.lang.String
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /// Get the password.
    ///
    /// @return java.lang.String
    public String getPassword() {
        return this.password;
    }

    /// Set the password.
    ///
    /// @param  password    java.lang.String
    public void setPassword(final String password) {
        this.password = password;
    }

    /// The equals method.
    ///
    /// @param  o   java.lang.Object
    /// @return     boolean
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final User user = (User) o;

        return Objects.equals(this.firstName, user.firstName) && Objects.equals(this.lastName, user.lastName) && Objects.equals(this.emailAddress, user.emailAddress) && Objects.equals(this.password, user.password);
    }

    /// The hash-code method.
    ///
    /// @return int
    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName, this.emailAddress, this.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", emailAddress='" + this.emailAddress + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }
}

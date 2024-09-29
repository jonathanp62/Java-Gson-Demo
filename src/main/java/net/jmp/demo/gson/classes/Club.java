package net.jmp.demo.gson.classes;

/*
 * (#)Club.java 0.2.0   09/29/2024
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

import java.util.ArrayList;
import java.util.List;

/// A club class.
///
/// @version    0.2.0
/// @since      0.2.0
public class Club {
    /// The name.
    private final String name;

    /// The list of members.
    private final List<Member> members;

    /// The default constructor.
    public Club() {
        super();

        this.name = "My Club";
        this.members = new ArrayList<>();
    }

    /// Add a member.
    ///
    /// @param  member  net.jmp.demo.gson.classes.Member
    public void addMember(final Member member) {
        this.members.add(member);
    }

    /// Return the name.
    ///
    /// @return java.lang.String
    public String getName() {
        return this.name;
    }

    /// Return the list of members.
    ///
    /// @return java.util.List<net.jmp.demo.gson.classes.Member>
    public List<Member> getMembers() {
        return this.members;
    }

    /// The to-string method.
    ///
    /// @return java.lang.String
    @Override
    public String toString() {
        return "Club{" +
                "name='" + this.name + '\'' +
                ", members=" + this.members +
                '}';
    }
}

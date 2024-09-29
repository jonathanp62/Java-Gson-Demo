package net.jmp.demo.gson.adapters;

/*
 * (#)MemberSerializer.java 0.2.0   09/29/2024
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
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import net.jmp.demo.gson.classes.GoldMember;
import net.jmp.demo.gson.classes.Member;
import net.jmp.demo.gson.classes.SilverMember;

/// A member serializer.
///
/// @version    0.2.0
/// @since      0.2.0
public final class MemberSerializer implements JsonSerializer<Member> {
    /// The default constructor.
    public MemberSerializer() {
        super();
    }

    /// Serialize a member.
    ///
    /// @param  member  net.jmp.demo.gson.classes.Member
    /// @param  type    java.lang.reflect.Type
    /// @param  context com.google.gson.JsonSerializationContext
    /// @return         com.google.gson.JsonElement
    @Override
    public JsonElement serialize(final Member member, final Type type, final JsonSerializationContext context) {
        return switch (member.getType()) {
            case Member.Type.SILVER -> context.serialize((SilverMember) member);
            case Member.Type.GOLD -> context.serialize((GoldMember) member);
            default -> null;
        };
    }
}

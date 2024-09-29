package net.jmp.demo.gson.adapters;

/*
 * (#)MemberDeserializer.java   0.2.0   09/29/2024
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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;

import net.jmp.demo.gson.classes.GoldMember;
import net.jmp.demo.gson.classes.Member;
import net.jmp.demo.gson.classes.SilverMember;

/// A member deserializer.
///
/// @version    0.2.0
/// @since      0.2.0
public final class MemberDeserializer implements JsonDeserializer<Member> {
    /// The default constructor
    public MemberDeserializer() {
        super();
    }

    /// Deserialize a member.
    ///
    /// @param  json    com.google.gson.JsonElement
    /// @param  type    java.lang.reflect.Type
    /// @param  context com.google.gson.JsonDeserializationContext
    /// @return         net.jmp.demo.gson.classes.Member
    @Override
    public Member deserialize(final JsonElement json, final Type type, final JsonDeserializationContext context) {
        final String memberType = json.getAsJsonObject().get("type").getAsString();

        return switch (memberType) {
            case "SILVER" -> context.deserialize(json, SilverMember.class);
            case "GOLD" -> context.deserialize(json, GoldMember.class);
            default -> null;
        };
    }
}

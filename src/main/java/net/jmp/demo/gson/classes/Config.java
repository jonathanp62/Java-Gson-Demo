package net.jmp.demo.gson.classes;

/*
 * (#)Main.java 0.10.0  10/15/2024
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

import java.util.List;
import java.util.Objects;

/// The configuration class as represented by config.json.
///
/// @version    0.10.0
/// @since      0.10.0
public class Config {
    /// The highest versioned demo class to run.
    private double version;

    /// The list of demo classes.
    private List<String> demos;

    /// The default constructor.
    public Config() {
        super();
    }

    /// Return the highest versioned demo class to run.
    ///
    /// @return double
    public double getVersion() {
        return this.version;
    }

    /// Set the highest versioned demo class to run.
    ///
    /// @param  version double
    public void setVersion(final double version) {
        this.version = version;
    }

    /// Return the list of demo classes.
    ///
    /// @return java.util.List<net.jmp.demo.gson.classes.Config>
    public List<String> getDemos() {
        return this.demos;
    }

    /// Set the list of demo classes.
    ///
    /// @param  demos   java.util.List<net.jmp.demo.gson.classes.Config>
    public void setDemos(final List<String> demos) {
        this.demos = demos;
    }

    /// The equals method.
    ///
    /// @param  o   java.lang.Object
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Config config = (Config) o;

        return Double.compare(this.version, config.version) == 0 && Objects.equals(this.demos, config.demos);
    }

    /// The hash-code method.
    ///
    /// @return int
    @Override
    public int hashCode() {
        return Objects.hash(this.version, this.demos);
    }

    /// The to-string method.
    ///
    /// @return java.lang.String
    @Override
    public String toString() {
        return "Config{" +
                "version=" + this.version +
                ", demos=" + this.demos +
                '}';
    }
}

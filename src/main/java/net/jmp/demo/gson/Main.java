package net.jmp.demo.gson;

/*
 * (#)Main.java 0.10.0  10/15/2024
 * (#)Main.java 0.9.0   10/15/2024
 * (#)Main.java 0.8.0   10/13/2024
 * (#)Main.java 0.7.0   10/12/2024
 * (#)Main.java 0.6.0   10/10/2024
 * (#)Main.java 0.5.0   10/06/2024
 * (#)Main.java 0.4.0   10/05/2024
 * (#)Main.java 0.3.0   10/01/2024
 * (#)Main.java 0.2.0   09/28/2024
 * (#)Main.java 0.1.0   09/28/2024
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

import com.google.gson.Gson;

import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.Objects;

import net.jmp.demo.gson.classes.Config;

import net.jmp.demo.gson.demos.*;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The main class.
///
/// @version    0.10.0
/// @since      0.1.0
final class Main implements Runnable {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The command line arguments.
    private final String[] arguments;

    /// A constructor that takes the
    /// command line arguments from
    /// the bootstrap class.
    ///
    /// @param  args    java.lang.String[]
    Main(final String[] args) {
        super();

        this.arguments = Objects.requireNonNull(args);
    }

    /// The run method.
    @Override
    public void run() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        this.greeting();

        try {
            final var config = this.loadConfiguration();

            this.runDemos(config);
        } catch (final Exception e) {
            this.logger.error(catching(e));
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Log the greeting.
    private void greeting() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        if (this.arguments.length == 0) {
            if (this.logger.isDebugEnabled()) { // Covers trace, too
                this.logger.debug("{} {}", Name.NAME_STRING, Version.VERSION_STRING);
            } else if (this.logger.isInfoEnabled() || this.logger.isWarnEnabled()) {
                this.logger.info("{} {}", Name.NAME_STRING, Version.VERSION_STRING);
            } else {    // Error or off
                System.out.format("%s %s%n", Name.NAME_STRING, Version.VERSION_STRING);
            }
        } else {
            if (this.logger.isDebugEnabled()) { // Covers trace, too
                this.logger.debug("{} {}: {}", Name.NAME_STRING, Version.VERSION_STRING, this.arguments);
            } else if (this.logger.isInfoEnabled() || this.logger.isWarnEnabled()) {
                this.logger.info("{} {}: {}", Name.NAME_STRING, Version.VERSION_STRING, this.arguments);
            } else {    // Error or off
                System.out.format("%s %s: %s%n", Name.NAME_STRING, Version.VERSION_STRING, Arrays.toString(this.arguments));
            }
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// Load the application configuration
    ///
    /// @return net.jmp.demo.gson.classes.Config
    /// @throws java.io.IOException When an I/O error occurs reading the configuration file
    private Config loadConfiguration() throws IOException {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        Config config = null;

        final String appConfigFileName = System.getProperty("app.config", "config/config.json");
        final Gson gson = new Gson();

        try (final JsonReader reader = new JsonReader(new FileReader(appConfigFileName))) {
            config = gson.fromJson(reader, Config.class);
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(config));
        }

        return config;
    }

    /// Run the demonstration classes.
    ///
    /// @param  config  net.jmp.demo.gson.classes.Config
    private void runDemos(final Config config) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(config));
        }

        final String packageName = config.getPackageName();

        config.getDemosAsStream().forEach(demo -> {
            try {
                final Class<?> clazz = Class.forName(packageName + "." + demo);
                final Demo instance = (Demo) clazz.getDeclaredConstructor().newInstance();
                final Method method = clazz.getDeclaredMethod("demo");

                if (clazz.isAnnotationPresent(net.jmp.demo.gson.annotations.Version.class)) {
                    final var version = clazz.getAnnotation(net.jmp.demo.gson.annotations.Version.class);
                    final var versionValue = version.value();

                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("Class {} annotated with @Version({})", clazz.getSimpleName(), versionValue);
                    }

                    if (config.getVersion() >= versionValue) {
                        method.invoke(instance);
                    }
                } else {
                    method.invoke(instance);
                }
            } catch (final ClassNotFoundException | InstantiationException | IllegalAccessException |
                           NoSuchMethodException | InvocationTargetException e) {
                this.logger.error(catching(e));
            }
        });

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }
}

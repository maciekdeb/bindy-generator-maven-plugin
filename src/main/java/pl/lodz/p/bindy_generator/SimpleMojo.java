package pl.lodz.p.bindy_generator;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 *
 * @deprecated Don't use!
 */
@Mojo(name = "hello", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class SimpleMojo extends AbstractMojo {

    @Parameter(defaultValue = "john", property = "name", required = true)
    private String name;

    public void execute() throws MojoExecutionException {
        getLog().info("Hello " + name);
        getLog().debug("Hello " + name);
        getLog().error("Hello " + name);
    }
}

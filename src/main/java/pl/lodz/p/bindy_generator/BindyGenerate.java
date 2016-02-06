package pl.lodz.p.bindy_generator;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Goal which touches a timestamp file.
 *
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class BindyGenerate extends AbstractMojo {

    @Parameter(defaultValue = "john", property = "name", required = true)
    private String name;

    public void execute() throws MojoExecutionException {
    }
}

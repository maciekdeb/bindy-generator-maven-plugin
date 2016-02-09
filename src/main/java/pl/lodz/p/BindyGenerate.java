package pl.lodz.p;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.util.List;

/**
 * Goal which uses bindy-generator to prepare java classes
 *
 * @author maciek
 * @goal generate
 */
public class BindyGenerate extends AbstractMojo {

    private static final String SPACE = " ";

    /**
     * @parameter default-value="${project.build.sourceDirectory}"
     */
    private String outputDirectory;

    /**
     * @parameter default-value="${groupId}"
     */
    private String packageName;

    /**
     * @parameter
     * @required
     */
    private List<File> files;

    public void execute() throws MojoExecutionException {
        getLog().info("Bindy Generator Maven Plugin started");
        BindyGeneratorApp bindyGeneratorApp = new BindyGeneratorApp();
        try {
            for (File file : files) {
                getLog().info("Generating model for " + file.getFileName());
                bindyGeneratorApp.generate(createArguments(file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] createArguments(File file) {
        StringBuilder arguments = new StringBuilder();
        arguments.append("-f").append(SPACE).append(file.getFileName());
        arguments.append("-c").append(SPACE).append(packageName);
        arguments.append(SPACE).append(file.toString());
        return arguments.toString().trim().split(SPACE);
    }

}

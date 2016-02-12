package pl.lodz.p;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.util.Arrays;
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
    private String outputDir;

    /**
     * @parameter default-value="${project.groupId}."
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
                String[] arguments = createArguments(file);
                getLog().info("Using the following arguments list " + Arrays.toString(arguments));
                bindyGeneratorApp.generate(arguments);
                getLog().info("Java class model " + packageName + file.getClassName() + " is ready for file " + file.getFileName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] createArguments(File file) {
        StringBuilder arguments = new StringBuilder();
        arguments.append("-f").append(SPACE).append(file.getFileName()).append(SPACE);
        arguments.append("-p").append(SPACE).append(outputDir).append(SPACE);
        arguments.append("-c").append(SPACE).append(packageName).append(file.getClassName()).append(SPACE);
        arguments.append(SPACE).append(file.toString()).append(SPACE);

        if (file instanceof Csv) {
            Csv csvFile = (Csv) file;
            arguments.append("-s").append(SPACE).append(csvFile.getSeparator()).append(SPACE);
        }

        return arguments.toString().trim().split(SPACE);
    }

}

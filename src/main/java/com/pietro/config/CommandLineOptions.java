package com.pietro.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.internal.Lists;

@Configuration
public class CommandLineOptions {
    @Parameter(description = "file1 file2")
    public List<String> parameters = Lists.newArrayList();

    @Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
    public Integer verbose = 1;

    @Parameter(names = { "--help" }, description = "Show command line options")
    public boolean showHelp;
    
    /**
     * Invoked by SpringBootConsoleApplication. If false is returned, the app shows the usage and quits.
     * @return
     */
    public boolean validate() {
        return parameters.size() == 0;  // TODO: put here any logic to validate the configuration
    }
}

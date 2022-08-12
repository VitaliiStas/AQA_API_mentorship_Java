package tasks_for_matrix.xml_task;

import com.fasterxml.jackson.annotation.JsonProperty;
import groovyjarjarantlr4.v4.runtime.RuleDependencies;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)

public class InputOutputXML {

//    public Dependency dependency;
    public Dependencies dependencies;

    public Dependencies getDependencies() {
        return dependencies;
    }

    public void setDependencies(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public InputOutputXML() {
    }
}

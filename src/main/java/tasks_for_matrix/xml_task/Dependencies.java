package tasks_for_matrix.xml_task;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class Dependencies {


@JacksonXmlElementWrapper(useWrapping = false)
     List<Dependency> dependency = new ArrayList<>();

    public List<Dependency> getDependency() {
        return dependency;
    }

    public void setDependency(List<Dependency> value) {
        this.dependency = value;
    }
}

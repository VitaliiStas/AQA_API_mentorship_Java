package tasks_for_matrix.xml_task;

import java.util.List;

public class Dependencies {
    List<DependencyNode> dependency;

    public Dependencies() {
    }

    public List<DependencyNode> getDependency() {
        return dependency;
    }

    public void setDependency(List<DependencyNode> dependency) {
        this.dependency = dependency;
    }
}

package tasks_for_matrix.xml_task;

public class Dependency {
        DependencyNode dependency;
        @Override
        public String toString() {
            return "Dependency{" +
                    "groupId='" + groupId + '\'' +
                    ", artifactId='" + artifactId + '\'' +
                    ", version='" + version + '\'' +
                    ", scope='" + scope + '\'' +
                    '}';
        }

        public String groupId;
        public String artifactId;
        public String version;
        public String scope;


        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getArtifactId() {
            return artifactId;
        }

        public void setArtifactId(String artifactId) {
            this.artifactId = artifactId;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

}

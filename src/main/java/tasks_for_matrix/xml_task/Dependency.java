package tasks_for_matrix.xml_task;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Dependency {

        @JacksonXmlProperty(localName = "groupId")
    String groupID;
        @JacksonXmlProperty(localName = "artifactId")
    String artifactID;
        @JacksonXmlProperty(localName = "version")
    String version;
        @JacksonXmlProperty(localName = "scope")
    String scope;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String value) {
        this.groupID = value;
    }

    public String getArtifactID() {
        return artifactID;
    }

    public void setArtifactID(String value) {
        this.artifactID = value;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String value) {
        this.scope = value;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "groupID='" + groupID + '\'' +
                ", artifactID='" + artifactID + '\'' +
                ", version='" + version + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}

package tasks_for_matrix.xml_task;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class SerializeDesirealizeNew {

    public static void main(String[] args) throws IOException, NoSuchFieldException{
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        Dependencies dependencyObj = mapper.readValue(new File("src/main/resources/input.xml"),Dependencies.class);

        System.out.println(dependencyObj.getDependency().get(0));
//        System.out.println(inputOutputXML);

        dependencyObj.getDependency().get(0).setGroupID("AAAAAAAAAAAAAAAAAAAA");
        dependencyObj.getDependency().get(1).setArtifactID("AAAAAAAAAAAAAAAAAAAA");
        dependencyObj.getDependency().get(2).setScope("AAAAAAAAAAAAAAAAAAAA");
        dependencyObj.getDependency().get(3).setVersion("AAAAAAAAAAAAAAAAAAAA");
        mapper.writeValue(new File("src/main/resources/output.xml"),dependencyObj);


    }
}



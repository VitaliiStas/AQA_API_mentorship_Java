package tasks_for_matrix.xml_task;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class SerializeDesirealize {

    public static void main(String[] args) throws IOException, NoSuchFieldException{
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        InputOutputXML inputOutputXML = mapper.readValue(new File("src/main/resources/input.xml"),InputOutputXML.class);

        System.out.println(inputOutputXML.dependencies);
//        System.out.println(inputOutputXML);

//        inputOutputXML.dependency.setGroupId("AAAAAAAAAAAAAAAAAAAA");
//        inputOutputXML.dependency.setArtifactId("AAAAAAAAAAAAAAAAAAAA");
//        inputOutputXML.dependency.setScope("AAAAAAAAAAAAAAAAAAAA");
//        inputOutputXML.dependency.setVersion("AAAAAAAAAAAAAAAAAAAA");
        mapper.writeValue(new File("src/main/resources/output.xml"),inputOutputXML);


    }
}



package xml;

import groupJAXB.Group;
import groupJAXB.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Xml {
    private Group group;
    private String inputFilepath;
    private String outputFilepath;

    public Xml(String inputFilepath, String outputFilepath){
        this.inputFilepath = inputFilepath;
        this.outputFilepath = outputFilepath;
        System.setProperty("javax.xml.accessExternalDTD", "all");
        Unmarshal();
    }

    public void correct(){
        for(Student student : group.getStudent()){
            float average = student.countAverage();
            if(student.getAverage() != average){
                System.out.println("Student " + student.getFirstname() + " " + student.getLastname()
                + " was corrected from " + student.getAverage() + " to " + average);
                student.setAverage(average);
            }
        }
        Marshal();
    }

    private void Unmarshal(){
        try {
            JAXBContext context = JAXBContext.newInstance(Group.class);
            InputStream is = new FileInputStream(inputFilepath);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            group = (Group) unmarshaller.unmarshal(is);
            is.close();
        }
        catch (JAXBException e) {e.printStackTrace();}
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }

    private void Marshal(){
        try {
            JAXBContext context = JAXBContext.newInstance(Group.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            OutputStream os = new FileOutputStream(outputFilepath);
            marshaller.marshal(group, os);
            os.close();
        }
        catch (JAXBException e) {e.printStackTrace();}
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }
}

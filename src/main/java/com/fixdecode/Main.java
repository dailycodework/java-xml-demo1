package com.fixdecode;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JAXBException {
        StudentXmlList studentXmlList = new StudentXmlList();
        studentXmlList.setStudents(new ArrayList<>());
        Student student1 = new Student(1, "Anita","anita@email.com");
        Student student2 = new Student(2, "Sam","sama@email.com");
        Student student3 = new Student(3, "Jessica","jes@email.com");
        Student student4 = new Student(4, "Tony","tony@email.com");

        studentXmlList.getStudents().add(student1);
        studentXmlList.getStudents().add(student2);
        studentXmlList.getStudents().add(student3);
        studentXmlList.getStudents().add(student4);


        Student student = new Student(1, "Anita","anita@email.com");
        convertToXml(student);

        saveStudentToXmlFile(student);

        saveStudentListToXmlFile(studentXmlList);

    }
 // Print the student to the console
    private static void convertToXml(Student student) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(student, stringWriter);
        String xmlContent = stringWriter.toString();
        System.out.println(xmlContent);
    }

    // Save the student to Xml file
    private static void saveStudentToXmlFile(Student student) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("student.xml");
        marshaller.marshal(student, file);

    }
    // Save a list of students to Xml file
    private static void saveStudentListToXmlFile(StudentXmlList studentXmlList) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(StudentXmlList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("students.xml");
        marshaller.marshal(studentXmlList, file);
    }


}

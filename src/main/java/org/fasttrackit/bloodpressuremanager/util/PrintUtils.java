package org.fasttrackit.bloodpressuremanager.util;

import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;

import java.util.List;

public class PrintUtils {

    public static void printBloodPressureDtoList(List<BloodPressureDTO> userBloodPressuresList) {
        //print the lis with blood pressures dto
        System.out.println("*********** Blood Pressures list ***************");
        for (int i = 0; i < userBloodPressuresList.size(); i++) {
            System.out.println("Blood Pressure measurement " + i + 1);
            System.out.print(userBloodPressuresList.get(i).getIdBP());
            System.out.print("  "+userBloodPressuresList.get(i).getDateBP());
            System.out.print("  "+userBloodPressuresList.get(i).getDiastolicBP());
            System.out.print("  "+userBloodPressuresList.get(i).getSystolicBP());
            System.out.print("  "+userBloodPressuresList.get(i).getPulseBP());
            System.out.println("  "+userBloodPressuresList.get(i).getNotesBP());
            System.out.println("--------------");
        }

        System.out.println("*****************");
    }

    public static void printBloodPressureDto(BloodPressureDTO bloodPressureToPrint) {
        //print a blood pressures dto
        System.out.println("*********** Blood Pressures ***************");

        System.out.println("Blood Pressure measurement ");
        System.out.println(bloodPressureToPrint.getIdBP());
        System.out.println(bloodPressureToPrint.getDateBP());
        System.out.println(bloodPressureToPrint.getDiastolicBP());
        System.out.println(bloodPressureToPrint.getSystolicBP());
        System.out.println(bloodPressureToPrint.getPulseBP());
        System.out.println(bloodPressureToPrint.getNotesBP());
        System.out.println("--------------");

        System.out.println("*****************");
    }

    public static void printUserNameAndId(UserDTO userToFind) {
        //print user Name and Id
        System.out.println("*********** User name and id ************");
        System.out.println(userToFind.getIdUser());
        System.out.println(userToFind.getUserName());
        System.out.println("***********************");
    }
}

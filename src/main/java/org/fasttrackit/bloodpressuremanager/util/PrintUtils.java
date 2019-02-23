package org.fasttrackit.bloodpressuremanager.util;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;

import java.util.List;

public class PrintUtils {

    public static void printBloodPressureDtoList(List<BloodPressureDTO> userBloodPressuresList) {
        //print the lis with blood pressures dto
        System.out.println("*********** Blood Pressures list ***************");
        for (int i = 0; i < userBloodPressuresList.size(); i++) {
            System.out.println("Blood Pressure measurement " + i + 1);
            System.out.println(userBloodPressuresList.get(i).getIdBPDto());
            System.out.println(userBloodPressuresList.get(i).getDateBPDto());
            System.out.println(userBloodPressuresList.get(i).getDiastolicBPDto());
            System.out.println(userBloodPressuresList.get(i).getSystolicBPDto());
            System.out.println(userBloodPressuresList.get(i).getPulseBPDto());
            System.out.println(userBloodPressuresList.get(i).getNotesBPDto());
            System.out.println("--------------");
        }

        System.out.println("*****************");
    }

    public static void printBloodPressureDto(BloodPressure bloodPressure) {
        //print a blood pressures dto
        System.out.println("*********** Blood Pressures ***************");

            System.out.println("Blood Pressure measurement ");
            System.out.println(bloodPressure.getIdBP());
            System.out.println(bloodPressure.getDateBP());
            System.out.println(bloodPressure.getDiastolicBP());
            System.out.println(bloodPressure.getSystolicBP());
            System.out.println(bloodPressure.getPulseBP());
            System.out.println(bloodPressure.getNotesBP());
            System.out.println("--------------");


        System.out.println("*****************");
    }

    public static void printUserNameAndId(UserDTO userToFind) {
        //print user Name and Id
        System.out.println("*********** User name and id ************");
        System.out.println(userToFind.getIdUserDto());
        System.out.println(userToFind.getUserNameDto());
        System.out.println("***********************");
    }
}

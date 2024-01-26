package com.u2team.huansync.activity.cosplay.managementQualification.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        QualificationDaoImp qualifications = new QualificationDaoImp();

    
        List<Integer> calificaciones = new ArrayList<>(Arrays.asList(3, 3, 3));
        qualifications.send(1,calificaciones);


    }

}

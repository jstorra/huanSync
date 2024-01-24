package com.u2team.huansync.activity.cosplay.managementQualification.model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        QualificationDao qd = new QualificationDao();

        List<Integer> cl =new ArrayList<>();
        cl.add(1);
        cl.add(2);

        //List<Qualification> assCalif = qd.asignCalificacion(1, cl);

        List<Qualification> assCalif = qd.listJugesCalification(1);


        for(Qualification i :assCalif){
            System.out.println(i.toString());
        }



    }

}

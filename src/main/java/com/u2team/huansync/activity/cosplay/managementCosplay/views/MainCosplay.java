
package com.u2team.huansync.activity.cosplay.managementCosplay.views;

import java.sql.SQLException;
import java.util.Scanner;

import com.u2team.huansync.activity.cosplay.managementCosplay.Controller.ControllerMagnamentCosplay;
import com.u2team.huansync.activity.cosplay.managementCosplay.model.Cosplay;

public class MainCosplay {

    private Scanner scanner = new Scanner(System.in);
    private ControllerMagnamentCosplay controller = new ControllerMagnamentCosplay();

    /*------------------------------MENU PRINCIPAL----------------------------------*/

    public void menuPrincipal() {
        while (true) {
            System.out.println("""
                    1 - listar cosplays
                    2 - agregar cosplay
                    3 - modificar cosplay
                    4 - eliminar cosplay
                    5 - salir
                    """);
            System.out.print("\nIngresa una opcion: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            if (op == 1) {
                this.menulistar();
            }

            if (op == 2) {
                this.menuAgregar();
            }

            if (op == 3) {
                this.menuModificar();
            }

            if (op == 4) {
                this.menuEliminar();
            }

            if (op == 5)
                break;
        }
    }

    /*
     * /////////////////////////////////////////////////////////////////////////////
     * ////////////////////////////////////////
     */

    /*------------------------------MENU CATEGORIAS----------------------------------*/

    public void menulistar() {
        for (Cosplay i : controller.readAllCosplays()) {
            System.out.println(i.toString());
        }

    }

    public void menuAgregar() {

        System.out.print("\nIngresa el nombre del cosplay : ");
        String nombreCosplay = scanner.nextLine();

        System.out.print("\nIngresa el id del participante : ");
        int idParticipant = scanner.nextInt();

        System.out.print("\nIngresa el id de la actividad : ");
        int idActivicty = scanner.nextInt();

        controller.addCosplay(nombreCosplay, idParticipant, idActivicty);

    }

    public void menuModificar() {

        System.out.print("\nIngresa el id del cosplay a modificar : ");
        int idParticipant = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nIngresa el nuevo nombre del cosplay : ");
        String nombreCosplay = scanner.nextLine();

        controller.updateCosplay(idParticipant, nombreCosplay);

    }

    public void menuEliminar() {

        System.out.print("\nIngresa el id del cosplay a iliminar : ");
        int idCosplay = scanner.nextInt();

        controller.deleteCosplay(idCosplay);

    }

    public static void main(String[] args) {
        MainCosplay mainCosplay = new MainCosplay();
        try {
            mainCosplay.menuPrincipal();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

}

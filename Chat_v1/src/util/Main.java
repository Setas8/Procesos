package util;

import clases.MarcoChat;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;


public class Main {

    static Set<String> nombresUsuarios = new HashSet<>();
    public static void main(String[] args) {



        String nombreUsuario = "";
        do{
            nombreUsuario = JOptionPane.showInputDialog("Escribe tu nick");
        } while(!addUsuarios(nombreUsuario));



        //MarcoChat m = new MarcoChat(nombreUsuario);


    }
    private  static boolean addUsuarios(String nombre) {

        boolean insertado = false;
        if (nombresUsuarios.add(nombre))
            insertado = true;

        return insertado;
    }
}



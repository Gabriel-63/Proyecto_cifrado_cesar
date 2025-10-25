package com.mycompany.cifrado;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class  Cifrado{

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String op, op1;
        System.out.println("¿Desea cifrar o descifrar?");
        System.out.println("Cifrar [C] - Descifrar [D]");
        op = lector.next().toUpperCase();
        do {
            switch (op) {
                case "C": {
                    Cifrar();
                    break;
                }
                case "D": {
                    Descifrar();
                    break;
                }
                default:
                    System.out.println("Opción no válida ingrese: Cifrar [C] o Descifrar [D] .");
                    break;
            }
            System.out.println("Quiere salir del programa?");
            op1 = lector.next().toUpperCase();
            if (op1.equals("NO")) {
                System.out.println("¿Desea cifrar o descifrar?");
                System.out.println("Cifrar [C] - Descifrar [D]");
                op = lector.next().toUpperCase();
            }
        } while (op1.equals("NO"));
    }

    public static void Cifrar() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el texto que quiere cifrar");
        String txt = lector.nextLine();
        System.out.println("Ingrese la clave para cifrar");
        int cl = lector.nextInt();
        StringBuilder txtC = new StringBuilder();
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (Character.isUpperCase(c)) {
                char cif = (char) ((c +(cl-65)) % 26 + 65);
                txtC.append(cif);
            }else if (Character.isLowerCase(c)){
            char cif = (char)(((c +(cl-97)) % 26) + 97);
            txtC.append(cif);     
            }else {
                txtC.append(c); 
            }
        }
        System.out.println("El texto cifrado es " + txtC);
        guardado(txt,txtC);
    }

    public static void Descifrar() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el texto que quiere descifrar:");
        String txt = lector.nextLine();
        System.out.println("Ingrese la clave para cifrar");
        int cl = lector.nextInt();
        StringBuilder txtC = new StringBuilder();
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (Character.isUpperCase(c)) {     
                char des = (char) ((c -(cl-65)) % 26 + 65);
                txtC.append(des);
            }else if (Character.isLowerCase(c)){
            char cif = (char)(((c - (cl+97)) % 26) + 97);
            txtC.append(cif);  
            }else {
                txtC.append(c);
            }
        }
        System.out.println("El texto descifrado es " + txtC);
        guardado(txt,txtC);
    }
    
    public static void guardado(String original, StringBuilder txtC){
        try(FileWriter file=new FileWriter("Datos.txt",true)){
            file.write(original+"   \t"+txtC+"\n");
        }catch(IOException e){
            System.out.println("Error al guardar el archivo "+e);
        }
            
    }
}

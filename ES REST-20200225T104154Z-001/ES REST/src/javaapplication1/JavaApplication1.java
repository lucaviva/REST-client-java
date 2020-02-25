package javaapplication1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author informatica
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        String swi;
        int n, idn;
        String nome ;
        String cognome;
        String mail;
        String telefono;
        String id;
        String idCerca;
        
        do{
            System.out.println("1 GET Tutti");
            System.out.println("2 POST");
            System.out.println("3 DELETE");
            System.out.println("4 GET uno solo");
            System.out.println("5 PUT");
            System.out.println("0 Fin");
            System.out.print("Inserisci il primo numero: ");
            System.out.println("");
            Scanner scan = new Scanner(System.in);
            swi = scan.next();
            n = Integer.parseInt(swi);
        
        
            switch(n){
                case 1:
                    try {

                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Accept", "application/json");

                        if (conn.getResponseCode() != 200) {
                                throw new RuntimeException("Failed : HTTP error code : "
                                                + conn.getResponseCode());
                        }

                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                (conn.getInputStream())));

                        String output;
                        System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {
                                System.out.println(output);
                        }

                        conn.disconnect();

                    }
                    catch (MalformedURLException e) {

                    e.printStackTrace();

                    } catch (IOException e) {

                    e.printStackTrace();

                    }
                    break;

                case 2:
                    System.out.println("Id: ");
                    scan = new Scanner(System.in);
                    id = scan.next();
                    idn = Integer.parseInt(id);
                    
                    
                    
                    System.out.println("Nome: ");
                    scan = new Scanner(System.in);
                    nome = scan.next();
                    
                    System.out.println("Cognome: ");
                    scan = new Scanner(System.in);
                    cognome = scan.next();
                    
                    System.out.println("Email: ");
                    scan = new Scanner(System.in);
                    mail = scan.next();
                    
                    System.out.println("Telefono: ");
                    scan = new Scanner(System.in);
                    telefono = scan.next();

                    try {

                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setDoOutput(true);
                        conn.setRequestMethod("POST");
                        conn.setRequestProperty("Content-Type", "application/json");

                        String input = "{ \"employeeId\":"+idn+", \"firstName\": \""+nome+"\", \"lastName\": \""+cognome+"\",\"email\": \""+mail+"\",\"phone\": \""+telefono+"\" }";

                        OutputStream os = conn.getOutputStream();
                        os.write(input.getBytes());
                        os.flush();

                        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                                throw new RuntimeException("Failed : HTTP error code : "
                                        + conn.getResponseCode());
                        }

                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                        (conn.getInputStream())));

                        String output;

                        conn.disconnect();
                    } 
                    catch (MalformedURLException e) {
                    e.printStackTrace();
                    }

                    catch (IOException e) {
                    e.printStackTrace();
                    }

                    break;

                case 3:
                    System.out.print("Inserisci l'id dell'impiegato da cancellare: ");
                    System.out.println();
                    scan = new Scanner(System.in);
                    idCerca = scan.next();

                    try {
                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/" + idCerca);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("DELETE");
                        conn.setRequestProperty("Accept", "application/json");

                        if (conn.getResponseCode() != 200) {
                                throw new RuntimeException("Failed : HTTP error code : "
                                                + conn.getResponseCode());
                        }

                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                (conn.getInputStream())));

                        String output;
                        System.out.println("Output from Server .... \n");
                        while ((output = br.readLine()) != null) {
                                System.out.println(output);
                        }

                        conn.disconnect();

                    }

                    catch (MalformedURLException e) {
                    e.printStackTrace();
                    }

                    catch (IOException e) {
                    e.printStackTrace();
                    }
                    break;

                case 4:

                    System.out.print("Inserisci l'id dell'impiegato da cercare: ");
                    System.out.println();
                    scan = new Scanner(System.in);
                    idCerca = scan.next();

                    try {
                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/" + idCerca);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Accept", "application/json");

                        if (conn.getResponseCode() != 200) {
                                throw new RuntimeException("Failed : HTTP error code : "
                                                + conn.getResponseCode());
                        }

                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                (conn.getInputStream())));

                        String output;
                        

                        conn.disconnect();

                    }

                    catch (MalformedURLException e) {
                    e.printStackTrace();
                    }

                    catch (IOException e) {
                    e.printStackTrace();
                    }

                    break;

                case 5:
                    System.out.println("Id: ");
                    scan = new Scanner(System.in);
                    id = scan.next();
                    idn = Integer.parseInt(id);
                    
                    
                    
                    System.out.println("Nome: ");
                    scan = new Scanner(System.in);
                    nome = scan.next();
                    
                    System.out.println("Cognome: ");
                    scan = new Scanner(System.in);
                    cognome = scan.next();
                    
                    System.out.println("Email: ");
                    scan = new Scanner(System.in);
                    mail = scan.next();
                    
                    System.out.println("Telefono: ");
                    scan = new Scanner(System.in);
                    telefono = scan.next();

                    try {

                        URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/" + idn);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setDoOutput(true);
                        conn.setRequestMethod("PUT");
                        conn.setRequestProperty("Content-Type", "application/json");

                        String input = "{ \"employeeId\":"+idn+", \"firstName\": \""+nome+"\", \"lastName\": \""+cognome+"\",\"email\": \""+mail+"\",\"phone\": \""+telefono+"\" }";

                        OutputStream os = conn.getOutputStream();
                        os.write(input.getBytes());
                        os.flush();

                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                        (conn.getInputStream())));

                        String output;

                        conn.disconnect();
                    } 
                    catch (MalformedURLException e) {
                    e.printStackTrace();
                    }

                    catch (IOException e) {
                    e.printStackTrace();
                    }
                    
                    break;

                case 0:
                    break;
            }
            System.out.println();
            System.out.println("------------------------------");
            System.out.println();
        }while(n != 0);
    }
    
}

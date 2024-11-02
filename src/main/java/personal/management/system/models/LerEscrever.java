package personal.management.system.models;

import java.io.*;
import java.util.List;

public class LerEscrever {

    private String registroUsuarios = "REGISTRO_USUARIOS.txt";

    public void archiveSave(List<User> usuarios) throws IOException {
        try {

            FileReader toRead = new FileReader(this.registroUsuarios);
            BufferedReader buffRead = new BufferedReader(toRead);
            String readed = "";

            while ((readed = buffRead.readLine()) != null) {
                String[] infoUser = readed.split(":");
                User toMemory = new User();
                toMemory.setNome(infoUser[0]);
                toMemory.setEmail(infoUser[1]);
                toMemory.setSenha(infoUser[2]);
                usuarios.add(toMemory);
            }
        } catch (IOException e) {
            throw new IOException("Erro encontrado: " + e.getMessage());
        }
    }

    public void archiveLoad(List<User> usuarios) throws IOException {

        try {
            FileWriter arq  = new FileWriter(this.registroUsuarios, true);
            PrintWriter out = new PrintWriter(arq);

            for (User u : usuarios) {
                out.println(u.getNome()+":"+u.getEmail()+":"+u.getSenha());
            }
            out.close();
            System.out.println("Registro salvo.");
        } catch (IOException e) {
            throw new IOException("Erro encontrado: " + e.getMessage());
        }
    }
}

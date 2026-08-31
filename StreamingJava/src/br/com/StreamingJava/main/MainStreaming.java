package br.com.StreamingJava.main;

import br.com.StreamingJava.model.Usuario;
import br.com.StreamingJava.model.Video;

public class MainStreaming {
    public static void main(String[] args) throws Exception {
        
        Usuario user1 = new Usuario("Apollo", "apollo@email.com", true);
        Video video1 = new Video("Primeiro Vídeo", 120);
        Video video2 = new Video("Segundo Vídeo", -45);

        System.out.println(user1.toString());
        System.out.println(video1.toString());
        System.out.println(video2.toString());
    
        
    }
}

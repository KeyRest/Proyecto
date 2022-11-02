/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;
import modelo.Pregunta;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
/**
 *
 * @author Usuario
 */
public class EscritorArchivos {
    private BufferedWriter escritor;
    
    public void open(String fileName) throws IOException{
        escritor = new BufferedWriter(new FileWriter(fileName));
    }
    
    public void write(Pregunta pregunta) throws IOException {
        escritor.write(pregunta.toFileString()+"\n");
    }
    
    public void close() throws IOException{
        escritor.close();
    }
    
}

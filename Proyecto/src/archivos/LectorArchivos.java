/**
 *
 * @author Usuario
 */
package archivos;
import modelo.Pregunta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


public class LectorArchivos {
    private BufferedReader lector;
    
    public void open(String fileName) throws IOException{
        lector = new BufferedReader(new FileReader(fileName));
    }
    
    public Pregunta read() throws IOException, ClassNotFoundException {
        
        Pregunta pregunta = null;
        
        /*
        String line = reader.readLine();
        String datos[];
        if(line != null){
            person = new Person();
            datos = line.split("-");
            person.setPersonId(datos[0]);
            person.setName(datos[1]);
            person.setLastName(datos[2]);
            person.setAge(Integer.parseInt(datos[3]));
        }
        return person;
        */
        
        return pregunta;
    }
    
    public void close() throws IOException{
        lector.close();
    }
    
}
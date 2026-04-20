package org.github.dabson10.gamevault.utility;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class ClaveHash {
    /**
     * Función para crear una contraseña con hash.
     * @param clave : Clave en texto plano.
     * @return : Regresa una contraseña con hash.
     */
    public String claveHash(String clave){
        return BCrypt.hashpw(clave, BCrypt.gensalt());
    }

    /**
     * Función que validá si la contraseña ingresada es igual a la contraseña
     * con hash
     * @param clave :Contraseña en texto plano
     * @param claveHash : Contraseña con Hash
     */
    public boolean compararClave(String clave, String claveHash){
        boolean estado = false;
        try{
            if(BCrypt.checkpw(clave, claveHash)){
                estado = true;
            }
        }catch(IllegalArgumentException ex){
            System.err.println(ex.getMessage());
        }
        return estado;
    }
}

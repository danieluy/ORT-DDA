/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import logica.Contacto;
import logica.Telefono;
import logica.Tipo;

/**
 *
 * @author docenteFI
 */
public interface VistaAgenda {

  public void mostarTiposTelefono(ArrayList<Tipo> tipos);

  public void mostrarDueño(String nombreCompleto);

  public void mostrarContactos(ArrayList<Contacto> contactos);

  public void mostrarError(String message);

  public void mostrarTelefonos(ArrayList<Telefono> telefonos);

  public void contactoAgregado();

  public void telefonoAgregado();

}

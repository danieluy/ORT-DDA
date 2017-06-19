/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author docenteFI
 */
public class Tarjeta {

  private int oid;
  private int numero;
  private Date vencimiento;

  public Tarjeta() {
  }

  public Tarjeta(int numero) {
    this.numero = numero;
    vencimiento = new Date();
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }

  public Date getVencimiento() {
    return vencimiento;
  }

  public void setVencimiento(Date vencimiento) {
    this.vencimiento = vencimiento;
  }

  @Override
  public String toString() {
    return "Tarjeta{" + "oid=" + oid + ", numero=" + numero + ", vencimiento=" + vencimiento + '}';
  }

}

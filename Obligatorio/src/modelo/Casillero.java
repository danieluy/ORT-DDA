package modelo;

import java.awt.Color;
import vista.CasilleroPanel;

public class Casillero implements CasilleroPanel {

  private Mina mina;
  private Color color;
  private Mina[] minas = {new MinaExplosiva(), new MinaTrampa(), new MinaSuerte()};

  public Casillero() {
    color = Color.LIGHT_GRAY;
  }

  public void activarMina() {
    if (tieneMina())
      color = mina.getColor();
  }

  public Mina getMina() {
    return mina;
  }

  public void agregarMina(Partida partida) {
    System.out.println("partida.getCasillerosRestantes()" + (partida.getCasillerosRestantes()));
    if (!tieneMina() && !destapado()) {
      if (partida.getCasillerosRestantes() <= 2) {
        System.out.println("Entroooooooooooooooooo!!!!!!!!!!!!!!!!!!");
        mina = minas[0];
      }
      else {
        int i = (int) Math.round(Math.random() * ((minas.length) - 1));
        mina = minas[i];
      }
      System.out.println("Mina plantada, tipo " + mina.getTipo());
    }
    System.out.println("Mina NO plantada");
  }

  public boolean tieneMina() {
    return mina != null;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setMina(Mina mina) {
    this.mina = mina;
  }

  private void setColor(Jugador jugador) {
    if (tieneMina())
      color = mina.getColor();
    else
      color = jugador.getColor();
  }

  public void validarDestapar(Jugador jugador) throws CasilleroException {
    if (destapado())
      throw new CasilleroException("Casillero ya destapado");
  }

  public boolean destapado() {
    return !color.equals(Color.LIGHT_GRAY);
  }

  public void destapar(Partida partida) throws CasilleroException {
    Jugador jugador = partida.getJugadorTurno();
    validarDestapar(jugador); // un jugador no puede apostar dos veces !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    setColor(jugador);
    if (tieneMina())
      mina.activar(partida);
    else
      partida.continuar();
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public String getTipoMina() {
    if (destapado() && tieneMina())
      return mina.getTipo();
    return null;
  }

}

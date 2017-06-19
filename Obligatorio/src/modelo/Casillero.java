package modelo;

import java.awt.Color;
import vista.CasilleroPanel;

public class Casillero implements CasilleroPanel {

  private Mina mina;
  private Color color;
  private Mina[] minas = {
    new MinaExplosiva(),
    new MinaTrampa(),
    new MinaSuerte()
  };

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

  public boolean agregarMina(Partida partida) {
    if (!tieneMina() && !destapado()) {
      if (partida.cantCasillerosTapados() - partida.cantMinasColocadas() <= 2)
        mina = minas[0];
      else
        mina = minas[Auxiliar.random((minas.length) - 1)];
      return true;
    }
    return false;
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
    validarDestapar(jugador);
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

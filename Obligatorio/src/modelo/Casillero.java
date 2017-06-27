package modelo;

import java.awt.Color;
import vista.CasilleroPanel;

public class Casillero implements CasilleroPanel {

  private Mina mina;
  private Color color = Color.LIGHT_GRAY;
  private Mina[] minas = {
    new MinaExplosiva(),
    new MinaTrampa(),
    new MinaSuerte()
  };

  public Casillero() {
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

  public void restaurarDesdeBD(String mina, String color) {
    if (mina != null) {
      switch (mina) { // Buscar otra manera para no perder la fleximibilidad de poder agregar tipo de mina en Mina[] minas
        case "E":
          this.mina = new MinaExplosiva();
          break;
        case "S":
          this.mina = new MinaSuerte();
          break;
        case "T":
          this.mina = new MinaTrampa();
          break;
        default:
          this.mina = null;
      }
    }
    setColor(color);
  }

  public boolean tieneMina() {
    return mina != null;
  }

  public void setMina(Mina mina) {
    this.mina = mina;
  }

  public void setColor(Color color) {
    // Se usa para el clonado de casilleros, no debe verificar tieneMina()
    this.color = color;
  }

  public void setColor(String rgb) {
    if (tieneMina())
      color = mina.getColor();
    else {
      String[] c = rgb.split(",");
      color = new Color(Integer.parseInt(c[0]), Integer.parseInt(c[1]), Integer.parseInt(c[2]));
    }
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

  public String getColorRGB() {
    int r = color.getRed();
    int g = color.getGreen();
    int b = color.getBlue();
    return r + "," + g + "," + b;
  }

}

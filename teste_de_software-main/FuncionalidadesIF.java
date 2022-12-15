public interface FuncionalidadesIF {
  public Usuario cadastraUsuario(String nome, String email, String senha);

  public Raizes calculaFuncaoSegundoGrau(double a, double b, double c);

  public boolean ehTriangulo(double angulo1, double angulo2, double angulo3);

  public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3);

  public String classificaTriangulo(double angulo1, double angulo2, double angulo3);

  public boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4);

  public double perimetroRetangulo(double lado1, double lado2);

  public double areaRetangulo(double lado1, double lado2);

  public String calculadora(String expressao);

  public double areaCirculo(double raio);

  public double perimetroCirculo(double raio);

  public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2);

}

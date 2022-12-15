import java.util.regex.Pattern;

public class Sistema implements FuncionalidadesIF {

  @Override
  public Usuario cadastraUsuario(String nome, String email, String senha) {

    Pattern maiusculoValidador = Pattern.compile(".*[A-Z].*");
    Pattern minusculoValidador = Pattern.compile(".*[a-z].*");
    Pattern especialValidador = Pattern.compile(".*[^a-zA-Z 0-9].*");
    Pattern emailValidador = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    Usuario usuario = new Usuario();

    if (senha != null
        && senha.length() >= 8
        && minusculoValidador.matcher(senha).matches()
        && maiusculoValidador.matcher(senha).matches()
        && especialValidador.matcher(senha).matches()) {
      boolean doisNumeros = false;
      int numeroDeNumeros = 0;

      for (int i = 0; i < senha.length(); i++) {
        if (Character.isDigit(senha.charAt(i))) {
          numeroDeNumeros++;
          if (numeroDeNumeros > 2) {
            doisNumeros = true;
          }
        }
      }

      if (doisNumeros) {
        usuario.setSenha(senha);
      }
    }

    if (nome != null && !nome.isEmpty()) {
      usuario.setNome(nome);
    }

    if (email != null && !email.isEmpty() && emailValidador.matcher(email).matches()) {
      usuario.setEmail(email);
    }

    return usuario;
  }

  @Override
  public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {
    double delta;
    double x1;
    double x2;

    if (a != 0) {

      delta = b * b * 4 * a * c;
      if (delta >= 0) {
        x1 = (int) ((-b + (Math.sqrt(delta))) / (2 * a));
        x2 = (int) ((-b + (Math.sqrt(delta))) / (2 * a));
        return new Raizes(x1, x2);
      }
    }

    return null;
  }

  @Override
  public boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4) {
    boolean iguais = (angulo1 == angulo2) && (angulo2 == angulo3) && (angulo3 == angulo4);
    boolean noventaGraus = (angulo1 == 90) && (angulo2 == 90) && (angulo3 == 90) && (angulo4 == 90);

    if (!iguais)
      return false;
    if (!noventaGraus)
      return false;

    return true;
  }

  @Override
  public boolean ehTriangulo(double angulo1, double angulo2, double angulo3) {

    if (angulo1 <= 0 || angulo2 <= 0 || angulo2 <= 0)
      return false;

    if ((angulo1 + angulo2 + angulo3) != 180)
      return false;

    return true;
  }

  @Override
  public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3) {
    double[] lados = new double[] { lado1, lado2, lado3 };

    double hipotenusa = Math.max(lado1, lado2);
    hipotenusa = Math.max(lado3, hipotenusa);

    double somaQuadrada = 0;
    for (double lado : lados) {
      if (lado != hipotenusa) {
        somaQuadrada += (lado * lado);
      }
    }

    if (somaQuadrada != (hipotenusa * hipotenusa))
      return false;

    return true;
  }

  @Override
  public String classificaTriangulo(double angulo1, double angulo2, double angulo3) {
    if (!ehTriangulo(angulo1, angulo2, angulo3))
      return null;

    boolean retangulo = (angulo1 == 90) || (angulo2 == 90) || (angulo3 == 90);

    if (retangulo)
      return "Retangulo";

    boolean acutangulo = (angulo1 < 90) && (angulo2 < 90) && (angulo3 < 90);

    if (acutangulo)
      return "Acutangulo";

    boolean obtusangulo = (angulo1 > 90) || (angulo2 > 90) || (angulo3 > 90);

    if (obtusangulo)
      return "Obtusângulo";

    return null;
  }

  @Override
  public double perimetroRetangulo(double lado1, double lado2) {
    double perimetro = 2 * (lado1 + lado2);
    return perimetro;
  }

  @Override
  public double areaRetangulo(double lado1, double lado2) {
    double area = lado1 * lado2;
    return area;
  }

  @Override
  public String calculadora(String expressao) {
    String expressaoSemEspaco = expressao.replaceAll("\\s+", "");
    double valor1;
    double valor2;

    if (expressaoSemEspaco.contains("**")) {
      double[] valores = formatarValor(expressaoSemEspaco, "\\*\\*");
      if (valores == null) {
        return "Expressão inválida";
      }
      valor1 = valores[0];
      valor2 = valores[1];
      return String.valueOf(Math.pow(valor1, valor2));
    }

    if (expressaoSemEspaco.contains("+")) {
      double[] valores = formatarValor(expressaoSemEspaco, "\\+");
      if (valores == null) {
        return "Expressão inválida";
      }
      valor1 = valores[0];
      valor2 = valores[1];
      return String.valueOf(valor1 + valor2);
    }

    if (expressaoSemEspaco.contains("-")) {
      double[] valores = formatarValor(expressaoSemEspaco, "\\-");
      if (valores == null) {
        return "Expressão inválida";
      }
      valor1 = valores[0];
      valor2 = valores[1];
      return String.valueOf(valor1 - valor2);
    }

    if (expressaoSemEspaco.contains("/")) {
      double[] valores = formatarValor(expressaoSemEspaco, "/");
      if (valores == null) {
        return "Expressão inválida";
      }
      valor1 = valores[0];
      valor2 = valores[1];

      if (valor2 == 0) {
        return "O divisor não pode ser zero";
      }
      return String.valueOf(valor1 / valor2);
    }

    if (expressaoSemEspaco.contains("*")) {
      double[] valores = formatarValor(expressaoSemEspaco, "\\*");
      if (valores == null) {
        return "Expressão inválida";
      }
      valor1 = valores[0];
      valor2 = valores[1];
      return String.valueOf(valor1 * valor2);
    }

    return "Operador é desconhecido ou não há operador";
  }

  private double[] formatarValor(String expressao, String operador) {
    String[] valoresSeparados = expressao.split(operador);
    if (valoresSeparados.length != 2)
      return null;
    String valor1 = valoresSeparados[0];
    String valor2 = valoresSeparados[1];

    if (!isInteger(valor1) || !isInteger(valor2))
      return null;

    return new double[] { Double.parseDouble(valor1), Double.parseDouble(valor2) };
  }

  private boolean isInteger(String str) {
    return str != null && str.matches("[0-9]*");
  }

  @Override
  public double areaCirculo(double raio) {
    double area = Math.PI * Math.pow(raio, 2);
    return area;
  }

  @Override
  public double perimetroCirculo(double raio) {
    double perimetro = 2 * Math.PI * raio;
    return perimetro;
  }

  @Override
  public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
    double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    return distancia;
  }

}

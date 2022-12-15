import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner sc1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema");
        int option = 9999;
        while (option != 13) {
            switch (option) {
                case 1:
                    try {
                        System.out.print("Digite o nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Digite o email: ");
                        String email = sc.nextLine();
                        System.out.print(
                                "Digite a senha (mínimo 8 caracteres, 2 números(min), 1 caractere especial(min), 1 letra maiuscula(min), 1 letra minuscula(min)): ");
                        String senha = sc.nextLine();
                        Usuario usuario = sistema.cadastraUsuario(nome, email, senha);

                        System.out.println(usuario.haExcecao() ? "Erro: " + usuario.pegarExcecao()
                                : "Cadastro realizado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Digite o a: ");
                        double a = sc.nextDouble();
                        System.out.print("Digite o b: ");
                        double b = sc.nextDouble();
                        System.out.print("Digite o c: ");
                        double c = sc.nextDouble();
                        Raizes resultado = sistema.calculaFuncaoSegundoGrau(a, b, c);
                        System.out.println(resultado != null
                                ? ("Os resultados são:" + resultado.getEntradaA() + resultado.getEntradaB())
                                : "Não foi possível encontrar os resultados");
                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Digite o angulo 1");
                        double angulo1 = sc.nextDouble();
                        System.out.print("Digite o angulo 2");
                        double angulo2 = sc.nextDouble();
                        System.out.print("Digite o angulo 3");
                        double angulo3 = sc.nextDouble();
                        boolean ehtri = sistema.ehTriangulo(angulo1, angulo2, angulo3);
                        System.out.println(ehtri ? "eh triangulho" : "nao eh triangulo");
                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Digite o ângulo 1: ");
                        double lado1 = sc.nextDouble();
                        System.out.print("Digite o ângulo 2: ");
                        double lado2 = sc.nextDouble();
                        System.out.print("Digite o ângulo 3: ");
                        double lado3 = sc.nextDouble();
                        if (sistema.ehTrianguloRetangulo(lado1, lado2, lado3)) {
                            System.out.println("ehTrianguloRetangulo");
                        } else {
                            System.out.println("Não ehTrianguloRetangulo");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Digite o ângulo 1: ");
                        double angulo1 = sc.nextDouble();
                        System.out.print("Digite o ângulo 2: ");
                        double angulo2 = sc.nextDouble();
                        System.out.print("Digite o ângulo 3: ");
                        double angulo3 = sc.nextDouble();
                        String res = sistema.classificaTriangulo(angulo1, angulo2, angulo3);
                        System.out.println("Classificação: " + res != null ? res : "impossível classificar");

                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 6:
                    try {
                        System.out.print("Digite o ângulo 1: ");
                        double angulo1 = sc.nextDouble();
                        System.out.print("Digite o ângulo 2: ");
                        double angulo2 = sc.nextDouble();
                        System.out.print("Digite o ângulo 3: ");
                        double angulo3 = sc.nextDouble();
                        System.out.print("Digite o ângulo 4: ");
                        double angulo4 = sc.nextDouble();
                        if (sistema.ehRetangulo(angulo1, angulo2, angulo3, angulo4)) {
                            System.out.println("ehRetangulo");
                        } else {
                            System.out.println("Não ehRetangulo");
                        }

                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 7:
                    try {
                        System.out.print("Digite o valor da base: ");
                        double lado1 = sc.nextDouble();
                        System.out.print("Digite o valor da altura: ");
                        double lado2 = sc.nextDouble();
                        System.out.println("O perimetro é: " + sistema.perimetroRetangulo(lado1, lado2));

                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 8:
                    try {
                        System.out.print("Digite o valor da base: ");
                        double lado1 = sc.nextDouble();
                        System.out.print("Digite o valor da altura: ");
                        double lado2 = sc.nextDouble();
                        System.out.println("A área do retângulo é: " + sistema.areaRetangulo(lado1, lado2));
                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 9:
                    try {
                        System.out.print("Digite a expressão: ");
                        String expressão = sc.nextLine();
                        System.out.println("Resultado: " + sistema.calculadora(expressão));

                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 10:
                    try {
                        System.out.print("Digite o raio: ");
                        double raio = sc.nextDouble();
                        System.out.println("A área do circulo é: " + sistema.areaCirculo(raio));

                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 11:
                    try {
                        System.out.print("Digite o raio: ");
                        double raio = sc.nextDouble();
                        System.out.println("O perimetro: " + sistema.perimetroCirculo(raio));

                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                case 12:
                    try {
                        System.out.print("Digite o x1: ");
                        double x1 = sc.nextDouble();
                        System.out.print("Digite o y1: ");
                        double y1 = sc.nextDouble();
                        System.out.print("Digite o x2: ");
                        double x2 = sc.nextDouble();
                        System.out.print("Digite o y2: ");
                        double y2 = sc.nextDouble();
                        System.out.println("A distância é de: " + sistema.distanciaEntreDoisPontos(x1, y1, x2, y2));

                    } catch (Exception e) {
                        System.out.println("Erro, valor(es) inválido(s)");
                    }
                    break;
                default:
                    System.out.println("1 - cadastraUsuario");
                    System.out.println("2 - calculaFuncaoSegundoGrau");
                    System.out.println("3 - ehTriangulo");
                    System.out.println("4 - ehTrianguloRetangulo");
                    System.out.println("5 - classificaTriangulo");
                    System.out.println("6 - ehRetangulo");
                    System.out.println("7 - perimetroRetangulo");
                    System.out.println("8 - areaRetangulo");
                    System.out.println("9 - calculadora");
                    System.out.println("10 - areaCirculo");
                    System.out.println("11 - perimetroCirculo");
                    System.out.println("12 - distanciaEntreDoisPontos");
                    System.out.println("13 - Sair do Sistema");
                    break;
            }
            System.out.println();
            System.out.print("Escolha algumas das opções do sistema (14 para mostrar as opções novamente): ");
            option = sc1.nextInt();
        }
        sc1.close();
        sc.close();
    }
}

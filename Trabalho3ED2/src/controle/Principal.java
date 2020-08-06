package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import modelo.Aluno;

class ComparaNome implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a1.getNome().compareTo(a2.getNome());
    }

}

public class Principal {

    public static void main(String[] args) {
        String remover = null;
        String modificar = null;
        String modificar2 = null;
        String modificar3 = null;
        int opcao = 0;
        int op2 = 0;
        int op3 = 0;
        String nome = null;
        int matricula = 0;
        float n1 = 0;
        float n2 = 0;
        float n3 = 0;
        float mn = 0;
        List lista = new ArrayList<Aluno>();
        Aluno[] aluno = {};
        Scanner op = new Scanner(System.in);
        while (opcao != 9) {

            System.out.println("+----------MENU-DE-OPÇÕES----------+");
            System.out.println("|Inserir aluno -------------------1|");
            System.out.println("|Remover aluno -------------------2|");
            System.out.println("|Listar alunos -------------------3|");
            System.out.println("|Listar ordenado pela matrícula --4|");
            System.out.println("|Gravar no arquivo a lista -------5|");
            System.out.println("|Ler do arquivo a lista ----------6|");
            System.out.println("|Busca por matrícula -------------7|");
            System.out.println("|Encerrar programa ---------------8|");
            System.out.println("+----------------------------------+");
            System.out.println("Digite a opção desejada:");
            opcao = op.nextInt();

            switch (opcao) {
                case 1:

                    //adicionando alunos
                    System.out.println("Adicionando aluno(a).");
                    System.out.println("Digite o nome do(a) aluno(a): ");
                    nome = op.next();
                    System.out.println("Digite a matricula do(a) aluno(a): ");
                    matricula = op.nextInt();
                    System.out.println("Digite a nota 1 do(a) aluno(a): ");
                    n1 = op.nextInt();
                    System.out.println("Digite a nota 2 do(a) aluno(a): ");
                    n2 = op.nextFloat();
                    System.out.println("Digite o nota 3 do(a) aluno(a): ");
                    n3 = op.nextFloat();
                    mn = (float) ((n1*0.2) + (n2*0.35) + (n3*0.45));
                    lista.add(new Aluno(nome, matricula, n1, n2, n3,mn));

                    op2++;
                    break;

                case 2:

                    //removendo alunos
                    System.out.println("Removendo aluno.");
                    System.out.println("Digite o nome do(a) aluno(a) que deseja remover: ");
                    remover = op.next();
                    lista.remove((String) remover);
                    op2--;
                    break;

                case 3:

                    //listar alunos
                    if (op2 == 0) {
                        lista.isEmpty();
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.println("Listar alunos: " + lista);
                    }
                    break;
                case 4:

                    //listar ordenado por matrícula
                    if (op2 == 0) {
                        lista.isEmpty();
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.println("Listar alunos ordenado pela matrícula.");
                        Collections.sort(lista);
                        System.out.println("Lista ordenda por matrícula: " + lista);
                    
                    }
                    break;
                    
                case 5:

                    //gravar no arquivo
                    File arqSaida = new File("saida.txt");
                     {
                        try {
                            FileOutputStream cano = new FileOutputStream(arqSaida);
                            ObjectOutputStream filtro = new ObjectOutputStream(cano);
                            filtro.writeObject(lista);
                            filtro.close();
                        } catch (FileNotFoundException ex) {
                            System.out.println("Erro: arquivo não encontrado.");
                        } catch (IOException ex) {
                            System.out.println("Erro: erro de IO.");
                        }
                    }
                    break;
                case 6:

                    //ler do arquivo
                    File arqEntrada = new File("entrada.txt");
                     {
                        try {
                            FileInputStream cano = new FileInputStream(arqEntrada);
                            ObjectInputStream filtro = new ObjectInputStream(cano);
                            lista = (ArrayList<Aluno>) filtro.readObject();
                            System.out.println("Lista lida do arquivo: " + lista);
                        } catch (FileNotFoundException ex) {
                            System.out.println("Erro: arquivo não encontrado.");
                        } catch (IOException ex) {
                            System.out.println("Erro: erro de IO.");
                        } catch (ClassNotFoundException ex) {
                            System.out.println("Erro: não é Produto.");
                                    
                        }
                    }
                    break;
                case 7:
                    if (op2 == 0) {
                        lista.isEmpty();
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.println("Busca por matrícula");
                        System.out.println("Digite a matricula do(a) aluno(a): ");
                        op3 = op.nextInt();
                        if(lista.equals(op)== true){
                            System.out.println("Nome encontrado na lista.");
                        }
                        else{
                            System.out.println("Nome não encontrado na lista.");
                        }
                    
                    }
                    break;
                    //não funciona
                case 8:
                    System.out.println("Digite a matricula do(a) aluno(a): ");
                    op3 = op.nextInt();
                    if(op.equals(lista)!= false){
                        System.out.println("Pesquisa obteve sucesso.");
                    }
                    else{
                        System.out.println("Pesquisa sem sucesso.");
                    }
                    break;
                case 9:
                    //encerrar
                    return;
            }
        }
    }
}


package modelo;

import java.io.Serializable;

public class Aluno implements Comparable<Aluno> , Serializable{
    private String nome;
    private int matricula;
    private float n1;
    private float n2;
    private float n3;
    private float mn;

    @Override
    public String toString() {
        return "Aluno(a){" + "Nome=" + nome + ", Matrícula=" + matricula + ", Nota 1=" + n1 + ", Nota 2=" + n2 + ", Nota 3=" + n3 + ", Media =" + mn + '}' + "\n ";
    }

    public Aluno(String nome, int matricula, float n1, float n2, float n3, float mn) {
        this.nome = nome;
        this.matricula = matricula;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.mn = mn;
    }

    public Aluno() {
        
    }

    public Aluno(String nome, int matricula, float n1, float n2, float n3) {
        this.nome = nome;
        this.matricula = matricula;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public float getN1() {
        return n1;
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }

    public float getN3() {
        return n3;
    }

    public void setN3(float n3) {
        this.n3 = n3;
    }

    public float getMn() {
        return mn;
    }

    public void setMn(float mn) {
        this.mn = mn;
    }

    @Override
    public int compareTo(Aluno t) {
        if (this.matricula > t.matricula)
            return 1;
        if (this.matricula == t.matricula)
            return 0;
        return -1;
    }


}

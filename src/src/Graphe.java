import java.util.Arrays;

public class Graphe {
    private int n;
    private String[] noms;
    private int[][] matAdj;
    private int[] couleurs;
    private int[] degre;
    private boolean[] retire;
    private int[] pile;
    private int sommetPile;

    public Graphe(String[] noms) {
        this.noms = noms;
        this.n = noms.length;
        this.matAdj = new int[n][n];
        this.couleurs = new int[n];
        Arrays.fill(couleurs, -1);
        this.degre = new int[n];
        this.retire= new boolean[n];
        this.pile= new int[n];
        this.sommetPile = 0;
    }


    void ajouterArete(int s1, int s2, int val) throws IllegalArgumentException {
        if(s1==s2){
            throw new IllegalArgumentException("les deux sommets doivent être différent");
        }
        if(s1>n-1 || s2>n-1 || s1 <0 || s2<0) {
            throw new IllegalArgumentException("le sommet doit etre entre 0 et n-1");
        }
        if(val >2 || val<=0){
            throw new IllegalArgumentException("val peut uniquement etre soit 1 ou 2");
        }
        //une préférence n'écrase pas une interférence
        if(val == 2 && matAdj[s1][s2]==1){
            return;
        }
        matAdj[s1][s2] = val;
        matAdj[s2][s1] = val;
    }

    void calculerDegres(){
        for (int i=0; i<n; i++) {
            degre[i]=0;
            for (int j=0; j<n; j++) {
                if (matAdj[i][j]==1) {
                    degre[i]++;
                }
            }
        }
    }

    int trouverSommetSimplifiable(int k){
        int length = matAdj.length;
        for (int i=0; i<length; i++) {
            if(degre[i]<k && retire[i]==false)
                return i;
        }
        return -1;
    }

    int choisirSommetASpiller(){
        int meilleur_indice = -1;
        int meilleur_degre = -1;
        for (int i=0; i<n; i++) {
            if(retire[i]==false && degre[i]>meilleur_degre ) {
                meilleur_indice = i;
                meilleur_degre = degre[i];
            }
        }
        return meilleur_indice;
    }

   void retirerSommet(int s){
        retire[s]=true;
        for (int j=0; j<n; j++) {
            if ( matAdj[s][j]==1 && retire[j]==false) {
                degre[j]--; //le voisin perd un degré en concéquence
            }
        }
        //on ajoute chaque sommet retiré a la pile pour pouvoir ensuite les colorier dans l'ordre inverse
        pile[sommetPile]=s;
        sommetPile++;
    }



    void main() {
        //int[][] matAdj1 = new int[6][6];
        //int[][] matAdj2 = new int[4][4];
        String[] noms1 = new String[]{"x", "y", "z", "t", "u", "v"};
        Graphe g1 = new Graphe(noms1);

        g1.ajouterArete(0, 1, 1);
        g1.ajouterArete( 0, 4, 1);
        g1.ajouterArete( 0, 5, 1);
        g1.ajouterArete( 1, 3, 1);
        g1.ajouterArete( 1, 4, 1);
        g1.ajouterArete( 2, 5, 1);
        g1.ajouterArete( 3, 5, 1);
        g1.ajouterArete( 4, 3, 2);

        String[] noms2 = new String[]{"x", "y", "z", "t"};
        Graphe g2 = new Graphe(noms2);
        g2.ajouterArete( 0, 1, 1);
        g2.ajouterArete( 0, 2, 1);
        g2.ajouterArete( 1, 3, 1);
        g2.ajouterArete( 2, 3, 1);

    }
}

public class Graphe {
    private int n;
    private String[] noms;
    private int[][] matAdj;
    private int[] coleurs;
    private int[] degre;
    private boolean[] retire;

    public Graphe(String[] noms) {
        this.noms = noms;
        this.n = noms.length;
        this.matAdj = new int[n][n];
        this.coleurs = new int[n];
        this.degre = new int[n];
        this.retire= new boolean[n];
    }


    void ajouterArete(int[][] matAdj, int s1, int s2, int val) {
        int n = matAdj.length;
        if (s1 == s2) {
            perror("Interdiction de créer une arete avec qu'un seul sommet");
            exit(0);
        } else if(s1>n-1 || s2>n-1 || s1 <0 || s2<0) {
            perror("le sommet doit être compris entre 0 et n-1");
            exit(0);
        }
        matAdj[s1][s2] = val;
        matAdj[s2][s1] = val;
    }

    void calculerDegres(){
        int n = matAdj.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (matAdj[i][j]==1) {
                    degre[i]++;
                }
            }
        }
    }

    int trouverSommetSimplifiable(k){
        int n = matAdj.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(degre[i]<k && retire[i]==false)
                    return i;
            }
        } else { return -1;}
    }

    int choisirSommetASpiller(){
        int n = matAdj.length;
        int meilleur_indice = -1;
        int meilleur_degre = -1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(retire[j]==false && degre[j]>meilleur_degre ) {
                    meilleur_indice = j;
                    meilleur_degre = degre[j];
                }
            }
        }
        return meilleur_indice;
    }

   void retirerSommet(int s){
        int n = matAdj.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (j==s) {
                    retire[j] = true;
                }
            }
        }
    }



    void main() {
        int[][] matAdj1 = new int[6][6];
        int[][] matAdj2 = new int[4][4];

        ajouterSommet(matAdj1, 0, 1, 1);
        ajouterSommet(matAdj1, 0, 4, 1);
        ajouterSommet(matAdj1, 0, 5, 1);
        ajouterSommet(matAdj1, 1, 3, 1);
        ajouterSommet(matAdj1, 1, 4, 1);
        ajouterSommet(matAdj1, 2, 5, 1);
        ajouterSommet(matAdj1, 3, 5, 1);
        ajouterSommet(matAdj1, 4, 3, 2);

        ajouterSommet(matAdj2, 0, 1, 1);
        ajouterSommet(matAdj2, 0, 2, 1);
        ajouterSommet(matAdj2, 1, 3, 1);
        ajouterSommet(matAdj2, 2, 3, 1);

    }
}

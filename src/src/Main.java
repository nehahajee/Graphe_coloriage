void ajouterSommet(int[][] matAdj,int s1, int s2, int val){
    matAdj[s1][s2]=val;
    matAdj[s2][s1]=val;
}

void main() {
    int [][] matAdj1 = new int[6][6];
    int [][] matAdj2 = new int[4][4];

    ajouterSommet(matAdj1,0,1,1);
    ajouterSommet(matAdj1,0,4,1);
    ajouterSommet(matAdj1,0,5,1);
    ajouterSommet(matAdj1,1,3,1);
    ajouterSommet(matAdj1,1,4,1);
    ajouterSommet(matAdj1,2,5,1);
    ajouterSommet(matAdj1,3,5,1);
    ajouterSommet(matAdj1,4,3,2);

    ajouterSommet(matAdj2,0,1,1);
    ajouterSommet(matAdj2,0,2,1);
    ajouterSommet(matAdj2,1,3,1);
    ajouterSommet(matAdj2,2,3,1);

}

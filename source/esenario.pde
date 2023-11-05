class Esenario{
int[][] m;
int dx;
int dy;

Esenario(int x,int y){
 m = new int[x][y];
 dx=x;
 dy=y;
}

void cargar(PImage imgfon){
for(int i =0 ; i<dx ; i++){
for(int j =0 ; j<dy ; j++){
  if(imgfon.get(i,j)<-150){ m[i][j] =1;}else{ m[i][j] =0;}
 
}}

}

int getM(int x,int y){
return m[x][y];
}





}
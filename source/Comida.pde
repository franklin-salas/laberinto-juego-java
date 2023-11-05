class comida {
int posx,posy;

PImage b;
comida(PImage g,int x,int y){
b=g;
posx=x;
posy=y;


}

void dibujar(){
  imageMode(CENTER);
image(b,posx,posy);

}



}
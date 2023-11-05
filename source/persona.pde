class Persona{

boolean arriba;
boolean abajo;
boolean dere;
boolean izq;
PImage[][] p = new PImage[4][5];
int vida;
int x,y;
int posx,posy;

Persona(PImage imgP){
arriba=false;
abajo=false;
dere=false;
izq= false;
x=0;
y=0;
vida=3;
posx=32;
posy=32;
for(int i =0 ; i<4 ; i++){
for(int j =0 ; j<5 ; j++){
  p[i][j] = imgP.get(j*32,i*32,32,32);
}}
}

void dibujar(){
  
imageMode(CENTER);
  image(p[x][y],posx,posy);
  


}


void mover(){
    if(posx<10){
  izq=false;
  }
  if(posx>580){
    dere=false;
  }
  if(posy<10){
  arriba=false;
  }
  if(posy>580){
  abajo=false;
  }

 // delay(10);
if(arriba){
   if(e.getM(posx,posy-4) !=1){
x=2; y=(y % 4)+1;
posy-=2;}
}
//delay(10);
if(abajo){
   if(e.getM(posx,posy+10) !=1){
x=0; y=(y % 4)+1;
posy+=2;}
}
// delay(10);
if(izq){
   if(e.getM(posx-10,posy) !=1){
x=1; y=(y % 4)+1;
posx-=2;}
}
// delay(10);
if(dere){
   if(e.getM(posx+10,posy) !=1){
x=3; y=(y % 4)+1;
posx+=2;
}}
if(!arriba && !abajo && !izq && !dere){
y=0;
}


}
void teclaApretada(int tecla){
  if(tecla==39 ){
  dere=true;
  }
  if(tecla==37 ){
  izq=true;
  }
  if(tecla==38 ){
  arriba=true;
  }
   if(tecla==40){
  abajo=true;
  }
  
  
}
  
  
void teclaSotada(int tecla){
    if(tecla==39 ){
  dere=false;
  }
  if(tecla==37 ){
  izq=false;
  }
   if(tecla==38){
  arriba=false;
  }
   if(tecla==40 ){
  abajo=false;
  }
}






















}
class Bicho{
int posx,posy;
boolean arriba;
boolean abajo;
boolean derecha;
boolean izquierda;
PImage b;
Bicho(PImage g,int x,int y){
b=g;
posx=x;
posy=y;
 arriba =false;
 abajo= false;
 derecha=false;
 izquierda=false;

}

void dibujar(){
  imageMode(CENTER);
image(b,posx,posy);

}

void mover(){
  if(arriba || abajo || derecha || izquierda){
  if(arriba && e.getM(posx,posy-10) ==1 ||posy<50 ){arriba=false;}
    if(abajo && e.getM(posx,posy+10) ==1 || posy>540){abajo=false;}
      if(derecha && e.getM(posx+10,posy) ==1 || posx>540){derecha=false;}
        if(izquierda && e.getM(posx-10,posy) ==1 || posx<50){izquierda=false;}
  
  }else{
  
  int con1 = int(random(0,200));
  if(con1>180  && e.getM(posx,posy-10) !=1){arriba=true;abajo=false;derecha=false;izquierda=false;};
  
  if(con1>99 && con1<181 && e.getM(posx,posy+10)!=1){arriba=false;abajo=true;derecha=false;izquierda=false;};

  if(con1>49 && con1<100 && e.getM(posx+10,posy) !=1){arriba=false;abajo=false;derecha=true;izquierda=false;};

  if(con1<50 &&  e.getM(posx-10,posy) !=1){arriba=false;abajo=false;derecha=false;izquierda=true;};
  }
  
 if(arriba ){ posy--;}
 if(abajo ){ posy++;}
 if(derecha ){ posx++;}
 if(izquierda ){ posx--;}



}






}
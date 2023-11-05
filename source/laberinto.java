import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class laberinto extends PApplet {

Persona mario ;
PImage imgmario;
PImage imgMons;
PImage imgfru;
PImage imgfondo;
PImage imgfondo2;
PImage ganador;
PImage perdedor;
Esenario e;
Esenario e2;
Bichos B;
Bichos B2;
Comidas c;
Comidas c2;
int level =1;

public void setup(){

imgfondo = loadImage("labe.png");
imgfondo2  = loadImage("labe2.png");
imgMons=loadImage("bicho.png");
imgfru = loadImage("fruta.png");
imgmario = loadImage("persona.png");
ganador=loadImage("ganador.png");
perdedor=loadImage("perdedor.png");
B = new Bichos();
B2 = new Bichos();
B.Bichos2(imgMons);
B2.Bichos2(imgMons);
c  = new Comidas();
c2  = new Comidas();
c2.Comidas2(imgfru);
c.Comidas(imgfru);
mario = new Persona(imgmario);
imageMode(CORNER);
 image(imgfondo,0,0);
 e = new Esenario(imgfondo.height,imgfondo.width);
 e.cargar(imgfondo);
  e2 = new Esenario(imgfondo2.height,imgfondo2.width);
 e2.cargar(imgfondo2);
 
}

public void draw(){
  imageMode(CORNER);

 if( level==1){
    image(imgfondo,0,0);
 choqueFruAs();
  B.mover();
   choqueMounstruoAs();
   c.dibujar();
 if(c.co.size()==0 ){level++;
 B.bicho.removeAll(B.bicho);
 B=B2;
 e=e2;
 c=c2;
 mario.posx=25;
  mario.posy=365;
 }
 }
 
  if( level==2){
     image(imgfondo2,0,0);
 choqueFruAs();
  B.mover();
   choqueMounstruoAs();
   c.dibujar();
 if(c.co.size()==0 ){level++;}
 } 
   
 if(mario.vida>0 && level<3){
 mario.dibujar();
  mario.mover();

}
if(mario.vida<1){
  imageMode(CENTER);
 image(perdedor,300,300);
}
if(level>2){
    imageMode(CENTER);
 image(ganador,300,300);}
  
  println(mouseX,mouseY);
 
   //fill(imgfondo.get(mario.posx,mario.posy));
   // print(imgfondo.get(mario.posx,mario.posy));
// ellipse(300,300,50,50);
  //delay(100);
}


public void keyPressed(){
mario.teclaApretada(keyCode);
  
 

  
}


public void keyReleased(){
  mario.teclaSotada(keyCode);
//print(keyCode);


}
public void choqueMounstruoAs(){

for(Bicho d : B.bicho){
  float dist = sqrt(pow(d.posx-mario.posx, 2)+pow(d.posy-mario.posy, 2));
   if(dist<20){
   mario.vida--;
   mario.posx=32;
   mario.posy=32;
   }  
  


}


}



public void choqueFruAs(){
ArrayList <comida>  com = new ArrayList<comida>();
for(comida d : c.co){
  float dist = sqrt(pow(d.posx-mario.posx, 2)+pow(d.posy-mario.posy, 2));
   if(dist<14){
     com.add(d);
 
   }  
  


}
c.co.removeAll(com);

}
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

public void dibujar(){
  imageMode(CENTER);
image(b,posx,posy);

}

public void mover(){
  if(arriba || abajo || derecha || izquierda){
  if(arriba && e.getM(posx,posy-10) ==1 ||posy<50 ){arriba=false;}
    if(abajo && e.getM(posx,posy+10) ==1 || posy>540){abajo=false;}
      if(derecha && e.getM(posx+10,posy) ==1 || posx>540){derecha=false;}
        if(izquierda && e.getM(posx-10,posy) ==1 || posx<50){izquierda=false;}
  
  }else{
  
  int con1 = PApplet.parseInt(random(0,200));
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
class Bichos {
  
ArrayList <Bicho>  bicho = new ArrayList<Bicho>();


 public void Bichos(PImage g){
  Bicho a = new Bicho(g,70,220);
  Bicho b = new Bicho(g,150,82);
  Bicho c = new Bicho(g,200,82);
  Bicho d = new Bicho(g,70,510);
  Bicho e = new Bicho(g,450,510);
   Bicho f = new Bicho(g,200,510);
   bicho.add(a);
      bicho.add(b);
         bicho.add(c);
            bicho.add(d);
               bicho.add(e);
                  bicho.add(f);
                  
  
 
}
 public void Bichos2(PImage g){
  Bicho a = new Bicho(g,70,220);
  Bicho b = new Bicho(g,150,82);
  Bicho c = new Bicho(g,200,82);
  Bicho d = new Bicho(g,320,320);
  Bicho e = new Bicho(g,450,510);
   Bicho f = new Bicho(g,200,510);
   bicho.add(a);
      bicho.add(b);
         bicho.add(c);
            bicho.add(d);
               bicho.add(e);
                  bicho.add(f);
                  
  
 
}
public void mover(){
for(Bicho b : bicho){
b.dibujar();
b.mover();
  
}
  
  

}





}
class comida {
int posx,posy;

PImage b;
comida(PImage g,int x,int y){
b=g;
posx=x;
posy=y;


}

public void dibujar(){
  imageMode(CENTER);
image(b,posx,posy);

}



}
class Comidas {
  
ArrayList <comida>  co = new ArrayList<comida>();


public void Comidas(PImage g){
  comida a = new comida(g,324,355);
  comida b = new comida(g,213,460);
  comida c = new comida(g,390,333);
  comida d = new comida(g,225,144);
  comida e = new comida(g,520,508);
  comida f = new comida(g,122,396);
  comida f1 = new comida(g,520,77);
  comida f2 = new comida(g,74,290);
   co.add(a);
      co.add(b);
         co.add(c);
            co.add(d);
              co.add(e);
                  co.add(f);
                  co.add(f1);
                  co.add(f2);
  
 
}
public void Comidas2(PImage g){
  comida a = new comida(g,324,200);
  comida b = new comida(g,213,460);
  comida c = new comida(g,390,333);
  comida d = new comida(g,225,144);
  comida e = new comida(g,520,508);
  comida f = new comida(g,122,396);
  comida f1 = new comida(g,520,77);
  comida f2 = new comida(g,74,290);
   co.add(a);
      co.add(b);
         co.add(c);
            co.add(d);
              co.add(e);
                  co.add(f);
                  co.add(f1);
                  co.add(f2);
  
 
}
public void dibujar(){
for(comida b : co){
b.dibujar();
  
}
  
  

}}
class Esenario{
int[][] m;
int dx;
int dy;

Esenario(int x,int y){
 m = new int[x][y];
 dx=x;
 dy=y;
}

public void cargar(PImage imgfon){
for(int i =0 ; i<dx ; i++){
for(int j =0 ; j<dy ; j++){
  if(imgfon.get(i,j)<-150){ m[i][j] =1;}else{ m[i][j] =0;}
 
}}

}

public int getM(int x,int y){
return m[x][y];
}





}
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

public void dibujar(){
  
imageMode(CENTER);
  image(p[x][y],posx,posy);
  


}


public void mover(){
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
public void teclaApretada(int tecla){
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
  
  
public void teclaSotada(int tecla){
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
  public void settings() { 
size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "laberinto" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

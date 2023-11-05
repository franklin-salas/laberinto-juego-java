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

void setup(){
size(600,600);
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

void draw(){
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


void keyPressed(){
mario.teclaApretada(keyCode);
  
 

  
}


void keyReleased(){
  mario.teclaSotada(keyCode);
//print(keyCode);


}
void choqueMounstruoAs(){

for(Bicho d : B.bicho){
  float dist = sqrt(pow(d.posx-mario.posx, 2)+pow(d.posy-mario.posy, 2));
   if(dist<20){
   mario.vida--;
   mario.posx=32;
   mario.posy=32;
   }  
  


}


}



void choqueFruAs(){
ArrayList <comida>  com = new ArrayList<comida>();
for(comida d : c.co){
  float dist = sqrt(pow(d.posx-mario.posx, 2)+pow(d.posy-mario.posy, 2));
   if(dist<14){
     com.add(d);
 
   }  
  


}
c.co.removeAll(com);

}
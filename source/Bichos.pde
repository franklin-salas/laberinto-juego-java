class Bichos {
  
ArrayList <Bicho>  bicho = new ArrayList<Bicho>();


 void Bichos(PImage g){
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
 void Bichos2(PImage g){
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
void mover(){
for(Bicho b : bicho){
b.dibujar();
b.mover();
  
}
  
  

}





}
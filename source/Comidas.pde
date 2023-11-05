class Comidas {
  
ArrayList <comida>  co = new ArrayList<comida>();


void Comidas(PImage g){
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
void Comidas2(PImage g){
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
void dibujar(){
for(comida b : co){
b.dibujar();
  
}
  
  

}}
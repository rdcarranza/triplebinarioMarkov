/*
 * 
 */
package multiplicacion3markov;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dario Carranza
 */
public class Markov {
    long dec;
    String bin;
    
    public Markov(long d){ //Costructor, en base a un entero (Decimal).
        dec=d;
        bin=Long.toBinaryString(dec);
    }
    
    public Markov(String b){ //Constructor, en base a un String como posible número binario.
        
        if(validarBinario(b)){
            bin=prepararBinario(b);
            dec=binarioADecimal(b);
        }else{
            bin=null;
            dec=0;
        }       
        
    }
    
    
    // ******* métodos importantes *******
    
    
    public String multiplicacion(){ //Este método PREPARA los elementos necesarios para la ejecución del algoritmo de Markov.
        String resultado=null;
        if(this.bin!=null){
            StringBuilder x=new StringBuilder(this.bin);
            
            int i=this.bin.length()-1;
            int cn=this.getDigito(x.toString(),i);

            x.setCharAt(i, 'A'); // Se realiza el primer paso del "algoritmo de markov".
            if(cn==0){

                x.append('0');
            }

            if(cn==1){
                x.append('1');               
            }          

            resultado=this.algoritmoMarkov(x).toString(); // Ejecuta el "algoritmo de Markov" y convierte el resultado en un String.
        }   
         
        return resultado;
    }
    
    private StringBuilder algoritmoMarkov(StringBuilder numb){ //ESTE ES EL METODO PRINCIPAL DEL ALGORITMO DE MARKOV, PARA LA MULTIPLICACIÓN POR 3, DE UN NÚMERO BINARIO.
        
        String x=numb.toString();
        
        String regex="[01b]?[ABCDEFGH][01b]"; //Expresión regular, para la busqueda de un patrón. (Todavía esta en modo de prueba, no es definitiva.)
        
        Pattern patron = Pattern.compile(regex);
        Matcher comparador=patron.matcher(x);
        
        String regexLetra="[ABCDEFGH]";
        Pattern patronLetra= Pattern.compile(regexLetra);            
        
        if(comparador.find()){
            int i = comparador.groupCount();
            String x1=comparador.group(i);
            int iprin=comparador.start(i);
            int ifin=comparador.end(i);
            
            Matcher comparadorLetra=patronLetra.matcher(x1);
            
            System.out.println("La coincidencia encontrada es: "+x1);
            
            String x2=null;
            
            if(comparadorLetra.find()){
                String letra=comparadorLetra.group();
                System.out.println("Con la letra: "+letra);
                
                if(x1.length()==2){
                    x1="b"+x1;
                }
                
                switch(letra){
                    case "A":
                        x2=this.procesarA(x1);
                        break;
                    case "B":
                        x2=this.procesarB(x1);                        
                        break;
                    case "C":
                        x2=this.procesarC(x1);                        
                        break;                        
                    case "D":
                        x2=this.procesarD(x1);                        
                        break;                        
                    case "E":
                        x2=this.procesarE(x1);                        
                        break;                        
                    case "F":
                        x2=this.procesarF(x1);                        
                        break;                        
                    case "G":
                        x2=this.procesarG(x1);                        
                        break;                        
                    case "H":
                        x2=this.procesarH(x1);                        
                        break;
                }
                
                if(x2!=null){
                    System.out.println("Antes del reemplazo: "+numb);
                    numb.replace(iprin, ifin,x2);
                    while(numb.charAt(0)=='b'){
                        numb.deleteCharAt(0);
                    }
                    System.out.println("Despues del reemplazo: "+numb);
                }
                
            }
            
            
        }
        x=numb.toString();
        Matcher comparador2=patronLetra.matcher(x);
        if(comparador2.find()){
            numb=algoritmoMarkov(numb);
        }     
       
        
        return numb;
    }
    
    
    private String procesarA(String p){
        String x=null;
        if(p.length()==3){
           char c=p.charAt(2);
           switch(c){
                case '0':
                    x="B"+p.charAt(0)+"0";
                    break;
                case '1':
                    x="E"+p.charAt(0)+"1";
                    break;
                case 'b':
                    x=p.charAt(0)+"00";
                    break;
           }
        }
               
        return x;
    }
    
    
    private String procesarB(String p){
        String x=null;
        if(p.length()==3){
           char c=p.charAt(2);
           switch(c){
                case '0':
                    x="A"+p.charAt(0)+"0";
                    break;
                case '1':
                    x="C"+p.charAt(0)+"1";
                    break;
                case 'b':
                    x=p.charAt(0)+"00";
                    break;
           }
        }
               
        return x;
    }
    
    private String procesarC(String p){
        String x=null;
        if(p.length()==3){
           char c=p.charAt(2);
           switch(c){
                case '0':
                    x="D"+p.charAt(0)+"1";
                    break;
                case '1':
                    x="F"+p.charAt(0)+"0";
                    break;
                case 'b':
                    x=p.charAt(0)+"b1";
                    break;
           }
        }
               
        return x;
    }
    
    
    private String procesarD(String p){
        String x=null;
        if(p.length()==3){
           char c=p.charAt(2);
           switch(c){
                case '0':
                    x="A"+p.charAt(0)+"0";
                    break;
                case '1':
                    x="C"+p.charAt(0)+"1";
                    break;
                case 'b':
                    x=p.charAt(0)+"bb";
                    break;
           }
        }
               
        return x;
    }
    
    private String procesarE(String p){
        String x=null;
        if(p.length()==3){
           char c=p.charAt(2);
           switch(c){
                case '0':
                    x="D"+p.charAt(0)+"1";
                    break;
                case '1':
                    x="F"+p.charAt(0)+"0";
                    break;
                case 'b':
                    x=p.charAt(0)+"b1";
                    break;
           }
        }
               
        return x;
    }
    
    private String procesarF(String p){
        String x=null;
        if(p.length()==3){
           char c=p.charAt(2);
           switch(c){
                case '0':
                    x="G"+p.charAt(0)+"0";
                    break;
                case '1':
                    x="F"+p.charAt(0)+"1";
                    break;
                case 'b':
                    x=p.charAt(0)+"10";
                    break;
           }
        }
               
        return x;
    }
    
    private String procesarG(String p){
        String x=null;
        if(p.length()==3){
           char c=p.charAt(2);
           switch(c){
                case '0':
                    x="A"+p.charAt(0)+"1";
                    break;
                case '1':
                    x="H"+p.charAt(0)+"0";
                    break;
                case 'b':
                    x=p.charAt(0)+"bb";
                    break;
           }
        }
               
        return x;
    }
    
    
    private String procesarH(String p){
        String x=null;
        if(p.length()==3){
           char c=p.charAt(2);
           switch(c){
                case '0':
                    x="G"+p.charAt(0)+"0";
                    break;
                case '1':
                    x="F"+p.charAt(0)+"1";
                    break;
                case 'b':
                    x=p.charAt(0)+"10";
                    break;
           }
        }
               
        return x;
    }
    
    // ******* métodos secundarios *******
    
    private String prepararBinario(String numb){ //Se limpia el String, quitando todos los ceros de la izquierda.
        StringBuilder num=new StringBuilder(numb);
        while(num.charAt(0)=='0'){
            num.deleteCharAt(0);
        }
        return num.toString();
    }
    
    
    private int getDigito(String bnum, int indice){ //Este método devuelve un entero, con el dígito que se extrae de String[indice].
        char c=bnum.charAt(indice);
        int cn=-1;
        try{
            cn=Integer.parseInt(Character.toString(c));

        }catch(NumberFormatException e){
            return -1;
        }
        return cn;
    }
    
    
    public static long binarioADecimal(String bnum) { //Este método convierte un numero binario (String) a un número decimal (Entero).
        long decimal = 0;
        if(validarBinario(bnum)){
          decimal =Long.parseLong(bnum, 2);
        }    
        
        return decimal;
    } 
    
    public static boolean validarBinario(String bnum){ //Este método, valida si el String es o no, un número binario.
        int i=bnum.length();
        for(i=i-1;i>=0;i=i-1){
           char c=bnum.charAt(i);
           int cn;
           try{
           cn=Integer.parseInt(Character.toString(c));
           
           }catch(NumberFormatException e){
               return false;
           }
           if(cn!=0 && cn!=1){
               return false;
           }
           
        } 
        return true;
    }
    
    public long getDecimal(){
        return this.dec;
    }
    
    public String getBinario(){
        return this.bin;
    }
    
}

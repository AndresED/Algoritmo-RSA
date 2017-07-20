package Modelos;
import java.util.ArrayList;
public class RSA {
    private long n, q, p;
    private long fi,e,d;
    private String mensaje;
    private String cifrado;
    private String MensajeLimpio;
    private String num_letra;
    private String CadenaDescifradaNumeros;
    public RSA()
    {
        //this.p=43;
        //this.q=59;
        //this.e=13;
        GenerarKey();
    }

    public String getCadenaDescifradaNumeros() {
        return CadenaDescifradaNumeros;
    }

    public String getNum_letra() {
        return num_letra;
    }



    public String getMensajeLimpio() {
        return MensajeLimpio;
    }

    public long getN() {
        return n;
    }

    public long getQ() {
        return q;
    }

    public long getP() {
        return p;
    }

    public long getFi() {
        return fi;
    }

    public long getE() {
        return e;
    }

    public long getD() {
        return d;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getCifrado() {
        return cifrado;
    }
    public void RecibirMensaje(String m)
    {
        this.mensaje=m;
    }
    public void RecibirCifrado(String c)
    {
        this.cifrado=c;
    }
    public boolean primo(int n)
    {
	for(int i=2;i<n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
	return true;
    }
    public void GenerarPrimos()
    {
        Boolean resP,resQ;
        do
        {
            p = (int)(Math.random()*(100-10+1)+10); 
            q = (int)(Math.random()*(100-10+1)+10); 
            resP=primo((int) p);
            resQ=primo((int) q);
        }while((p==q)||(resP==false)||(resQ==false));
        System.out.println("P:"+p);
        System.out.println("Q:"+q);
    }
    public int GenerarE()
    {
        Boolean resE;
        long mcd[]= new long[3];
        Euclides euclides = new Euclides();
        do
        {
            e = (int)(Math.random()*(100-1+1)+1);
            resE=primo((int) e);
            mcd=euclides.euclidesExtendido(e, fi);
        }while((e>=fi)||(mcd[0]!=1)||(resE==false));
        return (int) e;
    }
    public void GenerarKey()
    {
        GenerarPrimos();
        Inverso inverso= new Inverso();
        n=p*q;
        fi=(p-1)*(q-1);
        e=GenerarE();
        d=(long) inverso.CalcularInverso(e,fi);
        if(d<0)
        {
            d=d+fi;
        }  
        System.out.println("n: "+n);
        System.out.println("fi: "+fi);
        System.out.println("e: "+e);
        System.out.println("d: "+d);
    }
    public String EliminarEspaciosCaracteresEspeciales()
    {
        //Eliminando los espacios y caracteres especiales
        String AlfabetoValido="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String aux_mensaje="";
        int contador=0;
        for(int i=0;i<mensaje.length();i++)
        {
            for(int j=0;j<AlfabetoValido.length();j++)
            {
                if(!String.valueOf(mensaje.charAt(i)).equals(String.valueOf(AlfabetoValido.charAt(j))))
                {
                    contador++;
                }
            }
            if(contador>=AlfabetoValido.length())
            {
                //AL EVALUAR EL CARACTER CON TODOS LOS ELEMENTOS DE LA CADENA UNA DEBE DE COINCIDIR POR LO QUE EL VALOR DEL CONTADOR DEBE SER UNO MENOS QUE
                //EL DEL TAMAÑO DE ALFABETOVALIDO, SI SON IGUALES O ES MAYOR SIGNIFICA QUE ESE CARACTER NO ES VALIDO Y DEBE SER IGNORADO
            }
            else
            {
                aux_mensaje=aux_mensaje+mensaje.charAt(i);//CREANDO UNA NUEVA CADENA SIN ESPACIOS
            }
            contador=0;
        }
        //En el caso de que falten caracteres para la agrupacion de 4, se completan con un x
        if(aux_mensaje.length()%2!=0)
        {
            aux_mensaje=aux_mensaje+"X";
        }
        return aux_mensaje;
    }
    public String ConvertirNumeros(String mensaje_sin_espacios)
    {
        int aux_num_letra;
        num_letra ="";
        Conversor letras= new Conversor();
        for(int i=0;i<mensaje_sin_espacios.length();i++)
        {
            //Realizando la conversion a numeros
            aux_num_letra=letras.numero(String.valueOf(mensaje_sin_espacios.charAt(i)));
            num_letra=num_letra+letras.numeroletra(aux_num_letra);
           
        }
        return num_letra;
    }
    public String ConvertirCadena(String cadenacifrada)
    {
        Conversor letras= new Conversor();
        int inicioC=0,finalC=2;
        String TextoCifrado="",aux_TextoCifrado;
        for(int i=0;i<cadenacifrada.length();i++)
        {
            aux_TextoCifrado=cadenacifrada.substring(inicioC,finalC);
            if(Integer.parseInt(aux_TextoCifrado)>25)
            {
                aux_TextoCifrado=String.valueOf(Integer.parseInt(aux_TextoCifrado)%26);
            }
            TextoCifrado=TextoCifrado+letras.letranumero(Integer.parseInt(aux_TextoCifrado));//CREANDO UNA NUEVA CADENA SIN ESPACIOS
            inicioC=finalC;
            finalC=finalC+2;
            i=inicioC;
        }
        return TextoCifrado;
    }
    public String Cifrar(String num_letra)
    {
        Exponenciacion expo= new Exponenciacion();
        ArrayList<String> Cifrado = new ArrayList<>();
        int inicioC=0,finalC=4,rexpo = 0;
        String auxiliar;
        for(int i =0 ;i<num_letra.length();i++)
        {
            auxiliar=num_letra.substring(inicioC,finalC);
            System.out.println("SUBCADENA ANTES DE CIFRAR: "+auxiliar);
            //Realizando operacion de encriptado
            rexpo=expo.CalcularExp(Integer.parseInt(auxiliar),(int)e,(int)n);
            System.out.println("YA ME CIFRARON: "+rexpo);
            //ALMACENANDO
            if(String.valueOf(rexpo).length()==1)
            {
                Cifrado.add("000"+String.valueOf(rexpo));
            }
            if(String.valueOf(rexpo).length()==2)
            {
                Cifrado.add("00"+String.valueOf(rexpo));
            }
            if(String.valueOf(rexpo).length()==3)
            {
                Cifrado.add("0"+String.valueOf(rexpo));
            }
            if(String.valueOf(rexpo).length()==4)
            {
                Cifrado.add(String.valueOf(rexpo));
            }
            inicioC=finalC;
            finalC=finalC+4;
            i=inicioC;
        }
        //Guardando todo en una sola cadena
        String cadena="";
        for(int i=0;i<Cifrado.size();i++)
        {
            cadena=cadena+Cifrado.get(i);
        }
        System.out.println("A MI TIENEN QUE DESCIFRARME: "+cadena);
        RecibirCifrado(cadena);//SALVANDO C , QUE SERA USADO PARA DESENCRIPTAR
        return cadena; 
    }
    public String Descifrar()
    {
        Exponenciacion expo= new Exponenciacion();
        ArrayList<String> Descifrado = new ArrayList<>();
        int inicioC=0,finalC=4,rexpo = 0;
        String auxiliar;
        System.out.println("SOY EL MENSAJE CIFRADO: "+cifrado);
        for(int i =0 ;i<cifrado.length();i++)
        {
            auxiliar=cifrado.substring(inicioC,finalC); 
            System.out.println("SOY UNA SUBCADENA DEL MENSAJE CIFRADO ANTES DE SER DESCIFRADO: "+auxiliar);
            //Realizando operacion de encriptado
            rexpo=expo.CalcularExp(Integer.parseInt(auxiliar),(int)d,(int)n);
            System.out.println("ME DESCIFRARON: "+rexpo);
            //ALMACENANDO
            if(String.valueOf(rexpo).length()==1)
            {
                Descifrado.add("000"+String.valueOf(rexpo));
            }
            if(String.valueOf(rexpo).length()==2)
            {
                Descifrado.add("00"+String.valueOf(rexpo));
            }
            if(String.valueOf(rexpo).length()==3)
            {
                Descifrado.add("0"+String.valueOf(rexpo));
            }
            if(String.valueOf(rexpo).length()==4)
            {
                Descifrado.add(String.valueOf(rexpo));
            }
            inicioC=finalC;
            finalC=finalC+4;
            i=inicioC;
        }
        //Guardando todo en una sola cadena
        String cadena="";
        for(int i=0;i<Descifrado.size();i++)
        {
            cadena=cadena+Descifrado.get(i);
        }
        return cadena; 
    }
    public String OperacionRSAEncriptar()
    {
        //Generando llaves - ESTE PROCESO SE REALIZA EN EL METODO CONSTRUCTOR , AQUI SOLO LO INDICAMOS
        //Eliminando espacios y caracteres especiales
        MensajeLimpio=EliminarEspaciosCaracteresEspeciales();
        //Realizando conversion de texto a numeros
        System.out.println("SOY EL MENSAJE LIMPIO: "+MensajeLimpio);
        num_letra=ConvertirNumeros(MensajeLimpio);
        System.out.println("CADENA ANTERIOR PERO EN NUMEROS: "+num_letra);
        //Cifrando
        String cadena;
        cadena=Cifrar(num_letra);
        System.out.println("Soy el cifrado"+this.cifrado);
        //Realizando conversion de numeros a letras
        String TextoFinal;
        TextoFinal=ConvertirCadena(cadena);
        return TextoFinal;
    }
    public String OperacionRSADesencriptar()
    {
        CadenaDescifradaNumeros=Descifrar();
        String TextoFinal;
        TextoFinal=ConvertirCadena(CadenaDescifradaNumeros);
        return TextoFinal;
    }
}



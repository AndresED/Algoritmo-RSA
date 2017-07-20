package Modelos;
public class Conversor {
    public int numero(String a){
        int C=-666;
        if(a.equals(" ")){
            C=-555;
        }else if(a.equals("a")||a.equals("A")){
            C=0;
        }else if(a.equals("b")||a.equals("B")){
            C=1;
        }else if(a.equals("c")||a.equals("C")){
            C=2;
        }else if(a.equals("d")||a.equals("D")){
            C=3;
        }else if(a.equals("e")||a.equals("E")){
            C=4;
        }else if(a.equals("f")||a.equals("F")){
            C=5;
        }else if(a.equals("g")||a.equals("G")){
            C=6;
        }else if(a.equals("h")||a.equals("H")){
            C=7;
        }else if(a.equals("i")||a.equals("I")){
            C=8;
        }else if(a.equals("j")||a.equals("J")){
            C=9;
        }else if(a.equals("k")||a.equals("K")){
            C=10;
        }else if(a.equals("l")||a.equals("L")){
            C=11;
        }else if(a.equals("m")||a.equals("M")){
            C=12;
        }else if(a.equals("n")||a.equals("N")){
            C=13;
        }else if(a.equals("o")||a.equals("O")){
            C=14;
        }else if(a.equals("p")||a.equals("P")){
            C=15;
        }else if(a.equals("q")||a.equals("Q")){
            C=16;
        }else if(a.equals("r")||a.equals("R")){
            C=17;
        }else if(a.equals("s")||a.equals("S")){
            C=18;
        }else if(a.equals("t")||a.equals("T")){
            C=19;
        }else if(a.equals("u")||a.equals("U")){
            C=20;
        }else if(a.equals("v")||a.equals("V")){
            C=21;
        }else if(a.equals("w")||a.equals("W")){
            C=22;
        }else if(a.equals("x")||a.equals("X")){
            C=23;
        }else if(a.equals("y")||a.equals("Y")){
            C=24;
        }else if(a.equals("z")||a.equals("Z")){
            C=25;
        }
        return C;
    }
    
    public String numeroletra(int a){
        String C=null;
        if(a==-555){
            C=" ";
        }else if(a==0){
            C="00";
        }else if(a==1){
            C="01";
        }else if(a==2){
            C="02";
        }else if(a==3){
            C="03";
        }else if(a==4){
            C="04";
        }else if(a==5){
            C="05";
        }else if(a==6){
            C="06";
        }else if(a==7){
            C="07";
        }else if(a==8){
            C="08";
        }else if(a==9){
            C="09";
        }else if(a==10){
            C="10";
        }else if(a==11){
            C="11";
        }else if(a==12){
            C="12";
        }else if(a==13){
            C="13";
        }else if(a==14){
            C="14";
        }else if(a==15){
            C="15";
        }else if(a==16){
            C="16";
        }else if(a==17){
            C="17";
        }else if(a==18){
            C="18";
        }else if(a==19){
            C="19";
        }else if(a==20){
            C="20";
        }else if(a==21){
            C="21";
        }else if(a==22){
            C="22";
        }else if(a==23){
            C="23";
        }else if(a==24){
            C="24";
        }else if(a==25){
            C="25";
        }
        return C;
    }
    
    public String letranumero(int a){
        String C=null;
        if(a==-555){
            C=" ";
        }else if(a==0){
            C="A";
        }else if(a==1){
            C="B";
        }else if(a==2){
            C="C";
        }else if(a==3){
            C="D";
        }else if(a==4){
            C="E";
        }else if(a==5){
            C="F";
        }else if(a==6){
            C="G";
        }else if(a==7){
            C="H";
        }else if(a==8){
            C="I";
        }else if(a==9){
            C="J";
        }else if(a==10){
            C="K";
        }else if(a==11){
            C="L";
        }else if(a==12){
            C="M";
        }else if(a==13){
            C="N";
        }else if(a==14){
            C="O";
        }else if(a==15){
            C="P";
        }else if(a==16){
            C="Q";
        }else if(a==17){
            C="R";
        }else if(a==18){
            C="S";
        }else if(a==19){
            C="T";
        }else if(a==20){
            C="U";
        }else if(a==21){
            C="V";
        }else if(a==22){
            C="W";
        }else if(a==23){
            C="X";
        }else if(a==24){
            C="Y";
        }else if(a==25){
            C="Z";
        }
        return C;
    }
    
}

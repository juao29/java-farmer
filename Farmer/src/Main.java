import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var tamanhoX = 20;
        var tamanhoY = 20;

        var qtdMaxMeteoritos = 10;

        //entrada da fazenda

        var entrada = new Scanner(System.in);
        System.out.print("Digite as coordenadas x1 y1 x2 y2: ");
        var coordenadas =  entrada.nextLine().split(" ");

        var x1 = Integer.parseInt(coordenadas[0]);
        var y1 = Integer.parseInt(coordenadas[1]);
        var x2 = Integer.parseInt(coordenadas[2]);
        var y2 = Integer.parseInt(coordenadas[3]);

        if (0 >= x1 || x1 > x2 || x2 >= tamanhoX) {
            System.out.println("entrada inválida X, por favor reinicie o programa");
            return;
        }

        if(0 >= y1 || y1 > y2 || y2 >= tamanhoY){
            System.out.println("entrada inválida Y, por favor reinicie o programa");
            return;
        }

        System.out.print("Digite a quantidade de meteoritos que cairam: ");
        var meteoritos = Integer.parseInt(entrada.nextLine());

        if (meteoritos <= 0 || meteoritos >= qtdMaxMeteoritos) {
            System.out.println("entrada inválida, por favor reinicie o programa");
            return;
        }

        var listaCoordernadaMeteorito = new String[meteoritos];
        for(var i = 0; i < meteoritos; i++){
            System.out.print("Coordenada X Y: ");
            listaCoordernadaMeteorito[i] = entrada.nextLine();
        }

        //FIM ENTRADAS

        int meteoritosDentro = 0;
        for(var i = 0; i < tamanhoX; i++){
            for (var j = 0; j < tamanhoY; j++ ){
                if(x1 <= i && i <= x2 && y1 <= j && j <= y2){
                    var achou = false;
                    for(var coordenada : listaCoordernadaMeteorito) {
                        var partes = coordenada.split(" ");
                        var meX = Integer.parseInt(partes[0]);
                        var meY = Integer.parseInt(partes[0]);
                        if (meX == i && meY == j) {
                            achou = true;
                            break;
                        }
                    }
                    if (achou) {
                        System.out.print(" X ");
                        meteoritosDentro++;
                    } else {
                        System.out.print(" - ");
                    }
                }else{
                    System.out.print(" w ");
                }
            }
            System.out.println();
        }

        System.out.print(meteoritosDentro);
    }
}
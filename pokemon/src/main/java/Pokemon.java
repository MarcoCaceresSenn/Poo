import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Pokemon {
    private String nombre;
    private int numero;
    private int vida;
    private int vidaTotal;
    private int ataque;
    private int defensa;
    private int nivel;
    private String[] tipo;
    private ArrayList<Ataque> ataques = new ArrayList();
    Scanner leer = new Scanner(System.in);
    public Pokemon(){

    }

    public Pokemon(String nombre, int numero, String[] tipo) {
        this.nombre = nombre;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Pokemon(String nombre, int numero, int vida, int ataque, int defensa, int nivel, String[] tipo, int vidaTotal) {
        this.nombre = nombre;
        this.numero = numero;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        this.tipo = tipo;
        this.vidaTotal = vidaTotal;
    }


    @Override
    public String toString() {
        return "nombre= " + nombre +
                "\nnumero= " + numero +
                "\ntipo(s)= " + Arrays.toString(tipo);
    }

    public void agregarAtaque(Ataque a) {
        ataques.add(a);
    }

    public int atacar(Pokemon atacante, Pokemon defensor) {
        System.out.println("pokemon "+atacante+" ataca a "+ defensor);
        Ataque a = ataques.get((int) (Math.random() * ataques.size()));
        int ataqueTotal = a.getDaño() + this.ataque;
        defensor.setVida(getVida()-defensor.recibirDaño(ataqueTotal));
        return defensor.getVida();

    }

    private int recibirDaño(int ataqueTotal) {
        int daño = ataqueTotal - this.defensa;
        this.vida -= daño;
        return daño;
    }

    public void setAtaque(int ataque) {

        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {

        this.defensa = defensa;
    }
    public int getNivel(){return nivel;}

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida(){return vida;}

    public void setVidaTotal(int vidaTotal){this.vidaTotal = vidaTotal;}

    public int getVidaTotal(){return vidaTotal;}


    public void equipoCombate(Entrenador entrenador1, Entrenador entrenador2) {
        //crear equipo(llenar constructor 1)---------------------------------------------------------------------------

        System.out.println("Entrenador 1: ¿desea agregar un pokémon a su equipo?" + "\ndigíte 1: si" + "\ndigite 2: no");
        int i = leer.nextInt();
        //desición inválida--------------------------------------------------------------------------------------------

        if (i < 1 || i > 2) {
            System.out.println("ingrese 1 para (si) o 2 para (no)");
            i = leer.nextInt();
        } else {

            //pokemon entrenador 1-------------------------------------------------------------------------------------
            if (i == 1) {
                int j = 1;
                while (j == 1) {
                    System.out.println("ingrese el nombre de su pokémon:");
                    String nombrePokemon = leer.next();
                    System.out.println("ingrese el número de pokédex de su pokémon");
                    int numPokemon = leer.nextInt();
                    System.out.println("ingrese el tipo de su pokemon." +
                            "\nsi su pokémon presenta mas de un tipo ingreselos en el siguiente formato: " +
                            "tipo1,tipo2");
                    String[] tipo = {leer.next()};
                    Pokemon p1 = new Pokemon(nombrePokemon, numPokemon, tipo);
                    System.out.println("su pokémon es: ");
                    System.out.println(p1);

                    //agregar stats------------------------------------------------------------------------------------
                    System.out.println("ahora ingrese las estadísticas de su pokémon.");
                    System.out.print("ataque: ");
                    int atack = leer.nextInt();
                    p1.setAtaque(atack);
                    System.out.print("defensa: ");
                    int defensa = leer.nextInt();
                    p1.setDefensa(defensa);
                    System.out.print("vida: ");
                    int vida = leer.nextInt();
                    p1.setVida(vida);
                    p1.setVidaTotal(vida);
                    System.out.print("nivel: ");
                    int nivel = leer.nextInt();
                    p1.setNivel(nivel);
                    entrenador1.addPokemonAlEquipo(p1);

                    //agregar ataques----------------------------------------------------------------------------------
                    int numAtaque = 0;
                    while (numAtaque < 4) {
                        System.out.println("ingrese el ataque número " + (numAtaque + 1) +
                                "\n recuerde que son máximo 4 ataques");
                        System.out.print("nombre: ");
                        String nombreAt = leer.next();
                        System.out.print("daño: ");
                        int DA = leer.nextInt();
                        System.out.print("tipo de ataque: ");
                        String tipoAtaque = leer.next();
                        Ataque a = new Ataque(nombreAt, DA, tipoAtaque);
                        p1.agregarAtaque(a);
                        numAtaque++;
                    }
                    System.out.println("¿desea agregar otro pokémon? 1:si, 2:no");
                    j = leer.nextInt();
                    if (j < 1 || j > 2) {
                        System.out.println("numero de operación inválido. Operación cancelada");

                    } else {
                        if (j == 1) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                    }
                }
            } else {
                System.out.print("usted a marcado (no)");

            }
        }


        // crear equipo(llenar constructor 2)--------------------------------------------------------------------------
        int ii = 0;
        while (ii < 1 || ii > 2) {
            System.out.println("Entrenador 2: ¿desea agregar un pokémon a su equipo?" + "\ndigíte 1: si" + "\ndigite 2: no");
            ii = leer.nextInt();

            //desicion invalida----------------------------------------------------------------------------------------
            if (ii < 1 || ii > 2) {
                System.out.println("desición inválida: ingrese 1 para (si) o 2 para (no)");
                ii = leer.nextInt();
            } else {
                if (ii == 1) {
                    int j = 1;
                    while (j == 1) {

                        //pokemon entrenador 2-------------------------------------------------------------------------
                        System.out.println("ingrese el nombre de su pokémon:");
                        String nombrePokemon = leer.next();
                        System.out.println("ingrese el número de pokédex de su pokémon");
                        int numPokemon = leer.nextInt();
                        System.out.println("ingrese el tipo de su pokemon." +
                                "\nsi su pokémon presenta mas de un tipo ingreselos en el siguiente formato: " +
                                "tipo1,tipo2");
                        String[] tipo = {leer.next()};

                        //agregar stats--------------------------------------------------------------------------------
                        System.out.println("ahora ingrese las estadísticas de su pokémon.");
                        System.out.print("ataque: ");
                        int atack = leer.nextInt();
                        System.out.print("defensa: ");
                        int defensa = leer.nextInt();
                        System.out.print("vida: ");
                        int vida = leer.nextInt();
                        System.out.print("nivel: ");
                        int nivel = leer.nextInt();
                        Pokemon p2 = new Pokemon(nombrePokemon, numPokemon, vida, atack, defensa, nivel, tipo, vida);
                        System.out.println("su pokémon es: ");
                        System.out.println(p2);
                        entrenador2.addPokemonAlEquipo(p2);
                        //agregar ataques----------------------------------------------------------------------------------
                        int numAtaque = 0;
                        while (numAtaque < 4) {
                            System.out.println("ingrese el ataque número " + (numAtaque + 1) + "\n recuerde que son máximo 4 ataques");
                            System.out.print("nombre: ");
                            String nombreAt = leer.next();
                            System.out.print("daño: ");
                            int DA = leer.nextInt();
                            System.out.print("tipo de ataque: ");
                            String tipoAtaque = leer.next();
                            Ataque a = new Ataque(nombreAt, DA, tipoAtaque);
                            p2.agregarAtaque(a);
                            numAtaque++;
                        }
                        System.out.println("¿desea agregar otro pokémon? 1:si, 2:no");
                        j = leer.nextInt();
                        if (j < 1 || j > 2) {
                            System.out.println("numero de operación inválido. Operación cancelada");
                        } else {
                            if (j == 1) {
                                ii = 1;
                            } else {
                                ii = 2;
                            }
                        }
                    }
                }   else { System.out.print("usted a marcado (no)");

                    }
            }
        }
    }
}






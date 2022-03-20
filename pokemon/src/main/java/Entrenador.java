import java.util.ArrayList;
public class Entrenador {
    //atributos: pokemones ()
    private String nombreEntrenador;
    private ArrayList<Pokemon> equipo = new ArrayList();
    private ArrayList<Pokemon> PC = new ArrayList();

    //metodos: desafiar(a otro entrenador),

    public Entrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public ArrayList<Pokemon> getPC() {
        return PC;
    }

    public ArrayList<Pokemon> getEquipo() {
        return equipo;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.equipo = pokemons;
    }

    public void setPC(ArrayList<Pokemon> PC) {
        this.PC = PC;
    }

//agregar pokemon al equipo-------------------------------------------------------------------------------------------

    public void addPokemonAlEquipo(Pokemon pokemon){
        if(equipo.size()<6){
            equipo.add(pokemon);
        }
        else {
            System.out.println("su equipo está lleno, su pokémon será transferido a su PC");
            agregarPC(pokemon);
        }
    }

    //agregar pokemon al PC--------------------------------------------------------------------------------------------
    public void agregarPC(Pokemon pokemon){
        PC.add(pokemon);
    }


    public void mostrarPC(){
        System.out.println("Pokemons en PC:");
        System.out.println(getPC());
    }

}

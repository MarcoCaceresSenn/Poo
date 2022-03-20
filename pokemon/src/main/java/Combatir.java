public class Combatir {

    public Combatir(Entrenador entrenador1, Entrenador entrenador2){
        int finCombate = 0;
        System.out.println(entrenador1.getNombreEntrenador()+" desea combatir con "+entrenador2.getNombreEntrenador());
        System.out.println("HORA DE ARMAR LOS EQUIPOS");
        Pokemon batalla = new Pokemon();
        batalla.equipoCombate(entrenador1,entrenador2);
        //indice para restaurarle la vida al pokémon(linea 50)--------------------------------------------------------
        int i = 0;
        //------------------------------------------------------------------------------------------------------------
        while(finCombate == 0){
            int turno = 1;
            int pokemonBatallando1 = 0;
            int pokemonBatallando2 = 0;
            if(entrenador1.getEquipo().get(pokemonBatallando1).getVida()>0 && entrenador2.getEquipo().get(pokemonBatallando2).getVida()>0){
                if(entrenador1.getEquipo().get(pokemonBatallando1).getNivel() > entrenador2.getEquipo().get(pokemonBatallando2).getNivel()){
                batalla.atacar(entrenador1.getEquipo().get(pokemonBatallando1),entrenador2.getEquipo().get(pokemonBatallando2));
                batalla.atacar(entrenador2.getEquipo().get(pokemonBatallando2),entrenador1.getEquipo().get(pokemonBatallando1));
                }
                else{
                    batalla.atacar(entrenador2.getEquipo().get(pokemonBatallando2),entrenador1.getEquipo().get(pokemonBatallando1));
                    batalla.atacar(entrenador1.getEquipo().get(pokemonBatallando1),entrenador2.getEquipo().get(pokemonBatallando2));
                }

                //cambio de pokemon del equipo-------------------------------------------------------------------------
                if(entrenador1.getEquipo().get(pokemonBatallando1).getVida()<=0){
                    pokemonBatallando1++;
                }
                else{
                    if(entrenador2.getEquipo().get(pokemonBatallando2).getVida()<=0){
                        pokemonBatallando2++;
                    }
                }
                System.out.println("fin del turno "+turno);
                turno++;
            }
            else{
                System.out.println("EL COMBATE A TERMINADO"+"\nEL GANADOR ES");
                if(entrenador1.getEquipo().get(pokemonBatallando1).getVida()>0){
                System.out.println(entrenador1);

                }
                else{
                    System.out.println(entrenador2);
                }
                finCombate = 1;
            }
        }
//aqui se curan los pokemon y el indice recorre el tamaño máximo del equipo--------------------------------------------
    while(i < 6){
    Enfermera curarPokemons = new Enfermera(entrenador1.getEquipo().get(i).getVidaTotal());
    i++;
//---------------------------------------------------------------------------------------------------------------------
    }

    }

}
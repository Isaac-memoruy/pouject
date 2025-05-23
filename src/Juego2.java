import java.util.Scanner;
import java.util.Random;

//!! Clase base 
class Personaje {
    String nombre;
    int vida_hp;
    int fuerza;
    int velocidad;

    // * Constructor de el objeto personaje */
    public Personaje(String nombre, int vida_hp, int fuerza, int velocidad) {

        this.nombre = nombre;
        this.vida_hp = vida_hp;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
    }

    // Ahora estos métodos funcionaran dentro del padre y sus subclases/
    public boolean estaVivo() {
        return vida_hp > 0;
    }
}

// Todo: Subclase "Jugador" con los atributos de "Personaje"//
class Jugador extends Personaje {
    // *Constructor */
    Random aleatorio = new Random();

    public Jugador(String nombre, int vida_hp, int fuerza, int velocidad) {
        // *La palabra "super" hace que los atributos de la clase principal se hereden a
        // *la subclase "Jugador" */
        super(nombre, vida_hp, fuerza, velocidad);
    }

    // ? Métodos de Jugador, no se podrán usar en la clase padre ya que estos son sus subclases.
    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca a " + enemigo.nombre + " con " + fuerza);
        enemigo.vida_hp -= this.fuerza;
    }

    public void defenderse(Personaje enemigo) {
        System.out.println(nombre + " se defiende de ataque del " + enemigo.nombre + " con su escudo, ataque reducido a la mitad.");
        int dañoReducido = enemigo.fuerza / 2;
        this.vida_hp -= dañoReducido;
    }

    public boolean escapar() {
        boolean escape = (aleatorio.nextInt(100) + this.velocidad) < 50;
        if (escape) {
            System.out.println("Has logrado escapar");
        } else {
            System.out.println("no has logrado escapar");
        }
        return escape;
    }
}

// Todo: Subclase "Enemigo" con los atributos de "Personaje"//
class Enemigo extends Personaje {
    // *Constructor */
    public Enemigo(String nombre, int vida_hp, int fuerza, int velocidad) {
        super(nombre, vida_hp, fuerza, velocidad);
    }

    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca causando  " + fuerza + " de daño.");
        enemigo.vida_hp -= this.fuerza;
    }
}

// ! Clase principal
public class Juego2 {
    // !Metodo de batalla del juego//
    public static void pelear(Jugador jugador, Enemigo enemigo) {
        Scanner scannerPelea = new Scanner(System.in);
        boolean escapar = false;
        //Bucle para que acabe al cualquiera de los 2 morir o el jugador escape escapar= verdadero/
        while (jugador.estaVivo() && enemigo.estaVivo() && !escapar ) {
               //*Estado en cada turno */
            System.out.println("=======================================");
            System.out.println("Vida:");
            System.out.println(jugador.nombre + ": "+jugador.vida_hp+" HP");
            System.out.println("\nVida del " + enemigo.nombre);
            System.out.println(enemigo.nombre + ": "+enemigo.vida_hp+" HP");
            System.out.println("=======================================");
            System.out.println("\n¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Protegerse");
            System.out.println("3. Huir");
            System.out.print("Elige una opción: ");
            int opcion = scannerPelea.nextInt();
            //*Comandos de acción */
            switch (opcion) {
                //*Atacar */
                case 1:
                System.out.println("=======================================");
                    jugador.atacar(enemigo);
                    if (enemigo.estaVivo()) {
                        enemigo.atacar(jugador);
                        }
                    break;
                
                    //*Defenderse */
                    case 2:
                    System.out.println("=======================================");
                    jugador.defenderse(enemigo);
                    break;
                    
                    //*Escapar */
                    case 3:
                    escapar = jugador.escapar();
                    System.out.println("=======================================");
                    if (!escapar && enemigo.estaVivo()){
                        enemigo.atacar(jugador);
                    }else if (escapar){
                        System.out.println("\nlograste escapar con exito, dejando atras tus huellas...");
                        System.out.println("en el reino seguira dominando la oscuridad, pero tendras otra oportunidad para pelear");
                        System.exit(0);
                    }
                    break;

                default:
                System.out.println("Opcion no válida. Inténtelo de nuevo");
                System.out.println("=======================================");
                    break;
            }
        }
        //*Fuera del bucle, determinar resultado de la pelea */
        if(jugador.estaVivo()){
            System.out.println("¡Has derrotado al " + enemigo.nombre + "! ¡Felicidades!");
        }else{
            System.out.println("\nHas sido derrotado en la mazmorra...");
            System.out.println("La llave de la muerte destinada que prometia sacar al reino de la oscuridad seguira perdida, levantate guerrero.");
            System.out.println("algun dia llegaras a la llave y le daras luz a quienes buscan descansar, debes seguir luchando");
            System.out.println("¡Fin del juego!, o quizas solo un descanso?");
            System.exit(0);
        }
        scannerPelea.close();
    }

    public static void main(String[] args) throws Exception {
        // *Crear Jugador y Enemigo */
        Jugador jugador = new Jugador("Tiznado", 50, 10, 7);
        Enemigo esqueleto = new Enemigo("Esqueleto", 40, 12, 5);
        Scanner scanner = new Scanner(System.in);
        // *Introducción //
        System.out.println("=======================================");
        System.out.println("\"Escucha bien, sinluz…");
        System.out.println();
        System.out.println("\"hace mucho tiempo, cuando los Dioses y Semidioses vivian en guerra por el territorio, solo una llave, la llave de la muerte destinada podia hacer que quienes deseaban descansar pudieran hacerlo...");
        System.out.println("sus creadores, los Dioses, peleaban por tenerla y reinar sobre la vida de los mortales");
        System.out.println("de las llamas surgia el dolor y la ambicion por territorio, las almas de las personas, sobre todo la de los guerreros no podian descansar en paz\"");
        System.out.println();
        System.out.println("\"Pero del dolor surgieron los sinluz, quienes con sus damas guias buscaban la forma de detener la eternidad de guerras");
        System.out.println("la llave, protagonica de muchas tragedias, ahora se vuelve a pieza clave para darle fin a la guerra infinita, sin embargo, se encuentra en manos equivocadas\"");
        System.out.println();
        System.out.println("\"en la mazmorra, donde se encuentra una criatura sin corazon o alma, yace la llave, exidada por la sangre de las muertes que provoco\"");
        System.out.println();
        System.out.println("\"Tú, " + jugador.nombre + ", eres el sinluz, quien su dama a escogido por hazañas increibles en tu tiempo de vida, eres nuestro último rayo de esperanza.");
        System.out.println("Toma tu espada y tu escudo, y adéntrate en las profundidades de la mazmorra.");
        System.out.println("solo con la llave de la muerte destinada, podremos darle fin a quienes con su inmortalidad, dieron dolor a los mortales, volviendose simples peones\"");
        System.out.println();
        System.out.println("\"Recuerda, joven sin luz... cada llama contiene su ira y cada estrella su esperanza ");
        System.out.println("solo tu puedes escoger que camino tomar, ¿deseas abrazar lo que amas sacrificando todo lo demas?\"");
        System.out.println();
        System.out.println("\"¿Estás listo para entrar en la mazmorra, enfrentarte al guardián y reclamar la llave de la muerte destinada?\"");
        System.out.println();

        // *Comenzar Juego//
        while (true) {
            System.out.println("=======================================");
            System.out.println();
            System.out.println("1.Comenzar la aventura.");
            System.out.println("2.Salir del juego");
            System.out.println("Elige una opción");
            int opcion = scanner.nextInt();
            if (opcion == 2) {
                System.exit(2);
            } else if (opcion == 1) {
                break;
            } else {
                System.out.println("Opción no valida. Inténtalo de nuevo ");
            }
        }
        System.out.println("=======================================");
        System.out.println("A tu alrededor, las sombras se alargan y crujen los huesos de viejas batallas.\n");
        System.out.println("De repente, escuchas un ruido sordo y seco. Frente a ti, entre la penumbra, surge una figura huesuda.");
        System.out.println("¡Es un " + esqueleto.nombre + ", un guerrero caído del pasado, que ha regresado para proteger este lugar!\n");
        System.out.println("Su calavera te observa con vacío en los ojos, pero puedes sentir la amenaza de su presencia.\n");
        System.out.println("¡Prepárate para luchar por tu vida " + jugador.nombre + "!");
        //*Método de batalla */ 
        pelear(jugador, esqueleto);
        System.out.println("\n¡Has derrotado al enemigo y has recuperado la llave de la muerte destinada !");
        System.out.println("Sostienes la llave de la muerte destinada y sientes como quienes anhelaban la paz eterna, pueden descansar en paz");
        System.out.println("¡La paz ha sido restaurada, y serás recordado como un héroe por generaciones!");
        scanner.close();
    }
}
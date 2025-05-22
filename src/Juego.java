import java.util.Scanner;
import java.util.Random;

//!! Clase base 
class Personaje {
    String nombre;
    int vida_hp;
    int fuerza;
    int velocidad;
    protected Random aleatorio = new Random();

    // * Constructor de el objeto personaje */
    public Personaje(String nombre, int vida_hp, int fuerza, int velocidad) {

        this.nombre = nombre;
        this.vida_hp = vida_hp;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
    }

    // *Ahora estos métodos funcionaran dentro del padre y sus subclases*/
    public boolean estaVivo() {
        return vida_hp > 0;
    }
}

// Todo: Subclase "Jugador" con los atributos de "Personaje"//
class Jugador extends Personaje {
    // *Constructor */
    private Random aleatorio = new Random();

    public Jugador(String nombre, int vida_hp, int fuerza, int velocidad) {
        // *La palabra "super" hace que los atributos de la clase principal se hereden a
        // *la subclase "Jugador" */
        super(nombre, vida_hp, fuerza, velocidad);
    }

    // ? Métodos de Jugador, no se podrán usar en la clase padre ya que estos son sus subclases.
    public void atacar(Personaje enemigo) {
        int probabilidadFallo = 15;
        int probabilidadCritico = 20; 

    int random = aleatorio.nextInt(100);

    if (random < probabilidadFallo) {
        System.out.println(nombre + " intenta atacar a " + enemigo.nombre + ", ¡pero falla!");
        return;
    }

   
    int dañoBase = aleatorio.nextInt((this.fuerza / 2) + 1) + (this.fuerza / 2);
    boolean esCritico = random >= (100 - probabilidadCritico);

    int dañoFinal = esCritico ? (int)(dañoBase * 1.5) : dañoBase;

    if (esCritico) {
        System.out.println("¡Golpe crítico!");
    }

    System.out.println(nombre + " ataca a " + enemigo.nombre + " causando " + dañoFinal + " de daño.");
    enemigo.vida_hp -= dañoFinal;
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
         int probabilidadFallo = 10;
    int probabilidadCritico = 15;

    int random = aleatorio.nextInt(100);

    if (random < probabilidadFallo) {
        System.out.println(nombre + " intenta atacar, ¡pero falla!");
        return;
    }

    int dañoBase = aleatorio.nextInt((this.fuerza / 2) + 1) + (this.fuerza / 2);
    boolean esCritico = random >= (100 - probabilidadCritico);
    int dañoFinal = esCritico ? (int)(dañoBase * 1.5) : dañoBase;

    if (esCritico) {
        System.out.println("¡" + nombre + " realiza un golpe crítico!");
    }

    System.out.println(nombre + " ataca causando " + dañoFinal + " de daño.");
    enemigo.vida_hp -= dañoFinal;
    }
}

// ! Clase principal
public class Juego {
    // !Metodo de batalla del juego//
    public static void pelear(Jugador jugador, Enemigo enemigo) {
        Scanner scannerPelea = new Scanner(System.in);
        boolean escapar = false;
        //*Bucle para que acabe al cualquiera de los 2 morir o el jugador escape escapar= verdadero*/
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
            System.out.println("2. Defenderse");
            System.out.println("3. Escapar");
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
                        System.out.println("\nDecidiste escapar, dejando el Cristal de la Luz Eterna atrás en la mazmorra.");
                        System.out.println("El reino seguirá en la penumbra, pero al menos, vives para pelear otro día.");
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
            System.out.println("El Cristal de la Luz Eterna permanece en las sombras, y el reino continúa sumido en la oscuridad.");
            System.out.println("Tal vez, algún día, otro héroe se atreva a intentarlo...");
            System.out.println("¡Fin del juego!");
            System.exit(0);
        }
        scannerPelea.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Jugador[] personajes = {
            new Jugador("Guerrero", 60, 12, 5),
            new Jugador("Arquero", 45, 9, 8),
            new Jugador("Mago", 40, 15, 6)
};
        System.out.println("=======================================");
        System.out.println("Elige tu personaje:");
        for (int i = 0; i < personajes.length; i++) {
            Jugador p = personajes[i];
            System.out.println((i + 1) + ". " + p.nombre + " (HP: " + p.vida_hp + ", Fuerza: " + p.fuerza + ", Velocidad: " + p.velocidad + ")");
}
        int opcionPersonaje;
        while (true) {
            System.out.print("Selecciona tu personaje (1-" + personajes.length + "): ");
            opcionPersonaje = scanner.nextInt();
            if (opcionPersonaje >= 1 && opcionPersonaje <= personajes.length) {
                break;
            } else {
        System.out.println("Opción no válida. Intenta de nuevo.");
    }
}

        Jugador jugador = personajes[opcionPersonaje - 1];
        System.out.println("\nHas elegido a: " + jugador.nombre);

        Enemigo[] enemigos = {
            new Enemigo("Esqueleto", 40, 10, 4),
            new Enemigo("Orco", 50, 14, 3),
            new Enemigo("Hechicero Oscuro", 35, 18, 6)
};

// Selección aleatoria de enemigo
Random aleatorio = new Random();
Enemigo enemigo = enemigos[aleatorio.nextInt(enemigos.length)];
System.out.println("=======================================");
System.out.println("Te enfrentarás a: " + enemigo.nombre + " (HP: " + enemigo.vida_hp + ", Fuerza: " + enemigo.fuerza + ", Velocidad: " + enemigo.velocidad + ")");
        // *Introducción //
        System.out.println("=======================================");
        System.out.println("\"Escucha bien, valiente viajero…");
        System.out.println();
        System.out.println("\"En tiempos inmemoriales, cuando el reino aún estaba en equilibrio, un artefacto sagrado conocido como el Cristal de la Luz Eterna fue forjado por ");
        System.out.println("las manos de los antiguos sabios");
        System.out.println("Su poder traía paz y prosperidad, y los días eran largos y serenos bajo su brillo inmortal.\"");
        System.out.println();
        System.out.println("\"Pero las sombras se han levantado nuevamente.");
        System.out.println("El cristal fue robado y ahora yace oculto en lo profundo de una mazmorra antigua, donde solo aquellos con verdadero coraje se atreven a adentrarse.\"");
        System.out.println();
        System.out.println("\"Se dice que la mazmorra está llena de trampas y criaturas que custodian el Cristal.\"");
        System.out.println();
        System.out.println("\"Tú, " + jugador.nombre + ", portador de la Marca del Coraje, eres nuestro último rayo de esperanza.");
        System.out.println("Toma tu espada y tu escudo, y adéntrate en las profundidades de la mazmorra.");
        System.out.println("Solo con el Cristal de la Luz Eterna podremos restaurar la paz y disipar las sombras de nuestro mundo.\"");
        System.out.println();
        System.out.println("\"Recuerda, joven héroe: cada paso que des pondrá a prueba tu valentía.");
        System.out.println("Pero si logras reunir la fuerza y el coraje necesarios, el poder del Cristal será tuyo, y el reino se salvará.\"");
        System.out.println();
        System.out.println("\"¿Estás listo para entrar en la mazmorra, enfrentarte al guardián y reclamar el Cristal de la Luz Eterna?\"");
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
        System.out.println("¡Es un " + enemigo.nombre + ", un guerrero caído del pasado, que ha regresado para proteger este lugar!\n");
        System.out.println("Su maldad te observa con ira en los ojos, pero puedes sentir la amenaza de su presencia.\n");
        System.out.println("¡Prepárate para luchar por tu vida " + jugador.nombre + "!");
        //*Método de batalla */ 
        pelear(jugador, enemigo);
        System.out.println("\n¡Has derrotado al enemigo y has recuperado el Cristal de la Luz Eterna!");
        System.out.println("Sostienes el cristal en tus manos y sientes cómo el poder de la luz regresa al reino.");
        System.out.println("¡La paz ha sido restaurada, y serás recordado como un héroe por generaciones!");
        scanner.close();
    }
}

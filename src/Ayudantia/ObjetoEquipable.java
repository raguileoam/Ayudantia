package Ayudantia;

public class ObjetoEquipable {

    private int estrella;
    private String habilidad_mejorada;
    private int mejora;
    private String nombre;

    public ObjetoEquipable() {
        String[][] caracteristicas = {{"hp", "atk", "def", "spd"}, {"Armadura", "Arma", "Escudo", "Botas"}};
        this.estrella = probabilidad_estrella();
        this.mejora = Luchador.random_num(1, 9) * getEstrella(); // mejora base de 1 a 9 * estrella/rango
        this.habilidad_mejorada = "";
        this.nombre = "";
        azar_caracteristica_y_nombre(caracteristicas, Luchador.random_num(0, caracteristicas[0].length - 1));
    }

    public ObjetoEquipable(int estrella) { //en el caso de objeto dropeable  de monstruo
        super();
        String[][] caracteristicas = {{"hp", "atk", "def", "spd"}, {"Armadura", "Arma", "Escudo", "Botas"}};
        this.estrella = estrella;
        this.mejora = Luchador.random_num(1, 9) * getEstrella();
        this.habilidad_mejorada = " ";
        this.nombre = " ";
        azar_caracteristica_y_nombre(caracteristicas, Luchador.random_num(0, caracteristicas[0].length - 1));
    }

    protected void azar_caracteristica_y_nombre(String[][] caracteristicas, int indice_caracteristicas) {
        int indice_random = Luchador.random_num(0, caracteristicas[0].length - 1);
        this.setHabilidad_mejorada(caracteristicas[0][indice_random]);
        this.setNombre(caracteristicas[1][indice_random]);
    }

    public int getEstrella() {
        return estrella;
    }

    public String getHabilidad_mejorada() {
        return habilidad_mejorada;
    }

    public int getMejora() {
        return mejora;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrar_caracteristicas() {
        System.out.println("Mejora base: " + getMejora() + "\n Estrellas: " + getEstrella() + "\n Habilidad mejorada: "
                + getHabilidad_mejorada());
    }

    private int probabilidad_estrella() {
        int local_estrella;
        int probabilidad = Luchador.random_num(1, 100);
        if (probabilidad <= 20) {
            local_estrella = 1;
        } else if (probabilidad <= 40) {
            local_estrella = 2;
        } else if (probabilidad <= 60) {
            local_estrella = 3;
        } else if (probabilidad <= 75) {
            local_estrella = 4;
        } else if (probabilidad <= 85) {
            local_estrella = 5;
        } else if (probabilidad <= 90) {
            local_estrella = 6;
        } else if (probabilidad <= 94) {
            local_estrella = 7;
        } else if (probabilidad <= 97) {
            local_estrella = 8;
        } else if (probabilidad <= 99) {
            local_estrella = 9;
        } else {
            local_estrella = 10;
        }
        return local_estrella;
    }

    public void setEstrella(int estrella) {
        this.estrella = estrella;
    }

    public void setHabilidad_mejorada(String habilidad_mejorada) {
        this.habilidad_mejorada = habilidad_mejorada;
    }

    public void setMejora(int mejora) {
        this.mejora = mejora;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

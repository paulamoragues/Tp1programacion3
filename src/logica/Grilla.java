package logica;
public class Grilla {
    private Celda[][] celdas;
    
    // provisorio
    private static final int tamaño = 5;

    public Grilla() {
        celdas = new Celda[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    public void tocarCelda(int fila, int columna) {
    	// provisorio, para que no salte error cuando ingresas numero fuera del rango
        if (fila < 0 || fila >= tamaño || columna < 0 || columna >= tamaño) {
            return;
        }

        Celda celda = celdas[fila][columna];
        celda.cambiarColor();

        if (tieneVecinoDelMismoColor(fila, columna)) {
            apagarVecinas(fila, columna);
        }
    }

    private boolean tieneVecinoDelMismoColor(int fila, int columna) {
        int color = celdas[fila][columna].getColor();

        int[][] direcciones = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : direcciones) {
            int nuevaFila = fila + dir[0];
            int nuevaCol = columna + dir[1];

            if (esPosicionValida(nuevaFila, nuevaCol)) {
                if (celdas[nuevaFila][nuevaCol].getColor() == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private void apagarVecinas(int fila, int columna) {
        celdas[fila][columna].apagar();

        int[][] direcciones = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : direcciones) {
            int nuevaFila = fila + dir[0];
            int nuevaCol = columna + dir[1];

            if (esPosicionValida(nuevaFila, nuevaCol)) {
                celdas[nuevaFila][nuevaCol].apagar();
            }
        }
    }
    
    public boolean estaCompleta() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (celdas[i][j].getColor() == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < tamaño && columna >= 0 && columna < tamaño;
    }
    
    // no va ..
    // provisorio, para probar el juego por terminal
    public void mostrarGrilla() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(celdas[i][j].getColor() + " ");
            }
            System.out.println();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practico_cuarta_parte;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
/**
 *
 * @author furanko
 */

public class Practico_cuarta_parte {
    public static int MINVALOR = 1;
    public static int MAXVALOR = 10;
    public static int MAX = 10;
    public static double valor_probabilidad = 0.4;
    public static void main(String [] args){
        //lo comenzamos de nuevo
        /*
        Ejemplo 9
        • Dado un arreglo DESORDENADO de números entre 1 y 9 de
        tamaño MAX que tiene los elementos sin orden, se pide lo
        siguiente:
        – a) Cargar un arreglo ORDENADO de tamaño MAX (inicializado
        con -1). ORDENADO tiene posiciones del arreglo DESORDENADO
        de forma tal que permite recorrer de forma ascendente y
        consecutiva los valores pares del arreglo DESORDENADO (no se
        pide ordenar ORDENADO). ORDENADO tiene valores -1 al final
        cuando DESORDENADO tiene valores impares.
        – b) Para valores (elemento y posición) ingresados por el usuario, si
        elemento esta entre 1 y 9, es impar, y posición es valida, insertar
        el elemento en DESORDENADO en la posición indicada y luego
        actualizar el arreglo ORDENADO sin acceder a DESORDENADO.
        */
        int[] DESORDENADO = new int[MAX];
	int[] ORDENADO = new int[MAX];
	int pos,elemento;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	try{
            cargar_arreglo_aleatorio(DESORDENADO);
            imprimir_arreglo(DESORDENADO);
            inicializar_arreglo(ORDENADO);
            //Realizar las tareas con arreglos;
            //a
            cargar_arreglo_indice_ord(DESORDENADO,ORDENADO);
            imprimir_arreglo(ORDENADO);
            //b
            System.out.println("Ingrese una posicion menor de "+(MAX-1)+" en el arreglo: ");
            pos = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese un elemento impar entre "+MINVALOR+" y "+(MAXVALOR-1));
            elemento = Integer.valueOf(entrada.readLine());
            if ((elemento>=MINVALOR)&&(elemento<MAXVALOR)&&((elemento%2)!=0)&&(pos>=0)&&(pos<MAX)){
                insertar_elemento_arreglo_pos(DESORDENADO,elemento,pos);
		actualizar_arreglo_ind(ORDENADO,pos);
		imprimir_arreglo(DESORDENADO);
		imprimir_arreglo(ORDENADO);
            }
        }
	catch (Exception exc){
            System.out.println(exc);
	}
        /*
        Para el Ejemplo 9, hacer:
        – c) cargar los índices de los valores pares de DESORDENADO en un arreglo PARES de
        tamaño MAX sin importar el orden.
        – d) ordenar PARES de forma descendente según los valores pares de DESORDENADO
        utilizando un método de ordenamiento.
        */
        //c
        int[] PARES = new int[MAX];
        System.out.println("");
        cargar_arreglo_aleatorio(DESORDENADO);
        imprimir_arreglo(DESORDENADO);
        
        inicializar_arreglo(PARES);
        cargar_arreglo_indice(DESORDENADO,PARES); //con pares (sin orden)
        imprimir_arreglo(PARES);
        
        //d
        System.out.println("");
        ordenar_descendente_arreglo_indice(DESORDENADO,PARES);
        imprimir_arreglo(PARES);
        
        /*
        Se tiene un arreglo ORIGINAL precargado de caracteres letras minúsculas de
        tamaño MAX que está ORDENADO de forma ascendente. Además se tiene un
        arreglo ORDEN1 precargado de tamaño MAX. ORDEN1 tiene posiciones de
        ORIGINAL de forma tal que permita recorrer de forma ascendente y
        consecutiva los caracteres vocales de ORIGINAL. ORDEN1 tendrá valores -1 al
        final en el caso de que ORIGINAL tenga consonantes. Se pide:
        a) Dada una posición ingresada por el usuario desde teclado, eliminar la letra de dicha
        posición en ORIGINAL, y actualizar el arreglo ORDEN1.
        b) Imprimir los caracteres vocales siguiendo el orden establecido en ORIGINAL.
        */
        //crear arreglo char
        char [] ORIGINAL = new char[MAX];
        cargar_arreglo_char_aleatorio(ORIGINAL);
        ordenar_arreglo_char_ascendente(ORIGINAL);
        imprimir_arreglo_char(ORIGINAL);
        
        //crear ORDEN1 e inicializarlo
        int [] ORDEN1 = new int[MAX];
        inicializar_arreglo(ORDEN1);
        //orden1 tiene indices de vocales de forma ascendente de original
        cargar_char_arreglo_indice(ORIGINAL,ORDEN1); //cargamos vocales de forma ascendente
        imprimir_arreglo(ORDEN1);
        //a)
        //obt pos y eliminar letra corriendo a la izq
        try {
            System.out.println("ingrese una posicion del arreglo para eliminar el carácter..");
            pos = Integer.valueOf(entrada.readLine());
            eliminar_elemento_char_arreglo_pos(ORIGINAL,pos); //corriendo hacia la izq
            imprimir_arreglo_char(ORIGINAL);
            //actualizar orden1
            actualizar_arreglo_ind_eliminacion(ORIGINAL,ORDEN1,pos); //usando pos sin usar original //PD agrege el or pq: checkea el codigo
            imprimir_arreglo(ORDEN1);
        } catch (Exception e) {
        }
        
        //b)
        //mostrar los caracteres vocales (de original)
        mostrar_vocales_arreglo(ORIGINAL);
        
        /*
        Se tiene un arreglo DESORDENADO precargado de secuencias de números de
        tamaño MAX con ceros entre secuencias, al principio y al final del arreglo.
        Además se tiene un arreglo ORDEN1 precargado de tamaño MAX. ORDEN1
        tiene posiciones de inicio de secuencia de DESORDENADO que permite recorrer de
        forma ascendente y consecutiva las secuencias que suman una cantidad par
        (ORDEN1 tiene valores -1 al final de las posiciones válidas). Se pide:
        a) Dada una posición válida ingresada por el usuario desde teclado, eliminar la
        secuencia en DESORDENADO con inicio en esa posición y actualizar el arreglo ORDEN1.
        */
        System.out.println("secuencias..");
        //meterle secuencias a desordenado (int) 0 y max-1 con "0"
        cargar_arreglo_secuencia(DESORDENADO);
        imprimir_arreglo(DESORDENADO);
        //inicializar orden1
        inicializar_arreglo(ORDEN1);
        //ordenar orden1
        cargar_secuencia_arreglo_indice(DESORDENADO,ORDEN1); //insertamos pos inicio de secuencias q su suma de par manera ascendente
        imprimir_arreglo(ORDEN1);
        
        //a)
        //obtener pos
        try {
            System.out.println("ingrese pos inicial de alguna secuencia para eliminarla..");
            pos = Integer.valueOf(entrada.readLine());
            eliminar_pos_arreglo_secuencia(DESORDENADO,pos);  //corriendo hacia la izq //pos refiere a la pos de inicio
            imprimir_arreglo(DESORDENADO);
            //actualizar ORDEN1
            inicializar_arreglo(ORDEN1);
            cargar_secuencia_arreglo_indice(DESORDENADO,ORDEN1);
            imprimir_arreglo(ORDEN1);
        } catch (Exception e) {
        }
        
        /*
        c) cargar los índices de inicio de todas secuencias en el arreglo ORDEN2 de tamaño
        MAX, que está inicializado con -1.
        d) Suponiendo que hay un método que permite ordenar de forma ascendente un
        arreglo de las características de ORDEN2 (el método ordena los índices de inicio de
        secuencia de según el tamaño de las secuencias a los que hacen referencia),
        generar un arreglo ORDEN3 de tamaño MAX de índices de las secuencias de
        DESORDENADO con el orden mencionado (deberá definir además los encabezados de
        el/los método/s prexistentes y hacer las llamadas cuando los utilice).
        */
        //c)
        //crear orden2
        int [] ORDEN2 = new int[MAX];
        cargar_arreglo_arreglo(ORDEN1,ORDEN2);
        System.out.println("orden2..");
        imprimir_arreglo(ORDEN2);
        
        //d)
        //crear orden3
        int [] ORDEN3 = new int[MAX];
        inicializar_arreglo(ORDEN3);
        //hacer metodo que ordene arr indices x tamaño de secuencias ascendentemente usando orden2 y meterselo a orden 3
        //al segundo arrindice se lo va a ordenar x tamaño de manera ascendente
        /*muy cheto este metodo bastante complejo*/
        ordenar_arreglo_ind_arreglo_ind(ORDEN2,ORDEN3,DESORDENADO); //el primer arreglo_ind tiene indices de inicio de secuencia
        imprimir_arreglo(ORDEN3);
        
        /*
        Suponer que se tiene un arreglo precargado de caracteres letras minúsculas de
        tamaño MAX. Se tiene además los siguientes métodos:
        a) Un método que retorna cuantas repeticiones en el arreglo tiene un carácter
        ingresado como parámetro.
        b) Un método que ordena un arreglo de forma descendente por cantidad de
        caracteres que se repiten, por ejemplo genera |’t’|’t’|’t’|’a’|’a’|’r’|’e’|.
        c) Hacer un programa que:
        1) dado un numero positivo ingresado x el usuario, imprima por pantalla los caracteres
        vocales con cantidad mayor a la cantidad ingresada sin realizar recorridos innecesarios.
        Por ejemplo si se ingresa un 2 imprime ‘a’ y no sigue recorriendo el arreglo.
        2) mientras el usuario ingrese una vocal consonante minúscula muestre por pantalla la
        cantidad de repeticiones de dicha consonante.
        3) deberá definir además los encabezados de el/los método/s prexistentes y hacer las 33
        llamadas cuando los utilice.
        */
        //ORIGINAL es el arreglo precargado de caracteres
        //a)
        //obtener caracter
        char caracter;
        try {
            System.out.println("");
            System.out.println("ingrese un caracter, se mostrara la cantidad q hay en el arreglo");
            caracter = entrada.readLine().charAt(0);
            //sout(retornar_cantidad_caracter_arreglo_pos(original,caracter)//retorna nro entero x caracteres iguales al ingresado)
            System.out.println("Cantidad de '"+caracter+"': "+retornar_cantidad_caracter_arreglo_pos(ORIGINAL,caracter));
        } catch (Exception e) {
        }
        
        //b)
        /*algun dia lo debugearé*/
        //ordenar_tamanio_caracteres_arreglo(ORIGINAL); //ordenamos de manera descendente x tamaño
        //imprimir_arreglo_char(ORIGINAL);
        
        
        //c)1)
        //obtener nro positivo
        int entero;
        try {
            System.out.println("ingrese un numero positivo..");
            entero = Integer.valueOf(entrada.readLine());
            //mostrar caracter que tenga un tamaño mayor a ese nro (cuando lo encuentra para de recorrer)
            mostrar_primer_caracter_tamanio_mayor_entero_arreglo_char(ORIGINAL,entero);
        } catch (Exception e) {
        }
        
        //2)
        //obtener caracter
        char carac;
        try {
            System.out.println("ingrese un caracter minuscula consonante..");
            carac = entrada.readLine().charAt(0);
            //si es consonante minúscula mostrar nro de veces q está en el arreglo
            mostrar_nro_veces_aparece_arr_char_caracter(ORIGINAL,carac); //mostrar consonante minuscula
        } catch (Exception e) {
        }
        
        //3)no entendí xd

   }
    public static void insertar_elemento_arreglo_pos(int[] original,int elemento,int pos){
	corrimiento_der(original,pos);
	original[pos] = elemento;
    }

    public static void actualizar_arreglo_ind(int[] arrindices,int pos){
	int posicion = 0;
	while ((posicion < MAX) && (arrindices[posicion] != -1)){
            if (arrindices[posicion] >= pos){
                arrindices[posicion]++;
                if (arrindices[posicion] >= MAX){
                    corrimiento_izq(arrindices,posicion);
                }
            }
            posicion++;
	}
    }

    public static void cargar_arreglo_indice_ord(int[] original,int[] arrindices){
	for (int pos = 0; pos < MAX; pos++){
            if ((original[pos]%2) == 0){
		insertar_ordenado_arreglo_pos(original,arrindices,pos);
            }
        }
    }

    public static void insertar_ordenado_arreglo_pos(int[] original,int[] arrindices,int pos){
	int posicion=buscar_pos_arreglo_ord(original,arrindices,pos);
	if (posicion<MAX){
            corrimiento_der(arrindices,posicion);
            arrindices[posicion]=pos;
	}
    }

    public static int buscar_pos_arreglo_ord(int[] original,int[] arrindices,int pos){
        int posicion=0;
	while ((posicion<MAX) && (arrindices[posicion]!=-1) && (original[arrindices[posicion]]<=original[pos])){
		posicion++;
	}
	return posicion;
    }

    public static void corrimiento_izq(int[] arr,int pos) {
        while (pos<MAX-1){
            arr[pos] = arr[pos+1];
            pos++;
	}
    }  

    public static void corrimiento_der(int[] arr,int pos) {
	int actual = MAX-1;
	while (pos<actual){
            arr[actual] = arr[actual-1];
            actual--;
	}
    }    

    public static void inicializar_arreglo(int [] arr){
	for (int pos = 0; pos < MAX; pos++){
            arr[pos] = -1;
	}
    }

    public static void cargar_arreglo_aleatorio(int [] arr){
	for (int pos = 0; pos < MAX; pos++){
            arr[pos]=(int)((MAXVALOR-MINVALOR)*Math.random() + MINVALOR);  
	}
    }    

    public static void imprimir_arreglo(int [] arr){
	for (int pos = 0; pos < MAX; pos++){
            System.out.print("|"+arr[pos]);
	}   
    	System.out.println("|");
    }  		
    public static void cargar_arreglo_indice(int [] original,int [] arrindices){
        int posicion = 0; //posicion del arrindices
        for (int pos = 0; pos < MAX; pos++) {
            if((original[pos]%2)==0){
                arrindices[posicion] = pos;
                posicion++;
            }
        }
    }
    public static void ordenar_descendente_arreglo_indice(int [] original,int arrindices[]){
        //por metodo de ordenamiento seleccion
        int aux, pos_mayor;
        int i = 0;
        while((i < MAX-1)&&(arrindices[i] != -1)){
            pos_mayor = i;
            int j = i+1;
            while((j < MAX)&&(arrindices[j] != -1)){
                if(original[arrindices[j]] > original[arrindices[pos_mayor]]){
                    pos_mayor = j;
                }
                j++;
            }
            if(i != pos_mayor){
                aux = arrindices[i];
                arrindices[i] = arrindices[pos_mayor];
                arrindices[pos_mayor] = aux;
            }
            i++;
        }
    }
    public static void cargar_arreglo_char_aleatorio(char [] arr){
        Random r = new Random();
        for (int posicion = 0; posicion < MAX; posicion++) {
            arr[posicion] = (char) (r.nextInt(26) + 'a');
        }
    }
    public static void ordenar_arreglo_char_ascendente(char [] arr){
        //ordeno con algoritmo de seleccion
        int menor;
        char aux;
        for (int i = 0; i < MAX-1; i++) {
            menor = i;
            for (int j = i+1; j < MAX; j++) {
                if(arr[j] < arr[menor]){
                    menor = j;
                }
            }
            if(i != menor){
                aux = arr[i];
                arr[i] = arr[menor];
                arr[menor] = aux;
            }
        }
    }
    public static void imprimir_arreglo_char(char [] arr){
        for (int posicion = 0; posicion < MAX; posicion++) {
            System.out.print("|"+arr[posicion]);
        }
        System.out.println("|");
    }
    public static void cargar_char_arreglo_indice(char [] original,int [] arrindices){
        //inicializamos para evitar doble index
        inicializar_arreglo(arrindices);
        
        for (int pos = 0; pos < MAX; pos++) {
            switch (original[pos]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    insertar_char_ordenado_arreglo_pos(original,arrindices,pos); //ORDENADO refiere a ascendente
                    break;
                default:
                    break;
            }
        }
    }
    public static void insertar_char_ordenado_arreglo_pos(char original[],int arrindices[],int pos){
        int posicion;
        posicion = buscar_pos_arreglo_indice_ord_char(original,arrindices,pos);
        if(posicion < MAX){
            corrimiento_der(arrindices,posicion);
            arrindices[posicion] = pos;
        }
    }
    public static int buscar_pos_arreglo_indice_ord_char(char [] original,int arrindices[],int pos){
        int posicion = 0;
        while((posicion < MAX)&&(arrindices[posicion]!=-1)&&(original[arrindices[posicion]]<original[pos])){
            posicion++;
        }
        return posicion;
    }
    public static void eliminar_elemento_char_arreglo_pos(char [] arr,int pos){
        int posicion = 0;
        while((posicion != pos)&&(posicion < MAX)){
            posicion++;
        }
        if(posicion == pos){
            corrimiento_char_izq(arr,pos);
        }
    }
    public static void corrimiento_char_izq(char[] arr,int pos) {
        while (pos<MAX-1){
            arr[pos] = arr[pos+1];
            pos++;
	}
    }
    public static void actualizar_arreglo_ind_eliminacion(char original[],int[] arrindices,int pos){
	int posicion = 0;
	while ((posicion < MAX) && (arrindices[posicion] != -1)){
            if (arrindices[posicion] == pos){
                    corrimiento_izq(arrindices,posicion);
            }
            if (arrindices[posicion] > pos){
                    arrindices[posicion]--;
                    }
            posicion++;
	}
        //por si sale una vocal en la ult pos
        cargar_char_arreglo_indice(original,arrindices);
    }
    public static void mostrar_vocales_arreglo(char [] arr){
        System.out.print("caracteres vocales en arreglo char: ");
        for (int posicion = 0; posicion < MAX; posicion++) {
            switch (arr[posicion]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.print(arr[posicion]+" "); //ORDENADO refiere a ascendente
                    break;
                default:
                    break;
            }
        }
        System.out.println("");
    }
    public static void cargar_arreglo_secuencia(int arr[]){
        arr[0] = 0;
        arr[MAX-1] = 0;
        Random r = new Random();
        for (int posicion = 1; posicion < MAX-2; posicion++) {
            if(r.nextDouble()>valor_probabilidad){
                arr[posicion] = (r.nextInt(MAXVALOR-MINVALOR)+MINVALOR);
            }else{
                arr[posicion] = 0;
            }
        }
    }
    public static void cargar_secuencia_arreglo_indice(int original[],int arrindices[]){
        int fin = -1;
        int inicio = fin;
        int suma, posicion;
        while(inicio < MAX-1){
            inicio = obtener_secuencia_pos_inicio_arreglo(original,fin+1);
            if(inicio < MAX-1){
                fin = obtener_secuencia_pos_fin_arreglo(original,inicio);
                suma = obtener_secuencia_suma_arreglo(original,inicio);
                if((suma%2)==0){
                    posicion = buscar_pos_suma_secuencia_arreglo_indice_ord(original,arrindices,inicio);
                    if (posicion<MAX){
                            corrimiento_der(arrindices,posicion);
                            arrindices[posicion] = inicio;
                    }
                }
            }
        }
    }
    public static int obtener_secuencia_pos_inicio_arreglo(int arr[],int fin){
        int inicio = fin;
        while((arr[inicio] == 0)&&(inicio < MAX-1)){
            inicio++;
        }
        return inicio;
    }
    public static int obtener_secuencia_pos_fin_arreglo(int [] arr,int inicio){
        int fin = inicio;
        while(arr[fin] != 0){
            fin++;
        }
        return --fin;
    }
    public static int obtener_secuencia_suma_arreglo(int arr[],int inicio){
        int suma = 0;
        while(arr[inicio] != 0){
            suma += arr[inicio];
            inicio++;
        }
        return suma;
    }
    public static int buscar_pos_suma_secuencia_arreglo_indice_ord(int original[],int arrindices[],int inicio){
        int posicion = 0;
        while((posicion<MAX)&&(arrindices[posicion]!=-1)&&(obtener_secuencia_suma_arreglo(original,arrindices[posicion])<obtener_secuencia_suma_arreglo(original,inicio))){
            posicion++;
        }
        return posicion;
    }
    public static void eliminar_pos_arreglo_secuencia(int arr[],int inicio){
        int fin = obtener_secuencia_pos_fin_arreglo(arr,inicio);
        int indice = inicio;
        while(indice <= fin){
            corrimiento_izq(arr,inicio);
            indice++;
        }
    }
    public static void cargar_arreglo_arreglo(int original[],int copia[]){
        for (int posicion = 0; posicion < MAX; posicion++) {
            copia[posicion] = original[posicion];
        }
    }
    public static void ordenar_arreglo_ind_arreglo_ind(int [] arrindice/*original*/,int arrindices[],int original[]){
        int posicion = 0;//recorremos arrindice (original)
        while((posicion<MAX)&&(arrindice[posicion]!=-1)){
            int posicion1 = buscar_pos_tamanio_secuencia_arreglo_indice_ord(original,arrindices,arrindice[posicion]); //posicion1 es saber donde insertar el index a arrindiceS
            if (posicion<MAX){
                corrimiento_der(arrindices,posicion1);
                arrindices[posicion1]=arrindice[posicion];
            }
            posicion++;
        }
        
    }
    public static int obtener_secuencia_tamanio_arreglo(int original[],int inicio){
        int tamanio = 0;
        while(original[inicio]!=0){
            tamanio++;
            inicio++;
        }
        return tamanio;
    }
    public static int buscar_pos_tamanio_secuencia_arreglo_indice_ord(int original[],int arrindices[],int inicio){
        int posicion = 0;
        while((posicion<MAX)&&(arrindices[posicion]!=-1)&&(obtener_secuencia_tamanio_arreglo(original,arrindices[posicion])<obtener_secuencia_tamanio_arreglo(original,inicio))){
            posicion++;
        }
        return posicion;
    }
    public static int retornar_cantidad_caracter_arreglo_pos(char arr[],char caracter){
        int cantidad = 0;
        for (int posicion = 0; posicion < MAX; posicion++) {
            if(arr[posicion] == caracter){
                cantidad++;
            }
        }
        return cantidad;
    }
    public static void ordenar_tamanio_caracteres_arreglo(char[]arr){
        //ordenar con metodo de seguimiento
        ordenar_arreglo_char_ascendente(arr);
        //ir recorriendo los conjuntos de caracteres iguales
        int fin = -1;
        int inicio = fin;
        while(inicio<MAX-1){//recorremos el primer conjunto para comparar con los demás conjuntos
            inicio = fin+1;
            if (inicio<MAX-1) {
                fin = obtener_pos_fin_caracteres_iguales_arreglo(arr,inicio);
                //determinamos que el de arriba q recorrimos es el mayor
                int tamanioMayor = fin-inicio+1;//con esta formula sacamos el tamaño
                int inicioMayor = inicio; 
                int finMayor = fin;
                //recorremos los siguientes conjuntos
                int fin1 = fin;
                int inicio1 = fin1;
                while(inicio1<MAX-1){
                    inicio1 = fin1+1;
                    if (inicio1<MAX-1){
                        fin1 = obtener_pos_fin_caracteres_iguales_arreglo(arr,inicio1);
                        if(fin1-inicio1+1/*si su tamaño es mayor al mayor actual..*/>tamanioMayor){
                            //obtener el mayor de todos
                            //este lo hacemos para q no compare con el primero sino con el mayor hasta el momento
                            tamanioMayor = fin1-inicio1+1;
                            //guardamos sus posiciones para dsp mover
                            inicioMayor = inicio1;
                            finMayor = fin1;
                        }
                    }
                }
                if(tamanioMayor != fin-inicio+1){//si el con mayor tamaño no es el primero entonces..
                    //posicionamos el mas grande al principio
                    int i = tamanioMayor;
                    int tamanio = tamanioMayor;
                    char[]auxarr = new char[tamanio];
                    copiar_secuencia_aux_char(arr,auxarr,inicio1,fin1); //copiamos el conjunto mas grande en arraux
                    while(tamanioMayor>0){
                        corrimiento_char_izq(arr,inicio1); //nos chupamos el mas grande
                        tamanioMayor--;
                    }
                    while(i>0){
                        //hacemos espacio para insertar el auxarr las veces teniendo en cuenta el tamaño del primer conjunto
                        corrimiento_char_der(arr,inicio);
                        i--;
                    }
                    insertar_aux_arreglo_char(arr,auxarr,inicio,tamanio);
                    fin += tamanio-1;
                }
            }
        }  
    }
    public static int obtener_pos_fin_caracteres_iguales_arreglo(char arr[],int inicio){
        int fin = inicio;
        while((arr[fin] == arr[inicio])&&(fin<MAX-1)){
            fin++;
        }
        if(fin==MAX-1){
            return fin;
        }
        return --fin;
    }
    public static void copiar_secuencia_aux_char(char[]original,char []auxarr,int inicio,int fin){
        int posicion = 0; //pos de arraux
        while(inicio<=fin){
            auxarr[posicion] = original[inicio];
            posicion++;
            inicio++;
        }
    }
    public static void corrimiento_char_der(char []arr,int posicion){
        int actual = MAX-1;
	while (posicion<actual){
            arr[actual] = arr[actual-1];
            actual--;
	}
    }
    public static void insertar_aux_arreglo_char(char[]arr,char[]auxarr,int inicio,int tamanio){
        int posicion = inicio;
        int i = 0;
        while(i<tamanio){
            arr[posicion] = auxarr[i];
            i++;
            posicion++;
        }
    }
    public static void mostrar_primer_caracter_tamanio_mayor_entero_arreglo_char(char arr[],int tamanio){
        int fin = -1;
        int inicio = fin;
        while(inicio<MAX-1){
            inicio = fin+1;
            if (inicio<MAX-1) {
                fin = obtener_pos_fin_caracteres_iguales_arreglo(arr,inicio);
                if(fin-inicio+1>tamanio){
                    System.out.println("El conjunto de caracter '"+arr[inicio]+"' tiene un tamaño mayor que "+tamanio+".");
                    inicio = MAX-1;
                }
            }
        }
    }
    public static void mostrar_nro_veces_aparece_arr_char_caracter(char arr[],char caracter){
        int cantidad = 0;
        if((caracter <= 'z')&&(caracter >= 'a')){
            switch (caracter) {
                case 'a':
                case 'e':    
                case 'i':
                case 'o':
                case 'u':
                    break;
                default:
                    for(int posicion = 0; posicion < MAX; posicion++){
                        if(arr[posicion] == caracter){
                            cantidad++;
                        }
                    }
                    System.out.println("hay "+cantidad+" '"+caracter+"' en el arreglo..");
            }
        }
    }
}

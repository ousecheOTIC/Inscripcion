package MatrizRegresionn;
//La idea es que autmaticamente renueve la planilla de participantes con ruts permitidos


import java.io.File;

public class RenovarRutsPlanillaParticipantes extends Login2 {

    public void levantarExloradorArchivos ()throws InterruptedException{
        // Especifica la carpeta en la que deseas buscar
        String directorioBusqueda = "Documentos";

        // Especifica el nombre del archivo que estás buscando
        String nombreArchivoBuscado = "Carga Masiva Par - SIN ERROR.xlsx";

        // Llama a la función para buscar el archivo
        buscarArchivoExcelEnDirectorio(directorioBusqueda, nombreArchivoBuscado);
         Thread.sleep(10000);

    }

    private static void buscarArchivoExcelEnDirectorio(String directorio, String nombreArchivo) {
        File folder = new File(directorio);

        // Verifica si el directorio existe
        if (folder.exists() && folder.isDirectory()) {
            // Obtén una lista de archivos en el directorio
            File[] archivos = folder.listFiles();

            // Verifica cada archivo en la lista
            if (archivos != null) {
                for (File archivo : archivos) {
                    // Compara el nombre del archivo y verifica si tiene la extensión de Excel
                    if (archivo.isFile() && archivo.getName().equalsIgnoreCase(nombreArchivo) && esArchivoExcel(archivo)) {
                        System.out.println("¡El archivo Excel fue encontrado en: " + archivo.getAbsolutePath());
                        return; // Puedes detener la búsqueda una vez que encuentres el archivo
                    }
                }

                // Si llegas a este punto, significa que el archivo no fue encontrado
                System.out.println("El archivo Excel '" + nombreArchivo + "' no fue encontrado en el directorio.");
            } else {
                System.out.println("No se pudieron obtener archivos del directorio.");
            }
        } else {
            System.out.println("El directorio especificado no existe o no es un directorio.");
        }
    }

    private static boolean esArchivoExcel(File archivo) {
        // Verifica si el nombre del archivo tiene la extensión de Excel
        return archivo.getName().toLowerCase().endsWith(".xls") || archivo.getName().toLowerCase().endsWith(".xlsx");
    }

}












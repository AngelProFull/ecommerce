package com.aplication.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
//Guardar Imagen.
public class ObtenerArchivoService {
    //Ubicación para cargar las imágenes. Creamos una carpeta en la raiz de nuestro proyecto.
    private String carpeta = "imagenes//";

    //Como parámetro viene un Objeto de tipo MultipartFile
    public String guardarImagen(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            //Pasamos la imagen al byte para poder enviar desde el cliente al servidor.
            byte[] bytes = file.getBytes();
            //En esta ruta quiero que se guarde.
            Path path = Paths.get(carpeta + file.getOriginalFilename());
            //Le pasamos la ruta y la variable bytes
            Files.write(path, bytes);
            return file.getOriginalFilename();
        }
        return "default.jpg";
    }

    //Eliminar imagen.

    public void eliminarImagen(String nombreImagen) {
        String ruta = "imagenes//";
        File file = new File(ruta + nombreImagen);
        file.delete();
    }
}
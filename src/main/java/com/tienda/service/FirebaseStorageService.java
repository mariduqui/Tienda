
package com.tienda.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
        public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-m-388a5.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-m-388a5-firebase-adminsdk-20zzx-25d5d0d37e.json";
    
    
}

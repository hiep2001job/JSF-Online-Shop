/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public final class Utils {

    private Utils() {
    }

    public static String getRandomNumber(int min, int max) {
        return String.valueOf(((Math.random() * (max - min)) + min));
    }

    public static String uploadFile(Part file, String destination, String saveName) throws IOException {
        boolean fileSuccess = false;
        String path = "";
        if (file != null && file.getSize() > 0) {
            String fileName = Utils.getFileNameFromPart(file);

            /**
             * destination where the file will be uploaded
             */
            File savedFile = new File("web/resources/uploads/", fileName);

            // System.out.println("savedFile.toPath(): " + savedFile.toPath());
            try ( InputStream input = file.getInputStream()) {
                Files.copy(input, savedFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            path = savedFile.getPath();
            fileSuccess = true;

        }

        return fileSuccess ? path : null;
    }

    public static String getFileNameFromPart(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                String fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                return fileName;
            }
        }
        return null;
    }

}

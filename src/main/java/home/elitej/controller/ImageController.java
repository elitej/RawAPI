package home.elitej.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImageController extends BaseController {

    private static final String PATH_TO_IMAGE = "c:\\java\\Projects\\images\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageId = req.getParameter("imageId");
        String fileName = PATH_TO_IMAGE + imageId;
        try (BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(fileName));
             BufferedOutputStream buffOut = new BufferedOutputStream(resp.getOutputStream())) {
            byte[] buffer = new byte[8192];
            int numBytes;
            while ((numBytes = buffIn.read(buffer)) != -1)
                buffOut.write(buffer, 0, numBytes);
        } catch (FileNotFoundException e) {
            System.out.println("Log not found");
        }
    }
}

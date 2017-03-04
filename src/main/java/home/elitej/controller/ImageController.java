package home.elitej.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImageController extends BaseController {

    private static final String PATH_TO_IMAGE = "c:\\java\\Projects\\images\\";

    private static Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/*");
        String imageId = req.getPathInfo().substring(1);
        String fileName = PATH_TO_IMAGE + imageId;
        logger.debug("tries find and download the image with name \"{}\"", imageId);
        try (BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(fileName));
             BufferedOutputStream buffOut = new BufferedOutputStream(resp.getOutputStream())) {
            byte[] buffer = new byte[2048];
            int numBytes;
            while ((numBytes = buffIn.read(buffer)) != -1)
                buffOut.write(buffer, 0, numBytes);
            logger.debug("the image with name \"{}\" was sent to the client", imageId);

        } catch (FileNotFoundException e) {
            logger.warn("the image with name \"{}\" not found", imageId);
        }
    }
}

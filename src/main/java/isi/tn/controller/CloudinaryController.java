package isi.tn.controller;
import isi.tn.entities.UploadResponse;
import isi.tn.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CloudinaryController {
    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    @ResponseBody
    public UploadResponse upload(@RequestParam MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return null;
        }
        Map result = cloudinaryService.upload(multipartFile);
        System.out.println("multipartFile = " + multipartFile);
        UploadResponse response = new UploadResponse( (String) result.get("original_filename"), (String) result.get("url"), (String) result.get("public_id") );
        System.out.println("response = " + response);
        return response;
    }

    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<Image> imageOptional = imageService.getOne(id);
        if (imageOptional.isEmpty()) {
            return new ResponseEntity<>("n'existe pas", HttpStatus.NOT_FOUND);
        }
        Image image = imageOptional.get();
        String cloudinaryImageId = image.getImageId();
        try {
            cloudinaryService.delete(cloudinaryImageId);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to delete image from Cloudinary", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        imageService.delete(id);
        return new ResponseEntity<>("image supprimée !", HttpStatus.OK);
    }*/

}

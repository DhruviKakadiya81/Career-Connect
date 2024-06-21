package CdiPC;

import ClientPC.Career_Connect_Client;
import EntityPC.UserMaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author HP
 */
@Named(value = "profileCdi")
@RequestScoped
public class ProfileCdi {

    @Inject
    private Career_Connect_Client careerClient;

    private Collection<UserMaster> userCollection;
    private UserMaster userTbl;
    private GenericType<Collection<UserMaster>> userGeneric;

    public ProfileCdi() {
        userCollection = new ArrayList<>();
        userTbl = new UserMaster();
        userGeneric = new GenericType<Collection<UserMaster>>() {
        };
    }

    public Collection<UserMaster> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<UserMaster> userCollection) {
        this.userCollection = userCollection;
    }

    public UserMaster getUserTbl() {
        return userTbl;
    }

    public void setUserTbl(UserMaster userTbl) {
        this.userTbl = userTbl;
    }

    private Part pro_img;
    private Part resume;
    private String text;
    private String uniqueFileName;

    public Part getPro_img() {
        return pro_img;
    }

    public void setPro_img(Part pro_img) {
        this.pro_img = pro_img;
    }

    public Part getResume() {
        return resume;
    }

    public void setResume(Part resume) {
        this.resume = resume;
    }

    public void saveFile() throws IOException {
        InputStream input = pro_img.getInputStream();
        String path = "F:\\Projects\\Career-Connect\\src\\main\\webapp\\uploaded_img";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        String temp = sb.toString();

        text = "IMG_" + temp + pro_img.getSubmittedFileName();
        Files.copy(input, new File(path, text).toPath());
    }

    private void saveResume() throws IOException {
        if (resume != null && resume.getSize() > 0) {
            String fileName = resume.getSubmittedFileName();
            InputStream fileContent = resume.getInputStream();

            // Create a folder to store the uploaded files
            String uploadFolder = "F:\\Projects\\Career-Connect\\src\\main\\webapp\\uploaded_resume";

            // Create the folder if it doesn't exist
            File folder = new File(uploadFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Generate a unique file name to avoid overwriting existing files
            uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;

            // Save the file to the server
            File file = new File(uploadFolder, uniqueFileName);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();

            // Reset the uploaded file so that it can be processed again
            resume = null;
        }
    }

    public String saveProfile() {
        String fname = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("fname");
        String lname = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lname");
        String email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
        String password = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("password");
        String mobileno = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mobileno");

        if (fname != null && lname != null && email != null && password != null && mobileno != null) {
            try {
                Date BirthDate = userTbl.getBirthDate();
                String BirthDateStr = new SimpleDateFormat("yyyy-MM-dd").format(BirthDate);

                saveFile();
                saveResume();

                careerClient.userRegistration(fname, lname, email, mobileno, text, BirthDateStr, userTbl.getAddressLine(), userTbl.getCity(), userTbl.getState(), String.valueOf(userTbl.getPincode()), password, uniqueFileName);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("fname");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("lname");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("email");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("password");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("mobileno");

                return "Login";
            } catch (Exception e) {
                // Handle the exception
                return "error";
            }
        } else {
            // Handle the case where session values are null
            return "error";
        }
    }

    public String GotoUpdateProfile() {
        return "UpdateProfile";
    }
}

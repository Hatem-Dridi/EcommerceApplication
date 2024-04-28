package isi.tn.entities;

import java.io.Serializable;

public class UploadResponse implements Serializable {
    private String original_filename;
    private String url;
    private String public_id;

    public UploadResponse(String original_filename, String url, String public_id) {
        this.original_filename = original_filename;
        this.url = url;
        this.public_id = public_id;
    }

    public String getOriginal_filename() {
        return original_filename;
    }

    public String getUrl() {
        return url;
    }

    public String getPublic_id() {
        return public_id;
    }
}

package sg.edu.rp.c346.id20020509.mypracticeapp;

import java.io.Serializable;

public class Practice implements Serializable {

    private int id;
    private String description;
    private int stars;

    public Practice(int id, String description, int stars) {
        this.id = id;
        this.description = description;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public Practice setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Practice setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getStars() {
        return stars;
    }

    public Practice setStars(int stars) {
        this.stars = stars;
        return this;
    }

}

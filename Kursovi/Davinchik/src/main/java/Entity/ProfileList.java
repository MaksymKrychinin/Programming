package Entity;

import java.util.ArrayList;
import java.util.List;

public class ProfileList {
    public ProfileList() {
        this.profileList = new ArrayList<>();
    }

    List<Profile> profileList;


    public List<Profile> getProfileList() {
        return profileList;
    }

    public void addProfileList(Profile profile) {
        profileList.add(profile);
    }

}

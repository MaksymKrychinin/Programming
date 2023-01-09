package Model;

import Entity.ProfileList;

public interface InviteDAO {
    ProfileList accountInvitesList(int id);

    ProfileList accountFriendsList(int id);

    ProfileList accountSearchList(String likeAn);
}

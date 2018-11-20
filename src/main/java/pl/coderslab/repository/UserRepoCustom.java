package pl.coderslab.repository;

import pl.coderslab.entity.User;

public interface UserRepoCustom {
    public User myCustomFindById(int id);

    public void changeUsername(String username, int id);
    public void changeEmail(String email, int id);
    public void changePassword(String password, int id);
}

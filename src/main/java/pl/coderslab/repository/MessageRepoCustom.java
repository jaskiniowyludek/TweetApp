package pl.coderslab.repository;

import pl.coderslab.entity.Message;

public interface MessageRepoCustom {

    public Message myCustomFindById(int id);

    public void changeReaded(boolean readed, int id);
}

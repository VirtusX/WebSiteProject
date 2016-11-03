package com.virtusx.DB;

import javax.persistence.*;

/**
 * Created by x-13 on 02.11.2016.
 */
@Entity
@Table(name = "user_games", schema = "mydb", catalog = "")
public class UserGamesEntity {
    private int gUId;
    private int userId;
    private int gameId;

    @Id
    @Column(name = "g_u_id", nullable = false)
    public int getgUId() {
        return gUId;
    }

    public void setgUId(int gUId) {
        this.gUId = gUId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "game_id", nullable = false)
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGamesEntity that = (UserGamesEntity) o;

        if (gUId != that.gUId) return false;
        if (userId != that.userId) return false;
        if (gameId != that.gameId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gUId;
        result = 31 * result + userId;
        result = 31 * result + gameId;
        return result;
    }
}

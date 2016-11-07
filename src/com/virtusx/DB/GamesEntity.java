package com.virtusx.DB;

import javax.persistence.*;

@Entity
@Table(name = "games", schema = "mydb")
public class GamesEntity {
    private int gameId;
    private String gameName;
    private String gameAuthors;
    private String gamePic;
    private String gameAbout;

    @Id
    @Column(name = "game_id", nullable = false)
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "game_name", nullable = false, length = 45)
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Basic
    @Column(name = "game_authors", nullable = false, length = 45)
    public String getGameAuthors() {
        return gameAuthors;
    }

    public void setGameAuthors(String gameAuthors) {
        this.gameAuthors = gameAuthors;
    }

    @Basic
    @Column(name = "game_pic", length = 45)
    public String getGamePic() {
        return gamePic;
    }

    public void setGamePic(String gamePic) {
        this.gamePic = gamePic;
    }

    @Basic
    @Column(name = "game_about", length = 300)
    public String getGameAbout() {
        return gameAbout;
    }

    public void setGameAbout(String gameAbout) {
        this.gameAbout = gameAbout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GamesEntity that = (GamesEntity) o;

        return gameId == that.gameId && (gameName != null ? gameName.equals(that.gameName) : that.gameName == null && (gameAuthors != null ? gameAuthors.equals(that.gameAuthors) : that.gameAuthors == null && (gamePic != null ? gamePic.equals(that.gamePic) : that.gamePic == null && (gameAbout != null ? gameAbout.equals(that.gameAbout) : that.gameAbout == null))));

    }

    @Override
    public int hashCode() {
        int result = gameId;
        result = 31 * result + (gameName != null ? gameName.hashCode() : 0);
        result = 31 * result + (gameAuthors != null ? gameAuthors.hashCode() : 0);
        result = 31 * result + (gamePic != null ? gamePic.hashCode() : 0);
        result = 31 * result + (gameAbout != null ? gameAbout.hashCode() : 0);
        return result;
    }
}
